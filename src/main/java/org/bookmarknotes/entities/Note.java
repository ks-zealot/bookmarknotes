package org.bookmarknotes.entities;

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
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "note_Sequence")
    @SequenceGenerator(name = "note_Sequence", sequenceName = "NOTE_SEQ")
    public Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    public UserEntity owner;
    @Column(name="note", columnDefinition = "TEXT")
    @Field
    public String note;

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public Note setId(Long id) {
        this.id = id;
        return this;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public Note setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public String getNote() {
        return note;
    }

    public Note setNote(String note) {
        this.note = note;
        return this;
    }
}
