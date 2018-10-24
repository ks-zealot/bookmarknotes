package org.bookmarknotes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zealot on 08.08.18.
 */
@Controller
public class HelloController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
