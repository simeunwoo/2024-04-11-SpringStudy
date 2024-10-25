package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.GnDService;

@Controller
public class GnDController {
   @Autowired
   private GnDService gService;
   
   @GetMapping("gnd/list.do")
   public String gnd_list() {
      return "gnd/list";
   }
   
}