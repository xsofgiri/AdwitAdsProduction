package com.production.service.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DBUtil {

	@Autowired
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	
	public int getJDBCIntResult(String query, Object[] params) {
		int result = 0;
		try {
			result = (Integer) jdbcTemplate.queryForObject(query, params, Integer.class);
			return result;
		} catch (EmptyResultDataAccessException e) {
			return result;
		} catch (QueryTimeoutException e) {
			System.out.println(e);
			return result;
		}  catch (Exception e) {
			System.out.println("e : " + e + " - SQL QUERY_________" + query);
			return result;
		}

	}
	
	
	
	public String getJDBCStringResult(String query, Object[] params) {
		String result = null;
		try {
			result = (String) jdbcTemplate.queryForObject(query, params, String.class);
			return result;
		} catch (EmptyResultDataAccessException e) {
			return result;
		} catch (QueryTimeoutException e) {
			System.out.println(e);
			return result;
		}  catch (Exception e) {
			System.out.println("e : " + e + " - SQL QUERY_________" + query);
			return result;
		}

	}
	
}
