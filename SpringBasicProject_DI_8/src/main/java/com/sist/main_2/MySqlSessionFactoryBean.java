package com.sist.main_2;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ssf")
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {
	@Autowired
	public MySqlSessionFactoryBean(DataSource dataSource)
	{
		setDataSource(dataSource);
		/*
		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="ds"
		/>
		 */
	}
}
