package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@Controller
public class TrainController {
	@GetMapping("train/list.do")
    public String train_list()
    {
 	   return "train/list";
    }
}
