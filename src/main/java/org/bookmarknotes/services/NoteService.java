package org.bookmarknotes.services;

import org.bookmarknotes.dto.NoteDTO;
import org.bookmarknotes.entities.Note;
import org.bookmarknotes.entities.UserEntity;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by zealot on 09.08.18.
 */
public interface NoteService {
    void save(String note);


    List<NoteDTO> findByUser(UserEntity u, PageRequest of);

    List<NoteDTO> findAllById(List<Long> ids);

    void delete(Long id);

    List<NoteDTO> list(int offset, int limit);


    List<NoteDTO> search(int offset, int limit, String search);
}