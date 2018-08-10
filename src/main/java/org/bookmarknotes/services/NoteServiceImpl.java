package org.bookmarknotes.services;

import org.bookmarknotes.dto.NoteDTO;
import org.bookmarknotes.entities.Note;
import org.bookmarknotes.entities.UserEntity;
import org.bookmarknotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zealot on 08.08.18.
 */
@Service
public class NoteServiceImpl extends CommonService<NoteDTO, Note> implements NoteService{

    private NoteRepository noteRepository;
    @Autowired
    public NoteServiceImpl setNoteRepository(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        return this;
    }

    @Transactional
    public void save(String note) {

        Note entity = new Note();
        entity.setNote(note);
        entity.setOwner(getUser());
        noteRepository.save(entity);
    }

    @Override
    @Transactional
    public List<NoteDTO> findByUser(UserEntity u, PageRequest of) {
        return map(noteRepository.findByUser(u, of));
    }

    @Override
    protected Class<? extends NoteDTO> getDTOClass() {
        return NoteDTO.class;
    }


    protected String[] getFields() {
        return new String[]{"note"};
    }

    protected Class<?> getEntityClass() {
        return Note.class;
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    };


}
