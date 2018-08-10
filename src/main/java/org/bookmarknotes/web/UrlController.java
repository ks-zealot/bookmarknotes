package org.bookmarknotes.web;

import org.bookmarknotes.dto.SearchRequestDTO;
import org.bookmarknotes.dto.UrlDTO;
import org.bookmarknotes.services.UrlService;
import org.bookmarknotes.services.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zealot on 08.08.18.
 */
@RestController
@RequestMapping("/url")
public class UrlController {
    private UrlService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveUrl(@RequestBody String url) {
        service.save(url);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UrlDTO> list(@ModelAttribute SearchRequestDTO requestDTO) {
        return service.list(requestDTO.getOffset(), requestDTO.getLimit());
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<UrlDTO> search(@ModelAttribute SearchRequestDTO requestDTO) {
        return service.search(requestDTO.getOffset(), requestDTO.getLimit(), requestDTO.getTerm());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Autowired
    public UrlController setService(UrlService service) {
        this.service = service;
        return this;
    }


}
