package org.bookmarknotes.dto;

/**
 * Created by zealot on 08.08.18.
 */

public class NoteDTO {
    public Long id;
    public String note;

    public NoteDTO() {
    }

    public String getNote() {
        return note;
    }

    public NoteDTO setNote(String note) {
        this.note = note;
        return this;
    }

    public Long getId() {
        return id;
    }

    public NoteDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
