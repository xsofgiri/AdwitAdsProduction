package com.production.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.ResultSetMetaData;
import com.production.entity.Club;
import com.production.entity.LiveOrder;
import com.production.entity.Orders;
import com.production.entity.Publication;
import com.production.entity.TimeZone;
import com.production.service.impl.DBUtil;
import com.production.service.impl.UserServiceBean;
import com.production.util.CalendarUtil;

public class LiveOrderMapper implements RowMapper<LiveOrder> {

	@Override
	public LiveOrder mapRow(ResultSet rs, int rowNum) throws SQLException {

		LiveOrder liveOrder = new LiveOrder();
		Orders order = new Orders();
		TimeZone timeZone = new TimeZone();
		CalendarUtil calendarUtil = new CalendarUtil();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

		for (int x = 1; x <= rsmd.getColumnCount(); x++) {
//			System.out.println(rsmd.getColumnLabel(x));
			String columName = rsmd.getColumnLabel(x);
			Club club = new Club();
			Publication publication = new Publication();

			if (columName.equals("live_order_id"))
				liveOrder.setLiveOrderId(rs.getInt("live_order_id"));

			if (columName.equals("publication_id")) {
				liveOrder.setPublicationId(rs.getInt("publication_id"));
				publication.setPublicationId(rs.getInt("publication_id"));
				// liveOrder.setPublication(userService.getPublicationDetails(rs.getInt("publication_id")));
			}

			if (columName.equals("order_id"))
				liveOrder.setOrderId(rs.getInt("order_id"));
			if (columName.equals("job_no"))
				liveOrder.setJobNo(rs.getString("job_no"));
			if (columName.equals("category"))
				liveOrder.setCategory(rs.getString("category"));
			if (columName.equals("designer_id"))
				liveOrder.setDesignerId(rs.getInt("designer_id"));
			if (columName.equals("csr_id"))
				liveOrder.setCsrId(rs.getInt("csr_id"));
			if (columName.equals("order_status_id"))
				liveOrder.setOrderStatusId(rs.getInt("order_status_id"));

			if (columName.equals("production_status_id"))
				liveOrder.setProductionStatusId(rs.getInt("production_status_id"));

			if (columName.equals("order_status_name"))
				liveOrder.setOrderStatusTitle(rs.getString("order_status_name"));
			
			 if(columName.equals("production_status_name"))
				 liveOrder.setProductionStatusTitle(rs.getString("production_status_name"));

			if (columName.equals("club_id")) {
				club.setClubId(rs.getInt("club_id"));
				liveOrder.setClubId(rs.getInt("club_id"));
			}

			if (columName.equals("question"))
				liveOrder.setQuestion(rs.getInt("question"));

			if (columName.equals("adrep_id"))
				order.setAdRepId(rs.getInt("adrep_id"));
			if (columName.equals("first_name"))
				order.setAdRepName(rs.getString("first_name"));

			if (columName.equals("order_type_id"))
				order.setOrderTypeId(rs.getInt("order_type_id"));
			if (columName.equals("is_rush"))
				order.setRush(rs.getBoolean("is_rush"));
			if (columName.equals("created_on"))
				order.setCreatedOn(
						calendarUtil.getFormattedDateTime(rs.getDate("created_on"), rs.getTime("created_on")));

			if (columName.equals("order_id"))
				order.setOrderId(rs.getInt("order_id"));
			if (columName.equals("publication_id"))
				order.setPublicationId(rs.getInt("publication_id"));
			if (columName.equals("advertiser_name"))
				order.setAdvertiserName(rs.getString("advertiser_name"));
			liveOrder.setOrders(order);

			if (columName.equals("priority"))
				timeZone.setPriority(rs.getInt("priority"));
			liveOrder.setTimeZone(timeZone);

			if (columName.equals("club_name")) {
				String clubName = rs.getString("club_name");
				club.setName(clubName);
			}

			if (columName.equals("publication_name")) {
				String publicationName = rs.getString("publication_name");
				publication.setName(publicationName);
			}

			liveOrder.setClub(club);
			liveOrder.setPublication(publication);

		}
		return liveOrder;
	}

}
