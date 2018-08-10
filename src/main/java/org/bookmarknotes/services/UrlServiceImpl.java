package org.bookmarknotes.services;

import org.bookmarknotes.dto.UrlDTO;
import org.bookmarknotes.entities.URLEntity;
import org.bookmarknotes.entities.UserEntity;
import org.bookmarknotes.repository.URLRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by zealot on 08.08.18.
 */
@Service
public class UrlServiceImpl extends CommonService<UrlDTO> implements UrlService {
    private URLRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public void setRepository(URLRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(String url) {
        UserEntity user = getUser();
        URLEntity entity = new URLEntity();
        repository.save(entity.setOwner(user).setUrl(url));
    }

    @Override
    @Transactional
    public List<UrlDTO> findByUser(UserEntity u, PageRequest of) {
        return repository.findByUser(u, of).stream().map(urlEntity
                -> convert(urlEntity)).collect(Collectors.toList());
    }

    private UrlDTO convert(URLEntity urlEntity) {
        return modelMapper.map(urlEntity, UrlDTO.class);
    }

    @Override
    @Transactional
    public List<UrlDTO> findAllById(List<Long> ids) {
        return StreamSupport.stream(repository.findAllById(ids).spliterator(),
                false).map(urlEntity
                -> convert(urlEntity)).collect(Collectors.toList());
    }



    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    protected String[] getFields() {
        return new String[]{"url"};
    }

    @Override
    protected Class<?> getEntityClass() {
        return URLEntity.class;
    }

}