package org.bookmarknotes.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zealot on 08.08.18.
 */
@RestController
public class ResolveTextFromUrlController {
    @RequestMapping(value = "/resolve", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String resolveTextFromUrl(@RequestBody String url) {
        return "test";
    }
}
