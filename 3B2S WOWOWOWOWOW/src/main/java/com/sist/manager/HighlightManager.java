package com.sist.manager;

import org.springframework.stereotype.Component;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.mongodb.util.JSON;
import com.sist.vo.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.io.*;

import javax.lang.model.element.Element;
import javax.swing.text.Highlighter.Highlight;

@Component
public class HighlightManager {
    // You need to set this value for your code to compile.
    // For example: ... DEVELOPER_KEY = "YOUR ACTUAL KEY";
    private static final String DEVELOPER_KEY = "AIzaSyBIGT4K45TpQVfaN7Uta1gxYfRdWdbtFD0";

    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    
    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
            .setApplicationName(APPLICATION_NAME)
            .build();
    }

    /**
     * Call function to create API service object. Define and
     * execute API request. Print API response.
     *
     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
     */
    public List<HighlightVO> highlightList(String pageToken) throws GeneralSecurityException, IOException, GoogleJsonResponseException {
    	List<HighlightVO> list=new ArrayList<HighlightVO>();
    	
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.PlaylistItems.List request = youtubeService.playlistItems()
            .list("snippet");
        PlaylistItemListResponse response = request.setKey(DEVELOPER_KEY)
            .setMaxResults(10L)
            .setPageToken(pageToken)
            .setPlaylistId("PLuY-NTS_5IpzwH3FfskfFOrnui5O5NlkC")
            .execute();
    	
        String res;
        res= response.toString();
        
    	try {
    		JSONParser jp=new JSONParser();
        	JSONObject root=(JSONObject)jp.parse(res);
        	System.out.println("root : "+root);
        	
        	//items 내 값들
		    JSONArray arrItems=(JSONArray)root.get("items");
        	for(int i=0;i<arrItems.size();i++)
        	{
        		HighlightVO vo=new HighlightVO();
        		JSONObject obj=(JSONObject)arrItems.get(i);

            	
        		//snippet내 값들
        		JSONObject arrSnippet=(JSONObject)obj.get("snippet");
        		vo.setTitle((String)arrSnippet.get("title"));					//영상 제목
        		vo.setPublishedAt((String)arrSnippet.get("publishedAt"));		//업로드시간
        		vo.setDescription((String)arrSnippet.get("description"));		//상세설명
        		
        		//thumbnails 내 값
        		JSONObject arrThumbnails=(JSONObject)arrSnippet.get("thumbnails");
        		JSONObject arrMaxres=(JSONObject)arrThumbnails.get("maxres");
        		vo.setThumbnail((String)arrMaxres.get("url"));
        		
        		//resourceId 내 값들
        		JSONObject arrResourceId=(JSONObject)arrSnippet.get("resourceId");
        		vo.setVideoId((String)arrResourceId.get("videoId"));
        		
        		list.add(vo);
        	}
        	
        	System.out.println(list);
    	}catch (Exception ex) {
    		ex.printStackTrace();
		}
    	return list;
    }
    
    public List<HighlightTokenVO> highlightPageTokener(String pageToken) throws GeneralSecurityException, IOException, GoogleJsonResponseException {
    	List<HighlightTokenVO> list=new ArrayList<HighlightTokenVO>();
    	
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.PlaylistItems.List request = youtubeService.playlistItems()
            .list("snippet");
        PlaylistItemListResponse response = request.setKey(DEVELOPER_KEY)
            .setMaxResults(10L)
            .setPageToken(pageToken)
            .setPlaylistId("PLuY-NTS_5IpzwH3FfskfFOrnui5O5NlkC")
            .execute();
    	
        String res;
        res= response.toString();
        
        try {
    		JSONParser jp=new JSONParser();
        	JSONObject root=(JSONObject)jp.parse(res);

    		HighlightTokenVO vo=new HighlightTokenVO();
    		
    		//json내 값
        	vo.setPrevPageToken((String)root.get("prevPageToken"));			//이전 페이지 토큰
        	vo.setNextPageToken((String)root.get("nextPageToken"));  		//다음 페이지 토큰

    		list.add(vo);

        	System.out.println(list);
    	}catch (Exception ex) {
    		ex.printStackTrace();
		}

    	return list;
    }

   
}
