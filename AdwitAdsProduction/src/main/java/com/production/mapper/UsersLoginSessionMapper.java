package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.UsersLoginSession;

public class UsersLoginSessionMapper implements RowMapper<UsersLoginSession> {

	@Override
	public UsersLoginSession mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersLoginSession userSession = new UsersLoginSession();
		userSession.setId(rs.getInt("id"));
		userSession.setUserId(rs.getInt("user_id"));  
		userSession.setUserModule(rs.getInt("user_module"));
		userSession.setIp(rs.getString("ip"));
		userSession.setBrowser(rs.getString("browser"));
		userSession.setOs(rs.getString("os"));
		userSession.setDevice(rs.getString("device"));
		userSession.setInOut(rs.getString("in_out"));
		userSession.setTimestamp(rs.getString("timestamp"));  

		return userSession;  
	}

}
