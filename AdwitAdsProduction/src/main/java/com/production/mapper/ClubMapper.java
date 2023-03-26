package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Club;

public class ClubMapper implements RowMapper<Club> {

	@Override
	public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
		Club club = new Club();
		club.setClubId(rs.getInt("club_id"));
		club.setName(rs.getString("name"));
		return club;
	}
}
