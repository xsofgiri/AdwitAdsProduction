package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.AdsDesignCheckMsg;

public class AdsDesignCheckMsgMapper implements RowMapper<AdsDesignCheckMsg> {

	@Override
	public AdsDesignCheckMsg mapRow(ResultSet rs, int rowNum) throws SQLException {
		AdsDesignCheckMsg adsDesignCheckMsg = new AdsDesignCheckMsg();
		adsDesignCheckMsg.setId(rs.getInt("id"));
		adsDesignCheckMsg.setOrderId(rs.getInt("order_id"));
		adsDesignCheckMsg.setRevisionId(rs.getInt("revision_id"));
		adsDesignCheckMsg.setTlId(rs.getInt("tl_id"));
		adsDesignCheckMsg.setCsrId(rs.getInt("csr_id"));
		adsDesignCheckMsg.setDcId(rs.getInt("dc_id"));
		adsDesignCheckMsg.setTime(rs.getString("time"));
		adsDesignCheckMsg.setMessage(rs.getString("message"));
		return adsDesignCheckMsg;  
	}

}
