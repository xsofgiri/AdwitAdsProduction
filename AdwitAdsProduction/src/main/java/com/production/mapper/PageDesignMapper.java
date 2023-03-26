package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.PageDesign;
import com.production.entity.Payment;
import com.production.util.CalendarUtil;

public class PageDesignMapper implements RowMapper<PageDesign> {

	@Override
	public PageDesign mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageDesign pageDesign = new PageDesign();
		CalendarUtil calendarUtil = new CalendarUtil();
		pageDesign.setPageDesignId(rs.getInt("page_design_id"));
		pageDesign.setAdrepId(rs.getInt("adrep_id"));
		pageDesign.setUniqueJobName(rs.getString("unique_job_name"));
		pageDesign.setPublishDate(calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("publish_date")),
				"yyyy-MM-dd"));
		pageDesign.setNoOfPages(rs.getInt("No_of_pages"));
		pageDesign.setCreatedOn(rs.getString("created_on"));
		pageDesign.setPageDesignStatusId(rs.getInt("page_design_status_id"));
		pageDesign.setStartTime(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("publish_date")), "hh:mm:ss"));
		pageDesign.setZip(rs.getString("zip"));
		pageDesign.setPdf(rs.getString("pdf"));
		pageDesign.setEndTime(
				calendarUtil.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("end_time")), "hh:mm:ss"));
		return pageDesign;
	}

}
