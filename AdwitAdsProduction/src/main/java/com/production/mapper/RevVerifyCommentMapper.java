package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.RevVerifyComment;

public class RevVerifyCommentMapper implements RowMapper<RevVerifyComment> {

	@Override
	public RevVerifyComment mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevVerifyComment revVerifyComment = new RevVerifyComment();
		revVerifyComment.setRevVerifyCommentId(rs.getInt("rev_verify_comment_id"));
		revVerifyComment.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		revVerifyComment.setAdminUserId(rs.getInt("admin_user_id"));
		revVerifyComment.setDesignerId(rs.getInt("designer_id"));
		revVerifyComment.setTlDesignerId(rs.getInt("tl_designer_id"));
		revVerifyComment.setCsrId(rs.getInt("csr_id"));
		revVerifyComment.setRovCsrId(rs.getInt("rov_csr_id"));
		revVerifyComment.setComment(rs.getString("comment"));
		revVerifyComment.setIsError(rs.getInt("is_error"));
		revVerifyComment.setTimestamp(rs.getString("timestamp"));
		revVerifyComment.setDesignerReply(rs.getString("designer_reply"));
		revVerifyComment.setDtlReply(rs.getString("dtl_reply"));
		revVerifyComment.setCsrReply(rs.getString("csr_reply"));
		revVerifyComment.setRovCsrReply(rs.getString("rov_csr_reply"));
		revVerifyComment.setHiBDesignerId(rs.getInt("hi_b_designer_id"));
		revVerifyComment.setHiBDesignerReply(rs.getString("hi_b_designer_reply"));
		return revVerifyComment;
	}

}
