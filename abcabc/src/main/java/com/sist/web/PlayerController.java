package com.sist.web;
import java.util.*;
import com.sist.vo.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

	@GetMapping("player/batter_list.do")
	public String player_batter_list()
	{
		return "player/batter_list";
	}
	
	@GetMapping("player/pitcher_list.do")
	public String player_pitcher_list()
	{
		return "player/pitcher_list";
	}
}
