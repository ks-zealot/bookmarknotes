package org.bookmarknotes.services;

import org.apache.lucene.search.Query;
import org.bookmarknotes.entities.UserEntity;
import org.bookmarknotes.repository.UserRepository;
import org.bookmarknotes.search.SearchRequest;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zealot on 08.08.18.
 */
public abstract class CommonService<T, R> {
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;
    private ModelMapper mapper;


    @Transactional
    public List<T> list(int offset, int limit) {

        return findByUser(getUser(), PageRequest.of(offset, limit));
    }

    protected abstract List<T> findByUser(UserEntity u, PageRequest of);

    @Transactional
    public List<T> search(int offset, int limit, String search) {

       return  map(searchInSearchEngine(new SearchRequest()
                .setOffset(offset).setLimit(limit).setTerm(search).setUser(getUser())));
    }

    protected List<T> map(List<R> l) {
        return l.stream().map(entity -> mapper.map(entity, getDTOClass())).collect(Collectors.toList());
    }

    protected abstract Class<? extends T> getDTOClass();


    protected UserEntity castToUser(UserDetails user) {
        return userRepository.loadByUserName(user.getUsername());
    }

    protected UserEntity getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return castToUser(user);
    }

    public abstract void delete(Long id);

    protected List searchInSearchEngine(SearchRequest searchRequest) {
        QueryBuilder qb = getSearchManager().getSearchFactory().buildQueryBuilder().forEntity(getEntityClass()).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields(getFields())
                .matching(searchRequest.getTerm()).createQuery();
        return getSearchManager().createFullTextQuery(luceneQuery, getEntityClass()).setFirstResult(searchRequest.getOffset())
                .setMaxResults(searchRequest.getLimit()).getResultList();

    }

    protected abstract String[] getFields();

    protected abstract Class<?> getEntityClass();


    @Autowired
    public CommonService setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        return this;
    }

    @Autowired
    public CommonService setMapper(ModelMapper mapper) {
        this.mapper = mapper;
        return this;
    }

    protected FullTextEntityManager getSearchManager() {
        return Search.getFullTextEntityManager(entityManager);
    }
}
