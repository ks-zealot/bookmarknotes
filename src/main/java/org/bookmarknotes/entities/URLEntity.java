package org.bookmarknotes.entities;

import lombok.*;
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
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class URLEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "url_Sequence")
    @SequenceGenerator(name = "url_Sequence", sequenceName = "URL_SEQ")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity owner;
    @Column(name="url")
    @Field
    private String url;

}
