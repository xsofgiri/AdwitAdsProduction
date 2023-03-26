package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.SendForApproval;

public class SendForApprovalMapper implements RowMapper<SendForApproval> {

	@Override
	public SendForApproval mapRow(ResultSet rs, int rowNum) throws SQLException {
		SendForApproval sendForApproval = new SendForApproval();
		sendForApproval.setSendForApprovalId(rs.getInt("send_for_approval_id"));
		sendForApproval.setOrderId(rs.getInt("order_id"));
		sendForApproval.setAdNum(rs.getString("ad_num"));
		sendForApproval.setAdrepId(rs.getInt("adrep_id"));
		sendForApproval.setName(rs.getString("name"));
		sendForApproval.setEmail(rs.getString("email"));
		sendForApproval.setApprove(rs.getInt("approve"));
		sendForApproval.setDeclineReason(rs.getString("decline_reason"));
		return sendForApproval;  
	}

}
