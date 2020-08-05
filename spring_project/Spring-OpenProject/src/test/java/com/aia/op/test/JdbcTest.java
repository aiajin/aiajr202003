package com.aia.op.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*.xml")
public class JdbcTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Inject
	private JdbcTemplate template;
	
	@Inject
	private SqlSessionTemplate sessionTemplate;
	
	
	@Test
	public void sessionTemplateTest() {
		System.out.println("sessionTemplate =====> " + sessionTemplate);
	}
	
	@Test
	public void jdbcTemplateTest() {
		
		System.out.println("jdbcTemplate =====> " + template);
	}
	
	@Test
	public void connectionTest() throws SQLException {
		
		System.out.println("dataSource =====> " + dataSource);
		
		Connection conn = null;
		
		conn = dataSource.getConnection();

		System.out.println("Connection =====>" + conn);
		
	}

}






