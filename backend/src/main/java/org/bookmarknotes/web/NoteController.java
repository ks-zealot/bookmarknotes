package org.bookmarknotes.web;

import org.bookmarknotes.dto.NoteDTO;
import org.bookmarknotes.dto.SearchRequestDTO;
import org.bookmarknotes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zealot on 08.08.18.
 */
@RestController
@RequestMapping("/note")
public class NoteController {
    private NoteService service;
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveNote(@RequestBody String note){
        service.save(note);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<NoteDTO> list(@ModelAttribute SearchRequestDTO requestDTO) {
        return service.list(requestDTO.getOffset(), requestDTO.getLimit());
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<NoteDTO> search(@ModelAttribute SearchRequestDTO requestDTO) {
        return service.search(requestDTO.getOffset(), requestDTO.getLimit(), requestDTO.getTerm());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Autowired
    public NoteController setService(NoteService service) {
        this.service = service;
        return this;
    }
}
