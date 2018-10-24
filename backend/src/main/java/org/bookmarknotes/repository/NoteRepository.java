package org.bookmarknotes.repository;

import org.bookmarknotes.entities.Note;
import org.bookmarknotes.entities.UserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zealot on 08.08.18.
 */
@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    @Query("SELECT n from Note n LEFT JOIN n.owner u where u =:u")
    List<Note> findByUser(@Param(value = "u") UserEntity u, Pageable pageRequest);
}
