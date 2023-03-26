package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.Account;

public class AccountMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAccountID(rs.getInt("account_id"));
		account.setFirstName(rs.getString("first_name"));
		account.setLastName(rs.getString("last_name"));
		account.setGender(rs.getInt("gender"));
		account.setEmailId(rs.getString("email_id"));
		account.setUsername(rs.getString("username"));
		account.setPassword(rs.getString("password"));
		account.setPhone(rs.getString("phone"));
		account.setMobile(rs.getString("mobile"));
		account.setTimestamp(rs.getString("timestamp"));
		account.setIsActive(rs.getInt("is_active"));
		account.setIsDeleted(rs.getInt("is_deleted"));
		return account;
	}

}
