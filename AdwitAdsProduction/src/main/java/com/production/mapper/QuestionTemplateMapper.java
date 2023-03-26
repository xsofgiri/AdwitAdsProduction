package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.QuestionTemplate;

public class QuestionTemplateMapper implements RowMapper<QuestionTemplate> {

	@Override
	public QuestionTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
		QuestionTemplate questionTemplate = new QuestionTemplate();
		questionTemplate.setQuestionTemplateId(rs.getInt("question_template_id"));
		questionTemplate.setName(rs.getString("name"));
		questionTemplate.setMessage(rs.getString("message"));
		
		return questionTemplate;
	}

}
