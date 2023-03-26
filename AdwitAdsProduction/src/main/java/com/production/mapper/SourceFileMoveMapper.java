package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.SourceFileMove;

public class SourceFileMoveMapper implements RowMapper<SourceFileMove> {

	@Override
	public SourceFileMove mapRow(ResultSet rs, int rowNum) throws SQLException {
		SourceFileMove sourceFileMove = new SourceFileMove();
		sourceFileMove.setSourceFileMoveId(rs.getInt("sourcefile_move_id"));
		sourceFileMove.setOrderId(rs.getInt("order_id"));
		sourceFileMove.setHelpDeskId(rs.getInt("help_desk_id"));
		sourceFileMove.setSlug(rs.getString("slug"));
		sourceFileMove.setPath(rs.getString("path"));
		sourceFileMove.setIsStatus(rs.getInt("is_status"));
		return sourceFileMove;  
	}

}
