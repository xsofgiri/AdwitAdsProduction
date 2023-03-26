package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.CatResult;
import com.production.util.CalendarUtil;

public class CatResultMapper implements RowMapper<CatResult> {

	@Override
	public CatResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		CalendarUtil calendarUtil = new CalendarUtil();
		CatResult catResult = new CatResult();

		catResult.setCatResultId(rs.getInt("cat_result_id"));
		catResult.setOrderId(rs.getInt("order_id"));
		catResult.setCatNewAdtypeId(rs.getInt("cat_new_adtype_id"));
		catResult.setCatArtInstructionId(rs.getInt("cat_artinstruction_id"));
		catResult.setProductionStatusId(rs.getInt("production_status_id"));
		catResult.setCategory(rs.getString("category"));
		catResult.setInstruction(rs.getString("instruction"));
		catResult.setCsrId(rs.getInt("csr_id"));
		catResult.setCategoryDate(
				calendarUtil.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("category_date")), "yyyy-MM-dd"));
		catResult.setTime(rs.getString("time"));
		catResult.setDesignerId(rs.getInt("designer_id"));
		catResult.setLocationId(rs.getInt("location_id"));
		catResult.setSlug(rs.getString("slug"));
		catResult.setVersion(rs.getString("version"));
		catResult.setDesignerProductionDate(rs.getString("designer_production_date"));
		catResult.setStartTime(rs.getString("start_time"));
		catResult.setEndTime(rs.getString("end_time"));
		catResult.setTimeTaken(rs.getFloat("time_taken"));
		catResult.setTeamLeadDesignerId(rs.getInt("teamlead_designer_id"));
		catResult.setTeamLeadDesignerTime(calendarUtil
				.formatDate(calendarUtil.convertTimeSqlToJava(rs.getTime("teamlead_designer_date")), "hh:mm:ss"));

		catResult.setTeamLeadDesignerDate(calendarUtil
				.formatDate(calendarUtil.convertDateSqlToJava(rs.getDate("teamlead_designer_date")), "yyyy-MM-dd"));
		catResult.setShiftFactor(rs.getFloat("shift_factor"));
		catResult.setBillingStatusId(rs.getInt("billing_status_id"));
		catResult.setTimeStamp(rs.getString("timestamp"));
		catResult.setAssign(rs.getInt("assign"));
		catResult.setSourcePath(rs.getString("source_path"));
		catResult.setFtpSourcePath(rs.getString("ftp_source_path"));
		catResult.setTagDesignerId(rs.getInt("tag_designer_id"));
		catResult.setQaCsrId(rs.getInt("QA_csr_id"));
		catResult.setCsrQaTimestamp(rs.getString("csr_QA_timestamp"));
		catResult.setTagCsrId(rs.getInt("tag_csr_id"));
		catResult.setSourceFile(rs.getString("source_file"));
		catResult.setPdfFile(rs.getString("pdf_file"));
		catResult.setSoldPdf(rs.getString("sold_pdf"));
		catResult.setAdwitTeamsId(rs.getInt("adwit_teams_id"));
		return catResult;

	}
}
