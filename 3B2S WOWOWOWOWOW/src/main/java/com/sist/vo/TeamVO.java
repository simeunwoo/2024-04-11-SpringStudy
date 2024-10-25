package com.sist.vo;

import lombok.Data;
@Data
public class TeamVO {

	private int no,game,win,draw,lose,ranking;
	private double cha,winper;
	private String team,logo,year;
}
