package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderQA;
import com.production.util.CalendarUtil;

public class OrderQAMapper implements RowMapper<OrderQA> {

	@Override
	public OrderQA mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderQA orderQA = new OrderQA();
		CalendarUtil calendarUtil = new CalendarUtil();

		orderQA.setOrderQaId(rs.getInt("order_q_a_id"));
		orderQA.setOrderId(rs.getInt("order_id"));
		orderQA.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		orderQA.setCsrId(rs.getInt("csr_id"));
		orderQA.setAcsrId(rs.getInt("A_csr_id"));
		orderQA.setAdrepId(rs.getInt("adrep_id"));
		orderQA.setQuestion(rs.getString("question"));
		orderQA.setAnswer(rs.getString("answer"));
		orderQA.setqTimestamp(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("Qtimestamp")), "yyyy-MM-dd"));
		orderQA.setaTimestamp(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("Atimestamp")), "yyyy-MM-dd"));
		return orderQA;
	}  

}
