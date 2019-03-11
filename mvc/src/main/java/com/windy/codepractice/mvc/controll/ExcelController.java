package com.windy.codepractice.mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExcelController {

    @GetMapping(value = "index")
    public String build()
    {
        return "uploadFile";
    }

}
