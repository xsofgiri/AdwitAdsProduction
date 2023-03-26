package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.AdminUser;

public class AdminUserMapper implements RowMapper<AdminUser> {

	@Override
	public AdminUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdminUser adminUser = new AdminUser();
		adminUser.setAdminUserId(rs.getInt("admin_user_id"));
		adminUser.setFirstName(rs.getString("first_name"));
		adminUser.setLastName(rs.getString("last_name"));
		adminUser.setEmailId(rs.getString("email_id"));
		adminUser.setUsername(rs.getString("username"));
		adminUser.setAdminRoleId(rs.getInt("admin_role_id"));
		adminUser.setPassword(rs.getString("password"));
		adminUser.setEncryptedKey(rs.getString("encrypted_key"));
		adminUser.setCreatedOn(rs.getString("created_on"));
		adminUser.setImagePath(rs.getString("image_path"));
		adminUser.setIsActive(rs.getInt("is_active"));
		adminUser.setIsDeleted(rs.getInt("is_deleted"));  
		return adminUser;
	}

}
