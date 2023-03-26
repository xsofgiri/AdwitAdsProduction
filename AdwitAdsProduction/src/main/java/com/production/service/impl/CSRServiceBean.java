package com.production.service.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.production.entity.Designer;
import com.production.entity.LiveOrder;
import com.production.mapper.LiveOrderMapper;
import com.production.util.Constants;

@Service
public class CSRServiceBean {

	@Autowired
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	DBUtil dbUtil;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("setDataSource");
	}

	public ArrayList<LiveOrder> getCSRWorkStationOrderList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no, "
				+ "live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id as live_order_Status_id, "
				+ "live_order.production_status_id, live_order.club_id, orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ "orders.created_on, orders.question, orders.advertiser_name, time_zone.priority, "
				+ "adrep.first_name, adrep.last_name, orders.order_status_id, order_status.name as order_status_name FROM"
				+ " live_order RIGHT JOIN orders  ON orders.order_id = live_order.order_id  JOIN publication ON "
				+ "publication.publication_id = orders.publication_id  JOIN time_zone ON "
				+ "time_zone.time_zone_id = publication.time_zone_id JOIN adrep ON adrep.adrep_id = orders.adrep_id LEFT JOIN"
				+ " order_status ON live_order.order_status_id = order_status.order_status_id"
				+ " WHERE live_order.club_id IN (?) AND live_order.order_status_id =1 AND live_order.is_crequest != '1'";

		/*
		query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no, "
				+ "live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id as live_order_Status_id, "
				+ "live_order.production_status_id, live_order.club_id, orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ "orders.created_on, orders.question, orders.advertiser_name, time_zone.priority, "
				+ "adrep.first_name, adrep.last_name, orders.order_status_id, order_status.name as order_status_name FROM live_order RIGHT JOIN orders  ON orders.order_id = live_order.order_id  JOIN publication ON "
				+ "publication.publication_id = orders.publication_id  JOIN time_zone ON "
				+ "time_zone.time_zone_id = publication.time_zone_id JOIN adrep ON adrep.adrep_id = orders.adrep_id LEFT JOIN"
				+ " order_status ON orders.order_status_id = order_status.order_status_id"
				+ " WHERE live_order.club_id IN (?) AND live_order.order_status_id between '1' AND '4' AND live_order.is_crequest != '1'";

*/
		
		System.out.println("query : " + query+" designer.getClubIds() : "+designer.getClubIds());

		Object[] conditionObject = new Object[] { designer.getClubIds() };

		liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, conditionObject, new LiveOrderMapper());

		return liveOrderList;
	}

	public ArrayList<LiveOrder> getDesignerWorkStationOrderList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority "
				+ "FROM `live_order` JOIN `publication` ON publication.publication_id = live_order.publication_id"
				+ " JOIN `time_zone` ON time_zone.time_zone_id  = publication.time_zone_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN (?) AND live_order.club_id IN (?)  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority, "
				+ "orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ " orders.created_on, orders.question, orders.advertiser_name, orders.order_status_id,"
				+ " order_status.name as order_status_name, publication.name as publication_name, club.name as club_name, "
				+ " production_status.name as production_status_name "
				+ "FROM live_order LEFT JOIN orders ON orders.order_id = live_order.order_id JOIN publication"
				+ " ON publication.publication_id = live_order.publication_id"
				+ " JOIN time_zone ON time_zone.time_zone_id  = publication.time_zone_id LEFT JOIN "
				+ "	order_status ON live_order.order_status_id = order_status.order_status_id LEFT JOIN "
				+ "	production_status ON live_order.production_status_id = production_status.production_status_id  LEFT JOIN "
				+ " club ON club.club_id = live_order.club_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN ("+Constants.getSQLINParam(designer.getAdwitTeam().getCategory())+") AND"
						+ " live_order.club_id IN ("+designer.getAdwitTeam().getClubs()+")  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		System.out.println("query : " + query);

		try {
			liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, new LiveOrderMapper());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("liveOrderList : " + liveOrderList.size());
		return liveOrderList;
	}
	
	
	public ArrayList<LiveOrder> getDesignerInProductionList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority "
				+ "FROM `live_order` JOIN `publication` ON publication.publication_id = live_order.publication_id"
				+ " JOIN `time_zone` ON time_zone.time_zone_id  = publication.time_zone_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN (?) AND live_order.club_id IN (?)  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority, "
				+ "orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ " orders.created_on, orders.question, orders.advertiser_name, orders.order_status_id,"
				+ " order_status.name as order_status_name, publication.name as publication_name, club.name as club_name,"
				+ " production_status.name as production_status_name "
				+ "FROM live_order LEFT JOIN orders ON orders.order_id = live_order.order_id JOIN publication"
				+ " ON publication.publication_id = live_order.publication_id"
				+ " JOIN time_zone ON time_zone.time_zone_id  = publication.time_zone_id LEFT JOIN "
				+ "	order_status ON live_order.order_status_id = order_status.order_status_id LEFT JOIN "
				+ "	production_status ON live_order.production_status_id = production_status.production_status_id LEFT JOIN "
				+ " club ON club.club_id = live_order.club_id WHERE live_order.order_status_id = '3'"
				+ " and live_order.production_status_id IN (1, 6, 7, 8)"
				+ " AND live_order.designer_id=?  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		
		
		Object[] conditionObject = new Object[] { designer.getDesignerId() };
		
		System.out.println("query : " + query);

		try {
			liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, conditionObject, new LiveOrderMapper());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("liveOrderList : " + liveOrderList.size());
		return liveOrderList;
	}
	
	
	public ArrayList<LiveOrder> getDesignerDesignCheckList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority "
				+ "FROM `live_order` JOIN `publication` ON publication.publication_id = live_order.publication_id"
				+ " JOIN `time_zone` ON time_zone.time_zone_id  = publication.time_zone_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN (?) AND live_order.club_id IN (?)  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority, "
				+ "orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ " orders.created_on, orders.question, orders.advertiser_name, orders.order_status_id,"
				+ " order_status.name as order_status_name, publication.name as publication_name, club.name as club_name, "
				+ " production_status.name as production_status_name "
				+ " FROM live_order LEFT JOIN orders ON orders.order_id = live_order.order_id JOIN publication"
				+ " ON publication.publication_id = live_order.publication_id"
				+ " JOIN time_zone ON time_zone.time_zone_id  = publication.time_zone_id LEFT JOIN "
				+ "	order_status ON live_order.order_status_id = order_status.order_status_id LEFT JOIN "
				+ " production_status ON live_order.production_status_id = production_status.production_status_id LEFT JOIN "
				+ " club ON club.club_id = live_order.club_id WHERE live_order.order_status_id = '3' and live_order.production_status_id = '2'"
				+ " AND live_order.category IN ("+Constants.getSQLINParam(designer.getAdwitTeam().getCategory())+") AND"
						+ " live_order.club_id IN ("+designer.getAdwitTeam().getClubs()+")  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		
		
		System.out.println("query : " + query);

		try {
			liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, new LiveOrderMapper());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("liveOrderList : " + liveOrderList.size());
		return liveOrderList;
	}
	
	
	public ArrayList<LiveOrder> getDesignerQAList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority "
				+ "FROM `live_order` JOIN `publication` ON publication.publication_id = live_order.publication_id"
				+ " JOIN `time_zone` ON time_zone.time_zone_id  = publication.time_zone_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN (?) AND live_order.club_id IN (?)  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority, "
				+ "orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ " orders.created_on, orders.question, orders.advertiser_name, orders.order_status_id,"
				+ " order_status.name as order_status_name, publication.name as publication_name, club.name as club_name, "
				+ " production_status.name as production_status_name "
				+ " FROM live_order LEFT JOIN orders ON orders.order_id = live_order.order_id JOIN publication"
				+ " ON publication.publication_id = live_order.publication_id"
				+ " JOIN time_zone ON time_zone.time_zone_id  = publication.time_zone_id LEFT JOIN "
				+ "	order_status ON live_order.order_status_id = order_status.order_status_id LEFT JOIN "
				+ " production_status ON live_order.production_status_id = production_status.production_status_id LEFT JOIN "
				+ " club ON club.club_id = live_order.club_id WHERE live_order.order_status_id = '4' "
				+ " AND live_order.category IN ("+Constants.getSQLINParam(designer.getAdwitTeam().getCategory())+") AND"
						+ " live_order.club_id IN ("+designer.getAdwitTeam().getClubs()+")  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		
		
		System.out.println("query : " + query);

		try {
			liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, new LiveOrderMapper());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("liveOrderList : " + liveOrderList.size());
		return liveOrderList;
	}
	
	
	
	public ArrayList<LiveOrder> getCSRQAList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority "
				+ "FROM `live_order` JOIN `publication` ON publication.publication_id = live_order.publication_id"
				+ " JOIN `time_zone` ON time_zone.time_zone_id  = publication.time_zone_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN (?) AND live_order.club_id IN (?)  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority, "
				+ "orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ " orders.created_on, orders.question, orders.advertiser_name, orders.order_status_id,"
				+ " order_status.name as order_status_name, publication.name as publication_name, club.name as club_name, "
				+ " production_status.name as production_status_name "
				+ " FROM live_order LEFT JOIN orders ON orders.order_id = live_order.order_id JOIN publication"
				+ " ON publication.publication_id = live_order.publication_id"
				+ " JOIN time_zone ON time_zone.time_zone_id  = publication.time_zone_id LEFT JOIN "
				+ "	order_status ON live_order.order_status_id = order_status.order_status_id LEFT JOIN "
				+ " production_status ON live_order.production_status_id = production_status.production_status_id LEFT JOIN "
				+ " club ON club.club_id = live_order.club_id WHERE live_order.order_status_id = '4' "
				+ " AND live_order.category IN ("+Constants.getSQLINParam(designer.getCategoryLevel())+") AND"
						+ " live_order.club_id IN ("+designer.getClubIds()+")  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		
		System.out.println("query : " + query);

		try {
			liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, new LiveOrderMapper());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("liveOrderList : " + liveOrderList.size());
		return liveOrderList;
	}
	
	
	
	public ArrayList<LiveOrder> getCSRProofReadyList(Designer designer) {
		ArrayList<LiveOrder> liveOrderList = new ArrayList<LiveOrder>();

		String query = "SELECT live_order.live_order_id, live_order.publication_id, live_order.order_id, live_order.job_no,"
				+ " live_order.category, live_order.designer_id, live_order.csr_id, live_order.order_status_id,"
				+ " live_order.production_status_id, live_order.club_id, live_order.question, time_zone.priority "
				+ "FROM `live_order` JOIN `publication` ON publication.publication_id = live_order.publication_id"
				+ " JOIN `time_zone` ON time_zone.time_zone_id  = publication.time_zone_id WHERE live_order.order_status_id = '2'"
				+ " AND live_order.category IN (?) AND live_order.club_id IN (?)  AND live_order.is_crequest != '1' AND"
				+ " live_order.question != '1' ORDER BY live_order.category DESC";
		
		query = "SELECT orders.adrep_id, orders.order_type_id, orders.is_rush, "
				+ " orders.created_on, orders.question, orders.advertiser_name, orders.order_status_id,"
				+ " order_status.name as order_status_name, publication.name as publication_name, club.name as club_name, "
				+ " production_status.name as production_status_name "
				+ " FROM orders JOIN publication"
				+ " ON publication.publication_id = orders.publication_id"
				+ " JOIN time_zone ON time_zone.time_zone_id  = publication.time_zone_id LEFT JOIN "
				+ "	order_status ON orders.order_status_id = order_status.order_status_id LEFT JOIN "
				+ " club ON club.club_id = orders.club_id WHERE orders.order_status_id = '5' "
				+ " AND live_order.category IN ("+Constants.getSQLINParam(designer.getCategoryLevel())+") AND"
						+ " orders.club_id IN ("+designer.getClubIds()+")  AND orders.is_crequest != '1' AND"
				+ " orders.question != '1' ORDER BY live_order.category DESC";
		
		
		System.out.println("query : " + query);

		try {
			liveOrderList = (ArrayList<LiveOrder>) jdbcTemplate.query(query, new LiveOrderMapper());
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("liveOrderList : " + liveOrderList.size());
		return liveOrderList;
	}

}
