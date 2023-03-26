package com.production.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.production.entity.Orders;
import com.production.entity.PageHandler;
import com.production.entity.Publication;
import com.production.entity.RevSoldJob;
import com.production.mapper.AdwitTeamsMapper;
import com.production.mapper.ClubMapper;
import com.production.mapper.PublicationMapper;
import com.production.entity.Adrep;
import com.production.entity.AdwitTeams;
import com.production.entity.Club;
import com.production.entity.Designer;
import com.production.util.CalendarUtil;
import com.production.util.Constants;
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

	public int validateDesigner(String email, String password) {
		int designerId = 0;
		try {
			MD5 md5 = new MD5();
			md5.Init();
			md5.Update(password);
			password = md5.asHex().toLowerCase();

			Object[] conditionObject = new Object[] { email, email, password };

			System.out.println("jdbcTemplate : " + jdbcTemplate.getDataSource().getConnection());

			designerId = jdbcTemplate.queryForObject(
					"SELECT designer_id FROM designer WHERE (username=? OR email_id=?) AND password=?", conditionObject,
					Integer.class);

			System.out.println("designerId : " + designerId);

		} catch (Exception e) {
			System.out.println("checkUser : " + e);
		}

		return designerId;
	}

	public int validateCSR(String email, String password) {
		int csrId = 0;
		try {
			MD5 md5 = new MD5();
			md5.Init();
			md5.Update(password);
			password = md5.asHex().toLowerCase();

			Object[] conditionObject = new Object[] { email, email, password };

			System.out.println("jdbcTemplate : " + jdbcTemplate.getDataSource().getConnection());

			csrId = jdbcTemplate.queryForObject(
					"SELECT csr_id FROM csr WHERE (username=? OR email_id=?) AND password=?", conditionObject,
					Integer.class);

			System.out.println("csrId : " + csrId);

		} catch (Exception e) {
			System.out.println("checkUser : " + e);
		}

		return csrId;
	}

	public Designer getDesignerDetails(int designerId) {
		Designer designer = null;

		try {
			Object[] conditionObject = new Object[] { designerId };

			System.out.println("designerId : " + designerId);
			designer = jdbcTemplate.queryForObject(
					"SELECT designer_id, name, gender, email_id, mobile_no, username, password, pwd_date, saral_id,"
							+ " designer_level_id, join_location_id, work_location_id, is_online_ad, designer_role_id, encrypted_key,"
							+ " image, shift_factor, shift_factor_status, is_new_d, pwd_expiry_date, created_on, is_active, is_deleted,"
							+ " publication_id, category_level, club_id, alias, adwit_teams_id, isEnabled_adwit_teams FROM designer WHERE designer_id=?",
					conditionObject, new RowMapper<Designer>() {
						public Designer mapRow(ResultSet rs, int rowNum) throws SQLException {
							Designer user = new Designer();

							user.setDesignerId(rs.getInt("designer_id"));
							user.setName(rs.getString("name"));
							user.setEmail(rs.getString("email_id"));
							user.setUsername(rs.getString("username"));
							user.setAdwitTeam(getAdwitTeamDetails(rs.getInt("adwit_teams_id")));

							return user;
						}
					});
		} catch (Exception e) {
			System.out.println("getDesignerDetails : " + e);
		}
		return designer;
	}

	public Designer getCSRDetails(int csrId) {
		Designer designer = null;

		try {
			Object[] conditionObject = new Object[] { csrId };

			System.out.println("csrId : " + csrId);
			designer = jdbcTemplate.queryForObject(
					"SELECT csr_id, name, alias, gender, csr_role_id, business_group_id, is_team, email_id, username, password,"
							+ " pwd_date, saral_id, mobile_no, join_location_id, work_location_id, ext_no, shift_factor, is_new_csr,"
							+ " is_web_ad, is_requests, image_path, pwd_expiry_date, encrypted_key, created_on, is_active, is_deleted,"
							+ " publication_id, category_level, club_id, is_pdf_review_tool FROM csr WHERE csr_id=?",
					conditionObject, new RowMapper<Designer>() {
						public Designer mapRow(ResultSet rs, int rowNum) throws SQLException {
							Designer csr = new Designer();

							csr.setDesignerId(rs.getInt("csr_id"));
							csr.setName(rs.getString("name"));
							csr.setEmail(rs.getString("email_id"));
							csr.setUsername(rs.getString("username"));
							csr.setClubIds(rs.getString("club_id"));
							csr.setCategoryLevel(rs.getString("category_level"));
							csr.setPublicationIds(rs.getString("publication_id"));
							// csr.setAdwitTeam(getAdwitTeamDetails(rs.getInt("adwit_teams_id")));

							csr.setCSR(true);

							System.out.println("publication_id : " + rs.getInt("publication_id"));

							return csr;
						}
					});
		} catch (Exception e) {
			System.out.println("getDesignerDetails : " + e);
		}
		return designer;
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

	public ArrayList<Orders> getLatestDashboardAds(int adRepId, int orderStatus, int limit) {
		ArrayList<Orders> orderList = new ArrayList<Orders>();
		try {

			Object[] conditionObject = new Object[] { adRepId, orderStatus };
			String sqlQuery = "SELECT order_id, job_no, pdf FROM `order` WHERE adrep_id = ? AND order_status_id = ? order by created_on desc limit "
					+ limit;

			orderList = (ArrayList<Orders>) jdbcTemplate.query(sqlQuery, conditionObject, new RowMapper<Orders>() {
				public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
					Orders order = new Orders();

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

	public Publication getPublicationDetails(int publicationId) {
		Publication publication = null;
		try {

			String sqlQuery = "SELECT publication_id, business_group_id, group_id, name, advertising_director_email_id, design_team_id,"
					+ " team_lead_id, spec_ads, sold_ads, cat_slug_type_id, csr_id_QA, tag_csr_id, cat_newspaper_id, initial,"
					+ " is_custom_sizes, help_desk_id, is_enable_source, is_enable_request, is_enable_project, rev_days, customer,"
					+ " invoice_amount, customer_id, ordering_system_id, channel_id, time_zone_id, city, approve, is_theme, email,"
					+ " is_idml, is_active, is_deleted, is_live_tracker, club_id, is_pdf_review FROM publication"
					+ " WHERE is_active=1 and publication_id= " + publicationId;

			/*
			 * publication = (Publication) jdbcTemplate.queryForObject(sqlQuery, new
			 * RowMapper<Publication>() { public Publication mapRow(ResultSet rs, int
			 * rowNum) throws SQLException { Publication publication = new Publication();
			 * 
			 * publication.setPublicationId(rs.getInt("publication_id"));
			 * publication.setName(rs.getString("name"));
			 * publication.setEnableProject(rs.getBoolean("is_enable_project"));
			 * publication.setGroupId(rs.getInt("group_id"));
			 * publication.setClubId(rs.getInt("club_id"));
			 * publication.setLiveTracker(rs.getBoolean("is_live_tracker"));
			 * publication.setPDFReview(rs.getBoolean("is_pdf_review"));
			 * publication.setCustomSize(rs.getBoolean("is_custom_sizes")); return
			 * publication; } });
			 */

			publication = (Publication) jdbcTemplate.queryForObject(sqlQuery, new PublicationMapper());

		} catch (Exception e) {
			System.out.println("getPublicationDetails : " + e);
		}

		return publication;
	}

	public RevSoldJob getRevSoldJobDetails(int revSoldJobId) {
		RevSoldJob revSoldJob = null;
		try {

			String sqlQuery = "SELECT pdf_path, rev_order_status_id FROM rev_sold_job WHERE rev_sold_job_id= ?";
			Object[] conditionObject = new Object[] { revSoldJobId };

			revSoldJob = (RevSoldJob) jdbcTemplate.queryForObject(sqlQuery, conditionObject,
					new RowMapper<RevSoldJob>() {
						public RevSoldJob mapRow(ResultSet rs, int rowNum) throws SQLException {
							RevSoldJob revSoldJob = new RevSoldJob();

							revSoldJob.setRevOrderStatusID(rs.getInt("rev_order_status_id"));
							revSoldJob.setPdfPath(pdfBaseURL + "/" + rs.getString("pdf_path"));

							return revSoldJob;
						}
					});

		} catch (Exception e) {
			System.out.println("getPublicationDetails : " + e);
		}

		return revSoldJob;
	}

	public String getOrderStatusName(int status) {
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

	public AdwitTeams getAdwitTeamDetails(int adwitTeamId) {
		AdwitTeams adwitTeams = null;
		try {
			String query = "SELECT adwit_teams_id, name, is_active, category FROM adwit_teams WHERE adwit_teams_id=?";
			Object[] conditionObject = new Object[] { adwitTeamId };

			adwitTeams = jdbcTemplate.queryForObject(query, conditionObject, new AdwitTeamsMapper());
			if (adwitTeams != null && adwitTeams.getAdwitTeamsId() > 0) {

				ArrayList<Club> clubList = getAdwitTeamClubs(adwitTeams.getAdwitTeamsId());
				if (clubList != null && clubList.size() > 0) {
					adwitTeams.setClubList(clubList);
					String clubs = Constants.getClubIds(clubList);
					System.err.println("clubs : " + clubs);
					adwitTeams.setClubs(clubs);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return adwitTeams;

	}

	public ArrayList<Club> getAdwitTeamClubs(int adwitTeamId) {
		ArrayList<Club> clubList = new ArrayList<Club>();
		try {
			String query = "SELECT club.club_id, club.name FROM adwit_teams_and_club left join club on"
					+ " club.club_id=adwit_teams_and_club.club_id WHERE adwit_teams_and_club.adwit_teams_id=?";
			Object[] conditionObject = new Object[] { adwitTeamId };

			clubList = (ArrayList<Club>) jdbcTemplate.query(query, conditionObject, new ClubMapper());

		} catch (Exception e) {
			System.out.println(e);
		}

		return clubList;

	}

	public boolean hasAdrepTakenSurvey(int surveryId, int adrepId) {

		boolean hasTaken = false;
		try {

			String sqlQuery = "SELECT ADREP_SURVEY_ID FROM adrep_survey WHERE SURVEY_ID=? AND ADREP_ID=?";
			Object[] conditionObject = new Object[] { surveryId, adrepId };

			hasTaken = dbUtil.getJDBCIntResult(sqlQuery, conditionObject) > 0 ? true : false;

		} catch (Exception e) {
			System.out.println("sendOrderToAdRep : " + e);
		}

		return hasTaken;
	}

	public int addSurveyResponse(ArrayList<String> quizResponse, int surveryId, int adrepId, String ipAddress) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();
		try {
			String sqlQuery = "INSERT INTO adrep_survey (SURVEY_ID, ADREP_ID, Q1, Q2, Q3, Q4, Q5, STATUS, TAKEN_ON, IP_ADDRESS)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			Object[] conditionObject = new Object[] { surveryId, adrepId, Integer.parseInt(quizResponse.get(0)), Integer.parseInt(quizResponse.get(1)),
					Integer.parseInt(quizResponse.get(2)), Integer.parseInt(quizResponse.get(3)), quizResponse.get(4), 1,
					calendarUtil.getESTCurrentDateTime(), ipAddress };

			result = jdbcTemplate.update(sqlQuery, conditionObject);
 
		} catch (Exception e) {
			System.out.println("sendOrderToAdRep : " + e);
		}
		return result;
	}

}
