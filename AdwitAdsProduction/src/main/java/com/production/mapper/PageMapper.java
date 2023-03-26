package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Page;

public class PageMapper implements RowMapper<Page> {

	@Override
	public Page mapRow(ResultSet rs, int rowNum) throws SQLException {
		Page page = new Page();
		page.setPageId(rs.getInt("page_id"));
		page.setPageDesignId(rs.getInt("page_design_id"));
		page.setPageNo(rs.getString("page_no"));
		page.setArticles(rs.getString("articles"));
		page.setAds(rs.getString("ads"));
		page.setNoteInstructions(rs.getString("note_instructions"));
		page.setPageStatusId(rs.getInt("page_status_id"));
		page.setAttachArticle(rs.getString("attch_article"));
		page.setAttachAds(rs.getString("attch_ads"));
		page.setIsApprove(rs.getString("is_approve"));
		return page;   
	}

}
