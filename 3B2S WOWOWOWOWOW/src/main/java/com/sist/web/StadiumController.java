package com.sist.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;

@Controller
public class StadiumController {
	@Autowired
	private StadiumService sService;
	
    @GetMapping("stadium/list.do")
    public String stadium_list(Model model)
    {
        List<StadiumVO> list=sService.stadiumListData();
		
		model.addAttribute("list", list);
 	    return "stadium/list";
    }
    @GetMapping("stadium/detail.do")
    public String stadium_detail(int no,Model model)
    {
    	StadiumVO vo=sService.stadiumDetailData(no);
    	
    	
    	
    	model.addAttribute("vo", vo);
 	    model.addAttribute("no", no);
 	    return "stadium/detail";
    }
    @GetMapping("stadium/hotel_detail.do")
	public String hotel_detail(Model model,int hno)
	{
		HotelVO vo=sService.stadiumHotelDetailData(hno);
		
		model.addAttribute("vo", vo);
		
		return "stadium/hotel_detail";
	}
    @GetMapping("stadium/food_detail.do")
	public String food_detail(Model model,int fno)
	{
		FoodVO vo=sService.stadiumFoodDetailData(fno);
		
		model.addAttribute("vo", vo);
		
		return "stadium/food_detail";
	}
    
    @GetMapping("stadium/cctv.do")
    public String stadium_cctv()
    {
  	  
  	  return "stadium/cctv";
    }
}
