package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.HelpDesk;

public class HelpDeskMapper implements RowMapper<HelpDesk> {

	@Override
	public HelpDesk mapRow(ResultSet rs, int rowNum) throws SQLException {
		HelpDesk helpDesk = new HelpDesk();

		helpDesk.setHelpDeskId(rs.getInt("help_desk_id"));
		helpDesk.setName(rs.getString("name"));
		helpDesk.setdName(rs.getString("d_name"));
		helpDesk.setIsSold(rs.getInt("is_sold"));
		helpDesk.setDesignTeamId(rs.getInt("design_team_id"));
		helpDesk.setIsActive(rs.getInt("is_active"));
		helpDesk.setFtpServer(rs.getString("ftp_server"));
		helpDesk.setFtpUsername(rs.getString("ftp_username"));
		helpDesk.setFtpPassword(rs.getString("ftp_password"));
		helpDesk.setFtpFolder(rs.getString("ftp_folder"));
		helpDesk.setFtpUrl(rs.getString("ftp_url"));
		return helpDesk;  
	}

}
