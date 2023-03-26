package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.ProductionConversation;

public class ProductionConversationMapper implements RowMapper<ProductionConversation> {

	@Override
	public ProductionConversation mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductionConversation productionConversation = new ProductionConversation();
		productionConversation.setProductionConversationId(rs.getInt("production_conversation_id"));
		productionConversation.setOrderId(rs.getInt("order_id"));
		productionConversation.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		productionConversation.setDesignerId(rs.getInt("designer_id"));
		productionConversation.setTlDesignerId(rs.getInt("tl_designer_id"));
		productionConversation.setCsrId(rs.getInt("csr_id"));
		productionConversation.setTime(rs.getString("time"));
		productionConversation.setMessage(rs.getString("message"));
		productionConversation.setOperation(rs.getString("operation"));
		productionConversation.setFilePath(rs.getString("file_path"));
		return productionConversation;
	}
  
}
