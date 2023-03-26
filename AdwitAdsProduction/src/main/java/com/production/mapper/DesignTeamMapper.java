package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.DesignTeam;

public class DesignTeamMapper implements RowMapper<DesignTeam> {

	@Override
	public DesignTeam mapRow(ResultSet rs, int rowNum) throws SQLException {
		DesignTeam designTeam = new DesignTeam();
		designTeam.setDesignTeamId(rs.getInt("design_team_id"));
		designTeam.setName(rs.getString("name"));
		designTeam.setGroupId(rs.getInt("group_id"));
		designTeam.setCode(rs.getString("code"));
		designTeam.setEmailId(rs.getString("email_id"));
		designTeam.setNewAdTemplate(rs.getString("newad_template"));
		designTeam.setRevAdTemplate(rs.getString("revad_template"));
		designTeam.setIsActive(rs.getInt("is_active"));
		designTeam.setIsDeleted(rs.getInt("is_deleted"));
		return designTeam;  
	}

}
