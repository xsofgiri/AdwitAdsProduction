package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.CatNewAdType;

public class CatNewAdTypeMapper implements RowMapper<CatNewAdType> {

	@Override
	public CatNewAdType mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatNewAdType catNewAdType = new CatNewAdType();
		catNewAdType.setCatNewAdTypeId(rs.getInt("cat_new_adtype_id"));
		catNewAdType.setName(rs.getString("name"));
		catNewAdType.setCategory(rs.getInt("category"));
		return catNewAdType;
	}

}
