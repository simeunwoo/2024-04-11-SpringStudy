package com.sist.main_2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mapper")
public class MyMapperFactoryBean extends MapperFactoryBean {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public MyMapperFactoryBean()
	{
		setMapperInterface(com.sist.main_2.EmpMapper.class);
	}
/*
<bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean"
		p:sqlSessionFactory-ref="ssf"
		p:mapperInterface="com.sist.dao.EmpMapper"
	/>
 */
}
