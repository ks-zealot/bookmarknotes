package org.bookmarknotes.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

/**
 * Created by zealot on 08.08.18.
 */
@Entity
@Indexed
public class URLEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "url_Sequence")
    @SequenceGenerator(name = "url_Sequence", sequenceName = "URL_SEQ")
            public Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public UserEntity owner;
    @Column(name="url")
    @Field
    public String url;

    public URLEntity() {
    }

    public Long getId() {
        return id;
    }

    public URLEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public URLEntity setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public URLEntity setUrl(String url) {
        this.url = url;
        return this;
    }
}
