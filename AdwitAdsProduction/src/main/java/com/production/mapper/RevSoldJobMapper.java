package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Orders;
import com.production.entity.RevSoldJob;

public class RevSoldJobMapper implements RowMapper<RevSoldJob> {

	@Override
	public RevSoldJob mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevSoldJob revSoldJob = new RevSoldJob();
		revSoldJob.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		revSoldJob.setOrderId(rs.getInt("order_id"));
		revSoldJob.setPreviousSlug(rs.getString("previous_slug"));
		revSoldJob.setMapRevorderId(rs.getInt("map_revorder_id"));
		revSoldJob.setCsrID(rs.getInt("csr_id"));
		revSoldJob.setAdrepId(rs.getInt("adrep_id"));
		revSoldJob.setDesignerId(rs.getInt("designer_id"));
		revSoldJob.setNewSlug(rs.getString("new_slug"));
		revSoldJob.setDesignerProductionDate(rs.getString("new_slug"));
		revSoldJob.setCategory(rs.getString("category"));
		revSoldJob.setVersion(rs.getString("version"));
		revSoldJob.setSentTime(rs.getString("sent_time"));
		revSoldJob.setFrontlineCsrId(rs.getInt("frontline_csr_id"));
		revSoldJob.setQaCsrId(rs.getInt("QA_csr_id"));
		revSoldJob.setTimeTaken(rs.getInt("time_taken"));
		revSoldJob.setDpErrorId(rs.getString("dp_error_id"));
		revSoldJob.setComplaints(rs.getInt("complaints"));
		revSoldJob.setIsChecked(rs.getInt("is_checked"));
		revSoldJob.setIsJobStatus(rs.getInt("is_job_status"));
		revSoldJob.setQuestion(rs.getString("question"));
		revSoldJob.setAnswer(rs.getString("answer"));
		revSoldJob.setIsJobAccept(rs.getInt("is_job_accept"));
		revSoldJob.setReasonC(rs.getInt("reason_c"));
		revSoldJob.setcCreateCsrId(rs.getInt("c_create_csr_id"));
		revSoldJob.setNote(rs.getString("note"));
		revSoldJob.setFilePath(rs.getString("file_path"));
		revSoldJob.setPdfPath(rs.getString("pdf_path"));
		revSoldJob.setSoldPdf(rs.getString("sold_pdf"));
		revSoldJob.setIsApprove(rs.getInt("is_approve"));
		revSoldJob.setIsCancel(rs.getInt("is_cancel"));
		revSoldJob.setIsRush(rs.getInt("is_rush"));
		revSoldJob.setRevOrderStatusID(rs.getInt("rev_order_status_id"));
		revSoldJob.setIsDownDel(rs.getInt("is_down_del"));
		revSoldJob.setSourceFile(rs.getString("source_file"));
		// revSoldJob.setRevisionStartTimestamp(rs.getString("revision_start_timestamp"));
		// revSoldJob.setRevisionEndTimestamp(rs.getString("revision_end_timesstamp"));
		revSoldJob.setPdfFile(rs.getString("pdf_file"));
		revSoldJob.setcComplaint(rs.getInt("c_complaint"));
		revSoldJob.setComplaintType(rs.getInt("complaint_type"));
		revSoldJob.setRovCsrId(rs.getInt("rov_csr_id"));
		revSoldJob.setRevClassificationId(rs.getInt("rev_classification_id"));
		// revSoldJob.setApprovedTime(rs.getString("approved_time"));
		revSoldJob.setIsVerify(rs.getInt("is_verify"));
		revSoldJob.setVerificatinTypeId(rs.getString("verification_type_id"));
		return revSoldJob;
	}

}
