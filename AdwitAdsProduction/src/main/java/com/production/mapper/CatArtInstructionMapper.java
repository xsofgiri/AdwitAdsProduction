package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.CatArtInstruction;

public class CatArtInstructionMapper implements RowMapper<CatArtInstruction> {

	@Override
	public CatArtInstruction mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatArtInstruction catArtInstruction = new CatArtInstruction();
		catArtInstruction.setCatArtInstructionId(rs.getInt("cat_artinstruction_id"));
		catArtInstruction.setName(rs.getString("name"));
		return catArtInstruction;
	}

}
