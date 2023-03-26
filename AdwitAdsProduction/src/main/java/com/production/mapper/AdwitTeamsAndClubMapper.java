package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.AdwitTeamsAndClub;

public class AdwitTeamsAndClubMapper implements RowMapper<AdwitTeamsAndClub> {

	@Override
	public AdwitTeamsAndClub mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdwitTeamsAndClub adwitTeamsAndClub = new AdwitTeamsAndClub();
		adwitTeamsAndClub.setId(rs.getInt("id"));
		adwitTeamsAndClub.setAdwitTeamsId(rs.getInt("adwit_teams_id"));
		adwitTeamsAndClub.setClubId(rs.getInt("club_id"));
		return adwitTeamsAndClub;
	}

}
