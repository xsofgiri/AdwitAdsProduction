package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.PageRevision;

public class PageRevisionMapper implements RowMapper<PageRevision> {

	@Override
	public PageRevision mapRow(ResultSet rs, int rowNum) throws SQLException {
		PageRevision pageRevision = new PageRevision();
		pageRevision.setPageRevisionId(rs.getInt("page_revision_id"));
		pageRevision.setPageDesignId(rs.getInt("page_design_id"));  
		pageRevision.setArticles(rs.getString("articles"));
		pageRevision.setAds(rs.getString("ads"));
		pageRevision.setNote(rs.getString("note"));
		pageRevision.setZipPath(rs.getString("zip_path"));
		pageRevision.setPdfPath(rs.getString("pdf_path"));
		pageRevision.setRevisionVersion(rs.getString("revision_version"));
		pageRevision.setPageRevStatusId(rs.getInt("page_rev_status_id"));
		pageRevision.setCreatedOn(rs.getString("created_on"));  
		return pageRevision;
	}

}
