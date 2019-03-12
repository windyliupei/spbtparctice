package com.windy.codepractice.mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping(value = "index")
    public String index()
    {
        //Go to upload File page
        return "uploadFile";
    }

}
