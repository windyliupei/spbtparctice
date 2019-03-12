package com.windy.codepractice.mvc.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WirteController {


    @GetMapping(value = "writeExcelCtl")
    public String writeExcelCtl(){



        return "writeExcel";
    }

    @PostMapping(value = "writeExcel")
    public String writeExcel(){

        return "";
    }

}
