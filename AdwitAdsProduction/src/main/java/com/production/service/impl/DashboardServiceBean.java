package com.production.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceBean {

	@Autowired
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	DBUtil dbUtil;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("setDataSource");
	}

	public int getNewPrintAdsCount(int csrId, String date) {
		int result = 0;

		try {
			String whrCondition = " where cat_new_adtype_id=2 and (csr_id=? and date(category_date)=?) or (QA_csr_id=? and date(csr_QA_timestamp)=?)";

			String query = "SELECT COUNT(cat_result_id) FROM cat_result " + whrCondition;
			Object[] conditionObject = new Object[] { csrId, date, csrId, date };

			result = dbUtil.getJDBCIntResult(query, conditionObject);

		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public int getNewWebAdsCount(int csrId, String date) {
		int result = 0;
		try {
			String whrCondition = " where cat_new_adtype_id=1 and (csr_id=? and date(category_date)=?) or (QA_csr_id=? and date(csr_QA_timestamp)=?)";

			String query = "SELECT COUNT(cat_result_id) FROM cat_result " + whrCondition;
			Object[] conditionObject = new Object[] { csrId, date, csrId, date };

			result = dbUtil.getJDBCIntResult(query, conditionObject);
		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public int getNewRevisionAdsCount(int csrId, String date) {
		int result = 0;
		try {
			String whrCondition = " where (csr_id=? and date(designer_production_date)=?) or (QA_csr_id=? and date(designer_production_date)=?) or rov_csr_id=?";

			String query = "SELECT COUNT(rev_sold_job_id) FROM rev_sold_job " + whrCondition;
			Object[] conditionObject = new Object[] { csrId, date, csrId, date, csrId };

			result = dbUtil.getJDBCIntResult(query, conditionObject);
		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public HashMap<String, Integer> getCategorizedAdsCountList(int csrId, String fromDate, String toDate) {
		// SELECT count(cat_result_id), category FROM cat_result where csr_id=68 and
		// date(category_date) between '2021-09-22 00:00:00' and '2022-09-31 23:59:59'
		// group by category;
		HashMap<String, Integer> categorizedList = new HashMap<String, Integer>();

		return categorizedList;
	}
	
	
	public HashMap<String, Integer> getProofedAdsCountList(int csrId, String fromDate, String toDate) {
		// SELECT count(cat_result_id), category FROM cat_result where csr_id=68 and
		// date(category_date) between '2021-09-22 00:00:00' and '2022-09-31 23:59:59'
		// group by category;
		HashMap<String, Integer> categorizedList = new HashMap<String, Integer>();

		return categorizedList;
	}
	
	
	public HashMap<String, Integer> getDesignedAdsCountList(int csrId, String fromDate, String toDate) {
		// SELECT count(cat_result_id), category FROM cat_result where csr_id=68 and
		// date(category_date) between '2021-09-22 00:00:00' and '2022-09-31 23:59:59'
		// group by category;
		HashMap<String, Integer> categorizedList = new HashMap<String, Integer>();

		return categorizedList;
	}
	
	
	public HashMap<String, Integer> getPublicationAdsCountList(int csrId, String fromDate, String toDate) {
		// SELECT count(cat_result_id), category FROM cat_result where csr_id=68 and
		// date(category_date) between '2021-09-22 00:00:00' and '2022-09-31 23:59:59'
		// group by category;
		HashMap<String, Integer> categorizedList = new HashMap<String, Integer>();

		return categorizedList;
	}
	
	
	public HashMap<String, Integer> getAdRepAdsCountList(int csrId, String fromDate, String toDate) {
		// SELECT count(cat_result_id), category FROM cat_result where csr_id=68 and
		// date(category_date) between '2021-09-22 00:00:00' and '2022-09-31 23:59:59'
		// group by category;
		HashMap<String, Integer> categorizedList = new HashMap<String, Integer>();

		return categorizedList;
	}
	
	
	public HashMap<String, Integer> getRevisionReturnedAdsCountList(int csrId, String fromDate, String toDate) {
		// SELECT count(cat_result_id), category FROM cat_result where csr_id=68 and
		// date(category_date) between '2021-09-22 00:00:00' and '2022-09-31 23:59:59'
		// group by category;
		HashMap<String, Integer> categorizedList = new HashMap<String, Integer>();

		return categorizedList;
	}
}
