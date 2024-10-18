package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GnDDAO;
import com.sist.vo.GnDVO;

@Service
public class GnDServiceImpl implements GnDService{
   @Autowired
   private GnDDAO gDao;

   @Override
   public List<GnDVO> gndListData(Map map) {
      // TODO Auto-generated method stub
      return gDao.gndListData(map);
   }

   @Override
   public int gndTotalPage() {
      // TODO Auto-generated method stub
      return gDao.gndTotalPage();
   }

@Override
public List<GnDVO> gndTeamListData(Map map) {
	// TODO Auto-generated method stub
	return gDao.gndTeamListData(map);
}

@Override
public int gndTeamTotalPage(String team) {
	// TODO Auto-generated method stub
	return gDao.gndTeamTotalPage(team);
}
   
}
