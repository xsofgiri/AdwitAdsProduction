package com.production.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.production.entity.MoodBoard;
import com.production.util.Constants;

@Service
public class DBUtil {

	@Autowired
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("setDataSource");
	}

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
		} catch (Exception e) {
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
		} catch (Exception e) {
			System.out.println("e : " + e + " - SQL QUERY_________" + query);
			return result;
		}

	}

	public String getOrderStatusName(int status) {
		String orderStatus = null;
		String query = "SELECT name FROM order_status WHERE order_status_id=?";

		try {

			Object[] conditionObject = new Object[] { status };

			orderStatus = (String) jdbcTemplate.queryForObject(query, conditionObject, new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getString("name");
				}
			});
		} catch (EmptyResultDataAccessException e) {
			return orderStatus;
		} catch (QueryTimeoutException e) {
			System.out.println(e);
			return orderStatus;
		} catch (Exception e) {
			System.out.println("e : " + e + " - SQL QUERY_________" + query);
			return orderStatus;
		}

		return orderStatus;
	}

	public String getSlugDetails(int orderId, int designerId) {

		int slugTypeId = 0;
		String publicationInitial = null, jobName = null, category = null, version = null, advertiserName = null;

		String query = "SELECT orders.advertiser_name, orders.job_no, publication.cat_slug_type_id,"
				+ " publication.initial, cat_result.category, cat_result.version FROM orders left join publication on"
				+ " orders.publication_id=publication.publication_id left join cat_result on cat_result.order_id=orders.order_id"
				+ " WHERE orders.order_id=?";

		Object[] conditionObject = new Object[] { orderId };

		Map<String, Object> map = jdbcTemplate.queryForMap(query, conditionObject);
		
		if(map.get("advertiser_name")!=null)advertiserName = (String)map.get("advertiser_name");
		if(map.get("job_no")!=null)jobName = (String)map.get("job_no");
		if(map.get("initial")!=null)publicationInitial = (String)map.get("initial");
		if(map.get("category")!=null)category = (String)map.get("category");
		if(map.get("version")!=null)version = (String)map.get("version");
		
		if(map.get("cat_slug_type_id")!=null)slugTypeId = (Integer)map.get("cat_slug_type_id");

		return Constants.getSlugName(slugTypeId, orderId, publicationInitial, jobName, category, designerId, version,
				advertiserName);
	}

}
