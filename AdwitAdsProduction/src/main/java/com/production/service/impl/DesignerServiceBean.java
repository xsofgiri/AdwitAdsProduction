package com.production.service.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.production.entity.Designer;

@Service
public class DesignerServiceBean {

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

	public int getDesignerInProductionCount(Designer designer) {
		int count = 0;
		String sqlQuery = "select count(live_order_id) from live_order join orders on orders.order_id=live_order.order_id"
				+ " where live_order.designer_id=? and live_order.production_status_id=1 and live_order.is_crequest!=1 and"
				+ " live_order.question!=1; ";
		Object[] conditionObject = new Object[] { designer.getDesignerId() };

		count = dbUtil.getJDBCIntResult(sqlQuery, conditionObject);

		return count;

	}
}
