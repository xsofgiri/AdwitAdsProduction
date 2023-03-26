package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.OrderRevision;

public class OrderRevisionMapper implements RowMapper<OrderRevision> {  

	@Override
	public OrderRevision mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderRevision orderRevision = new OrderRevision();
		orderRevision.setOrderRevisionId(rs.getInt("order_revision_id"));
		orderRevision.setAdrepId(rs.getInt("adrep_id"));
		orderRevision.setOrderId(rs.getString("order_id"));
		orderRevision.setJobSlug(rs.getString("job_slug"));
		orderRevision.setVersion(rs.getString("version"));
		orderRevision.setCopyContentDescription(rs.getString("copy_content_description"));
		orderRevision.setFilePath(rs.getString("file_path"));
		orderRevision.setCsrIdUpload(rs.getInt("csr_id_upload"));
		orderRevision.setCreatedOn(rs.getString("created_on"));
		return orderRevision;
	}

}
