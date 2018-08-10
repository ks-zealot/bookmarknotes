package org.bookmarknotes.services;

import org.bookmarknotes.dto.UrlDTO;
import org.bookmarknotes.entities.UserEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by zealot on 09.08.18.
 */
public interface UrlService {
    void save(String note) ;


    List<UrlDTO> findByUser(UserEntity u, PageRequest of);

    List<UrlDTO> findAllById(List<Long> ids) ;

    void delete(Long id) ;

    List<UrlDTO> list(int offset, int limit) ;

    List<UrlDTO> search(int offset, int limit, String search) ;
}
