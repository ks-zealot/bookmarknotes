package org.bookmarknotes.search;

import org.bookmarknotes.entities.UserEntity;

/**
 * Created by zealot on 08.08.18.
 */
public class SearchRequest {
    private UserEntity user;
    private String term;
    private int offset;
    private int limit;

    public SearchRequest() {
    }

    public UserEntity getUser() {
        return user;
    }

    public SearchRequest setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public SearchRequest setTerm(String term) {
        this.term = term;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public SearchRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public SearchRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }
}
