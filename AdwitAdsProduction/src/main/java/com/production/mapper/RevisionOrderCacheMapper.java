package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.production.entity.RevisionOrderCache;

public class RevisionOrderCacheMapper implements RowMapper<RevisionOrderCache> {

	@Override
	public RevisionOrderCache mapRow(ResultSet rs, int rowNum) throws SQLException {
		RevisionOrderCache revCache = new RevisionOrderCache();
		revCache.setRevisionOrderCacheId(rs.getInt("revision_order_cache_id"));
		revCache.setOrderId(rs.getInt("order_id"));
		revCache.setRevSoldJobId(rs.getInt("rev_sold_job_id"));
		revCache.setOrderSlug(rs.getString("order_slug"));
		revCache.setAdrepId(rs.getInt("adrep_id"));
		revCache.setFilePath(rs.getString("file_path"));
		return revCache;
	}

}
