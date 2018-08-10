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
@Entity(name = "Note")
@Indexed
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "note_Sequence")
    @SequenceGenerator(name = "note_Sequence", sequenceName = "NOTE_SEQ")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserEntity owner;
    @Column(name="note", columnDefinition = "TEXT")
    @Field
    private String note;
}
