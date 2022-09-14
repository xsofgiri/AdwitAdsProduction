package com.production.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.production.entity.Order;
import com.production.entity.PageHandler;
import com.production.entity.Publication;
import com.production.entity.RevSoldJob;
import com.production.entity.User;
import com.production.util.MD5;

@Service
public class UserServiceBean {

	@Autowired
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DBUtil dbUtil;

	private static final String pdfBaseURL = "https://adwitads.com/weborders";

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("setDataSource");
	}

	public int checkUser(String loginName, String password) {
		int adrepId = 0;
		try {
			MD5 md5 = new MD5();
			md5.Init();
			md5.Update(password);
			password = md5.asHex().toLowerCase();

			Object[] conditionObject = new Object[] { loginName, loginName, password };

			System.out.println("jdbcTemplate : " + jdbcTemplate.getDataSource().getConnection());

			adrepId = jdbcTemplate.queryForObject(
					"SELECT adrep_id FROM adrep WHERE (username=? OR email_id=?) AND password=?", conditionObject,
					Integer.class);

			System.out.println("adrepId : " + adrepId);

		} catch (Exception e) {
			System.out.println("checkUser : " + e);
		}

		return adrepId;
	}

	public User getAdRepDetails(int adrepId) {
		User user = null;

		try {
			Object[] conditionObject = new Object[] { adrepId };

			System.out.println("adrepId : "+adrepId);
			user = jdbcTemplate
					.queryForObject(
							"SELECT adrep_id, first_name, last_name, gender, email_id, publication_id, username, email_cc, address, fax, image,"
									+ " is_ad_search, display_orders, new_ui, is_page, is_team_orders, is_rush, is_template, coupon_spec, billing,"
									+ " is_print_ad, is_online_ad, is_pagedesign_ad, encrypted_key, is_premium, color_code, created_on, is_active,"
									+ " is_deleted FROM adrep WHERE adrep_id=?",
							conditionObject, new RowMapper<User>() {
								public User mapRow(ResultSet rs, int rowNum) throws SQLException {
									User user = new User();

									user.setAdrepId(rs.getInt("adrep_id"));
									user.setFirstName(rs.getString("first_name"));
									user.setLastName(rs.getString("last_name"));
									user.setEmail(rs.getString("email_id"));
									user.setUsername(rs.getString("username"));
									System.out.println("publication_id : "+rs.getInt("publication_id"));
									
									user.setPublication(getPublicationDetails(rs.getInt("publication_id")));

									return user;
								}
							});
		} catch (Exception e) {
			System.out.println("getAdRepDetails : " + e);
		}
		return user;
	}

	public int getQueryCount(String sqlQuery, Object[] conditionObject) {
		int count = 0;
		try {

			count = jdbcTemplate.queryForObject(sqlQuery, conditionObject, Integer.class);

		} catch (Exception e) {
			System.out.println("getQueryCount : " + e);
		}

		return count;
	}

	public ArrayList<Order> getLatestDashboardAds(int adRepId, int orderStatus, int limit) {
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {

			Object[] conditionObject = new Object[] { adRepId, orderStatus };
			String sqlQuery = "SELECT order_id, job_no, pdf FROM `order` WHERE adrep_id = ? AND order_status_id = ? order by created_on desc limit "
					+ limit;

			orderList = (ArrayList<Order>) jdbcTemplate.query(sqlQuery, conditionObject, new RowMapper<Order>() {
				public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
					Order order = new Order();

					order.setOrderId(rs.getInt("order_id"));
					order.setJobNo(rs.getString("job_no"));
					order.setPdfPath(pdfBaseURL + "/" + rs.getString("pdf"));

					return order;
				}
			});

		} catch (Exception e) {
			System.out.println("getLatestDashboardAds : " + e);
		}

		return orderList;
	}

	public ArrayList<Order> getDashboardAds(int adRepId, PageHandler pageHandler, String whrCondition) {
		ArrayList<Order> orderList = new ArrayList<Order>();
		try {

			String sqlQuery = "SELECT order_id, job_no, pdf, advertiser_name, adrep_id, activity_time, rev_sold_job_id, "
					+ "if(rev_order_status>0, rev_order_status, order_status_id) as order_status FROM `order` WHERE order_type_id!=6 " + whrCondition
					+ " order by order_id desc limit " + pageHandler.getLimit() + " offset "
					+ pageHandler.getOffset();

			System.out.println("sqlQuery : "+sqlQuery);
			
			orderList = (ArrayList<Order>) jdbcTemplate.query(sqlQuery, new RowMapper<Order>() {
				public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
					Order order = new Order();

					order.setOrderId(rs.getInt("order_id"));
					order.setJobNo(rs.getString("job_no"));
					order.setPdfPath(pdfBaseURL + "/" + rs.getString("pdf"));
					
					order.setStatus(rs.getInt("order_status"));
					order.setAdvertiserName(rs.getString("advertiser_name"));
					User adRep = getAdRepDetails(rs.getInt("adrep_id"));
					order.setAdRepName(adRep.getFirstName()+" "+adRep.getLastName());
					order.setActivityTime(rs.getString("activity_time"));
					int revSoldJobId = rs.getInt("rev_sold_job_id");
					
					if(revSoldJobId>0){
						RevSoldJob revSoldJob = getRevSoldJobDetails(revSoldJobId);
						order.setStatus(revSoldJob.getStatus());
						order.setPdfPath(revSoldJob.getPdfPath());
					}
					 
					order.setOrderStatus(getOrderStatusName(order.getStatus()));
					order.setRevSoldStatus(rs.getInt("order_status"));
					return order;
				}
			});

		} catch (Exception e) {
			System.out.println("getDashboardAds : " + e);
		}

		return orderList;
	}

	
	public Publication getPublicationDetails(int publicationId) {
		Publication publication = null;
		try {

			String sqlQuery = "SELECT publication_id, business_group_id, group_id, name, advertising_director_email_id, design_team_id,"
					+ " team_lead_id, spec_ads, sold_ads, cat_slug_type_id, csr_id_QA, tag_csr_id, cat_newspaper_id, initial,"
					+ " is_custom_sizes, help_desk_id, is_enable_source, is_enable_request, is_enable_project, rev_days, customer,"
					+ " invoice_amount, customer_id, ordering_system_id, channel_id, time_zone_id, city, approve, is_theme, email,"
					+ " is_idml, is_active, is_deleted, is_live_tracker, club_id, is_pdf_review FROM publication"
					+ " WHERE is_active=1 and publication_id= "
					+ publicationId;

			publication = (Publication) jdbcTemplate.queryForObject(sqlQuery, new RowMapper<Publication>() {
				public Publication mapRow(ResultSet rs, int rowNum) throws SQLException {
					Publication publication = new Publication();

					publication.setPublicationId(rs.getInt("publication_id"));
					publication.setName(rs.getString("name"));
					publication.setEnableProject(rs.getBoolean("is_enable_project"));
					publication.setGroupId(rs.getInt("group_id"));
					publication.setClubId(rs.getInt("club_id"));
					publication.setLiveTracker(rs.getBoolean("is_live_tracker"));
					publication.setPDFReview(rs.getBoolean("is_pdf_review"));
					publication.setCustomSize(rs.getBoolean("is_custom_sizes"));
					return publication;
				}
			});

		} catch (Exception e) {
			System.out.println("getPublicationDetails : " + e);
		}

		return publication;
	}
	
	
	public RevSoldJob getRevSoldJobDetails(int revSoldJobId){
		RevSoldJob revSoldJob = null;
		try {

			String sqlQuery = "SELECT pdf_path, rev_order_status_id FROM rev_sold_job WHERE rev_sold_job_id= ?";
			Object[] conditionObject = new Object[] { revSoldJobId };
			
			revSoldJob = (RevSoldJob) jdbcTemplate.queryForObject(sqlQuery, conditionObject, new RowMapper<RevSoldJob>() {
				public RevSoldJob mapRow(ResultSet rs, int rowNum) throws SQLException {
					RevSoldJob revSoldJob = new RevSoldJob();

					revSoldJob.setStatus(rs.getInt("rev_order_status_id"));
					revSoldJob.setPdfPath(pdfBaseURL + "/" + rs.getString("pdf_path"));

					return revSoldJob;
				}
			});

		} catch (Exception e) {
			System.out.println("getPublicationDetails : " + e);
		}

		return revSoldJob;
	}

	
	public String getOrderStatusName(int status){
		String query = "SELECT name FROM order_status WHERE order_status_id=?";
		Object[] conditionObject = new Object[] { status };
		
		String orderStatus = null;
		
		orderStatus = (String) jdbcTemplate.queryForObject(query, conditionObject, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("name");
			}
		});
		
		return orderStatus;
	}
	
	
}
