package org.malic.jenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/index")
public class Controller {

    @GetMapping("/here")
    public String getIndex() {
        return "index";
    }
}
