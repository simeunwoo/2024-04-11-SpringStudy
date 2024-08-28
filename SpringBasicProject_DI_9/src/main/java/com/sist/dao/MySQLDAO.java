package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MySQLDAO implements MyDAO {
	
	@Override
	public void connection() {
		System.out.println("MySQL ¿¬°á");
	}
}
