package org.bookmarknotes.dto;

/**
 * Created by zealot on 08.08.18.
 */
public class UrlDTO {
    public Long id;
    public String url;

    public UrlDTO() {
    }

    public Long getId() {
        return id;
    }

    public UrlDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public UrlDTO setUrl(String url) {
        this.url = url;
        return this;
    }


}
