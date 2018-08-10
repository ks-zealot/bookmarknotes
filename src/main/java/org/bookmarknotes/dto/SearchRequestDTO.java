package org.bookmarknotes.dto;

/**
 * Created by zealot on 09.08.18.
 */
public class SearchRequestDTO {
    private String term;
    private int offset;
    private int limit;

    public SearchRequestDTO() {
    }

    public String getTerm() {
        return term;
    }

    public SearchRequestDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public SearchRequestDTO setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public SearchRequestDTO setLimit(int limit) {
        this.limit = limit;
        return this;
    }
}
