package com.sist.vo;

import java.util.*;
import lombok.Data;

@Data
public class HotelVO {
	private int hno,price,jjimcount,likecount,hit;
	private String name,address,checkin,checkout,location,poster,images,rdays;
	private Double score;
	private List<String> imagesList;

    // images 필드를 쉼표로 나누어 imagesList에 세팅
    public List<String> getImagesList() {
        if (images != null && !images.isEmpty()) {
            return Arrays.asList(images.split(",")); // 쉼표로 분리하여 리스트로 반환
        }
        return new ArrayList<>(); // images가 없을 경우 빈 리스트 반환
    }
}
