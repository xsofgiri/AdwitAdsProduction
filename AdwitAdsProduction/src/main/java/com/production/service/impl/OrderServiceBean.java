package com.production.service.impl;

import java.io.File;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.production.entity.FlexitiveSize;
import com.production.entity.MoodBoard;
import com.production.entity.Order;
import com.production.entity.OrderCustomSize;
import com.production.entity.PixelSize;
import com.production.entity.PubProject;
import com.production.entity.Publication;
import com.production.util.CalendarUtil;
import com.production.util.Constants;

@Service
public class OrderServiceBean {

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

	public ArrayList<MoodBoard> getMoodBoardList() {
		ArrayList<MoodBoard> moodBoardList = new ArrayList<MoodBoard>();
		try {

			String sqlQuery = "SELECT mood_board_id, name, path FROM mood_board where name!='none'";

			moodBoardList = (ArrayList<MoodBoard>) jdbcTemplate.query(sqlQuery, new RowMapper<MoodBoard>() {
				public MoodBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
					MoodBoard moodBoard = new MoodBoard();

					moodBoard.setMoodBoardId(rs.getInt("mood_board_id"));
					String moodBoardTitle = rs.getString("name");

					moodBoard.setName(moodBoardTitle);
					String moodPath = pdfBaseURL + "/" + rs.getString("path");
					System.out.println("moodPath : " + moodPath);

					if (moodBoardTitle != null && !"none".equals(moodBoardTitle)) {
						moodBoard.setPath(moodPath);
						ArrayList<String> imagePath = new ArrayList<String>();
						try {
							File dir = new File("/var/lib/tomcat7/webapps/adwit-api/assets/images/mood_board/"
									+ moodBoardTitle + "/");

							System.out.println(dir.getAbsolutePath());
							System.out.println(dir.getCanonicalPath());
							System.out.println(dir.getPath());

							if (dir.isDirectory()) {
								System.out.println("is directory");
								File[] files = dir.listFiles();

								if (files != null) {
									for (File file : files) {
										if (file.isFile()) {
											System.out.println("file.getName() : " + file.getName());

											imagePath.add(moodPath + "/" + file.getName());
										}
									}
								}
							} else {
								System.out.println("not a directory");
							}
						} catch (Exception e) {
							System.out.println(e);
						}

						moodBoard.setImagePath(imagePath);
						return moodBoard;
					} else {
						return null;
					}

				}
			});

		} catch (Exception e) {
			System.out.println("getMoodBoardList : " + e);
		}

		return moodBoardList;
	}

	public ArrayList<Publication> getPublicationList(int adRepId) {
		ArrayList<Publication> publicationList = new ArrayList<Publication>();
		try {

			String sqlQuery = "SELECT mood_board_id, name, path FROM mood_board";

			publicationList = (ArrayList<Publication>) jdbcTemplate.query(sqlQuery, new RowMapper<Publication>() {
				public Publication mapRow(ResultSet rs, int rowNum) throws SQLException {
					Publication publication = new Publication();

					return publication;
				}
			});

		} catch (Exception e) {
			System.out.println("getPublicationList : " + e);
		}

		return publicationList;
	}

	public ArrayList<FlexitiveSize> getFlexitiveSizeList(int adRepId) {
		ArrayList<FlexitiveSize> flexitiveSizeList = new ArrayList<FlexitiveSize>();
		try {

			String sqlQuery = "SELECT flexitive_size_id, ratio, min, max, text FROM flexitive_size";

			flexitiveSizeList = (ArrayList<FlexitiveSize>) jdbcTemplate.query(sqlQuery, new RowMapper<FlexitiveSize>() {
				public FlexitiveSize mapRow(ResultSet rs, int rowNum) throws SQLException {
					FlexitiveSize flexitiveSize = new FlexitiveSize();
					flexitiveSize.setFlexitiveSizeId(rs.getInt("flexitive_size_id"));
					flexitiveSize.setText(rs.getString("text"));
					flexitiveSize.setMinimum(rs.getInt("min"));
					flexitiveSize.setMaximum(rs.getInt("max"));
					flexitiveSize.setRatio(rs.getString("ratio"));
					return flexitiveSize;
				}
			});

		} catch (Exception e) {
			System.out.println("getFlexitiveSizeList : " + e);
		}

		return flexitiveSizeList;
	}
	
	
	public FlexitiveSize getFlexitiveSizeDetails(int flexitiveSizeId) {
		FlexitiveSize flexitiveSize = null;
		try {

			String sqlQuery = "SELECT flexitive_size_id, ratio, min, max, text FROM flexitive_size where flexitive_size_id=?";
			Object[] conditionObject = new Object[] { flexitiveSizeId };
			
			flexitiveSize = (FlexitiveSize) jdbcTemplate.queryForObject(sqlQuery, conditionObject, new RowMapper<FlexitiveSize>() {
				public FlexitiveSize mapRow(ResultSet rs, int rowNum) throws SQLException {
					FlexitiveSize flexitiveSize = new FlexitiveSize();
					flexitiveSize.setFlexitiveSizeId(rs.getInt("flexitive_size_id"));
					flexitiveSize.setText(rs.getString("text"));
					flexitiveSize.setMinimum(rs.getInt("min"));
					flexitiveSize.setMaximum(rs.getInt("max"));
					flexitiveSize.setRatio(rs.getString("ratio"));
					return flexitiveSize;
				}
			});

		} catch (Exception e) {
			System.out.println("getFlexitiveSizeDetails : " + e);
		}

		return flexitiveSize;
	}
	

	public ArrayList<PixelSize> getPixelSizeList(int adRepId) {
		ArrayList<PixelSize> pixelSizeList = new ArrayList<PixelSize>();
		try {

			String sqlQuery = "SELECT pixel_size_id, name, width, height, is_active, is_deleted FROM pixel_size where is_active=1";

			pixelSizeList = (ArrayList<PixelSize>) jdbcTemplate.query(sqlQuery, new RowMapper<PixelSize>() {
				public PixelSize mapRow(ResultSet rs, int rowNum) throws SQLException {
					PixelSize pixelSize = new PixelSize();
					pixelSize.setPixelSizeId(rs.getInt("pixel_size_id"));
					pixelSize.setName(rs.getString("name"));
					pixelSize.setWidth(rs.getInt("width"));
					pixelSize.setHeight(rs.getInt("height"));

					return pixelSize;
				}
			});

		} catch (Exception e) {
			System.out.println("getPixelSizeList : " + e);
		}

		return pixelSizeList;
	}
	
	
	public PixelSize getPixelSizeDetails(int pixelSizeId) {
		PixelSize pixelSize = null;
		try {

			String sqlQuery = "SELECT pixel_size_id, name, width, height, is_active, is_deleted FROM pixel_size where is_active=1 and pixel_size_id=?";
			Object[] conditionObject = new Object[] { pixelSizeId };
			
			pixelSize = (PixelSize) jdbcTemplate.queryForObject(sqlQuery, conditionObject, new RowMapper<PixelSize>() {
				public PixelSize mapRow(ResultSet rs, int rowNum) throws SQLException {
					PixelSize pixelSize = new PixelSize();
					pixelSize.setPixelSizeId(rs.getInt("pixel_size_id"));
					pixelSize.setName(rs.getString("name"));
					pixelSize.setWidth(rs.getInt("width"));
					pixelSize.setHeight(rs.getInt("height"));

					return pixelSize;
				}
			});

		} catch (Exception e) {
			System.out.println("getPixelSizeDetails : " + e);
		}

		return pixelSize;
	}
	

	public ArrayList<PubProject> getPubProjectList(int publicationId) {
		ArrayList<PubProject> pubProjectList = new ArrayList<PubProject>();
		try {

			String sqlQuery = "SELECT pub_project_id, name, publication_id, initial FROM pub_project where publication_id=?";
			Object[] conditionObject = new Object[] { publicationId };

			pubProjectList = (ArrayList<PubProject>) jdbcTemplate.query(sqlQuery, conditionObject,
					new RowMapper<PubProject>() {
						public PubProject mapRow(ResultSet rs, int rowNum) throws SQLException {
							PubProject pubProject = new PubProject();
							pubProject.setPubProjectId(rs.getInt("pub_project_id"));
							pubProject.setName(rs.getString("name"));
							pubProject.setInitial(rs.getString("initial"));

							return pubProject;
						}
					});

		} catch (Exception e) {
			System.out.println("getPubProjectList : " + e);
		}

		return pubProjectList;
	}

	public ArrayList<OrderCustomSize> getOrderCustomSizeList(int publicationId) {
		ArrayList<OrderCustomSize> orderCustomSizeList = new ArrayList<OrderCustomSize>();
		try {

			String sqlQuery = "SELECT order_custom_size_id, name, width, height, publication_id FROM order_custom_size where publication_id=?";
			Object[] conditionObject = new Object[] { publicationId };
			
			orderCustomSizeList = (ArrayList<OrderCustomSize>) jdbcTemplate.query(sqlQuery, conditionObject,
					new RowMapper<OrderCustomSize>() {
						public OrderCustomSize mapRow(ResultSet rs, int rowNum) throws SQLException {
							OrderCustomSize orderCustomSize = new OrderCustomSize();
							orderCustomSize.setOrderCustomSizeId(rs.getInt("order_custom_size_id"));
							orderCustomSize.setTitle(rs.getString("name"));
							orderCustomSize.setHeight(rs.getString("height"));
							orderCustomSize.setWidth(rs.getString("width"));
							return orderCustomSize;
						}
					});

		} catch (Exception e) {
			System.out.println("getOrderCustomSizeList : " + e);
		}

		return orderCustomSizeList;
	}

	
	
	public OrderCustomSize getOrderCustomSizeDetail(int orderCustomSizeId) {
		OrderCustomSize orderCustomSize = null;
		
		try {

			String sqlQuery = "SELECT order_custom_size_id, name, width, height, publication_id FROM order_custom_size where order_custom_size_id=?";
			Object[] conditionObject = new Object[] { orderCustomSizeId };
			
			orderCustomSize = (OrderCustomSize) jdbcTemplate.queryForObject(sqlQuery, conditionObject,
					new RowMapper<OrderCustomSize>() {
						public OrderCustomSize mapRow(ResultSet rs, int rowNum) throws SQLException {
							OrderCustomSize orderCustomSize = new OrderCustomSize();
							orderCustomSize.setOrderCustomSizeId(rs.getInt("order_custom_size_id"));
							orderCustomSize.setTitle(rs.getString("name"));
							orderCustomSize.setHeight(rs.getString("height"));
							orderCustomSize.setWidth(rs.getString("width"));
							return orderCustomSize;
						}
					});

		} catch (Exception e) {
			System.out.println("getFlexitiveSizeList : " + e);
		}

		return orderCustomSize;
	}

	
	public int placeOrder(Order order) {
		int orderId = -1;
		CalendarUtil calendarUtil = new CalendarUtil();
		try {

			java.util.Date getNextMondayDate = calendarUtil
					.addDaysToJavaUtilDate(calendarUtil.parseDate(calendarUtil.getESTCurrentDate(), "yyyy-MM-dd"));
			System.out.println("getNextMondayDate :" + getNextMondayDate);

			Date dateNeeded = Constants.isStringNotNull(order.getOrderNeededBy())
					? calendarUtil.convertDateJavaToSql(calendarUtil.parseDate(order.getOrderNeededBy(), "dd/mm/yyyy"))
					: null;
			Date publishDate = Constants.isStringNotNull(order.getPublishDate())
					? calendarUtil.convertDateJavaToSql(calendarUtil.parseDate(order.getPublishDate(), "dd/mm/yyyy"))
					: calendarUtil.convertDateJavaToSql(getNextMondayDate);

			int mapOrderId = 0, csrId = 0, webAdFormatId = order.getWebAdFormatId();

			String sqlQuery = "INSERT INTO `order` (adrep_id, publication_id, order_type_id, advertiser_name, publish_date,"
					+ " publication_name, date_needed, copy_content_description, job_instruction, art_work, job_no, color_preferences,"
					+ " font_preferences, notes, width, height, print_ad_type_id,  file_path, created_on,"
					+ " pub_project_id, is_rush, map_order_id, csr_id, pixel_size, web_ad_format_id, activity_time,"
					+ " maxium_file_size, web_ad_type, club_id) values"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			Object[] conditionObject = new Object[] { order.getAdRepId(), order.getPublicationId(),
					order.getOrderTypeId(), order.getAdvertiserName(), publishDate, order.getPublicationName(),
					dateNeeded, order.getCopyContent(), order.getJobInstructionId(), order.getArtWorkId(),
					order.getJobNo(), order.getColorPreferences(), order.getFontPreferences(), order.getNotes(),
					order.getWidth(), order.getHeight(), order.getPrintAdType(), "file_path",
					calendarUtil.getESTCurrentDateTime(), order.getPubProjectId(), order.isRush(), mapOrderId, csrId,
					"", webAdFormatId, calendarUtil.getESTCurrentDateTime(), order.getMaxiumFileSize(), order.getWebAdType(), 
					order.getClubId()};

			int result = jdbcTemplate.update(sqlQuery, conditionObject);
			System.out.println("result : " + result);

			if (result > 0) {
				String query = "select order_id FROM `order` where adrep_id=? AND publication_id=? AND order_type_id=? order by created_on desc limit 1";
				Object[] params = new Object[] { order.getAdRepId(), order.getPublicationId(), order.getOrderTypeId() };

				System.out.println("query : " + query);
				System.out.println("order.getAdRepId() : " + order.getAdRepId());
				System.out.println("order.getPublicationId() : " + order.getPublicationId());
				System.out.println("order.getOrderTypeId() : " + order.getOrderTypeId());

				orderId = (Integer) jdbcTemplate.queryForObject(query, params, Integer.class);

				System.out.println("orderId : " + orderId);

			}

		} catch (Exception e) {
			System.out.println("placeOrder : " + e);
		}

		return orderId;
	}

	public int addOrderMoodBoard(int orderId, int moodBoardId, String moodboardPath) {
		try {

			System.out.println("addOrderMoodBoard orderId : " + orderId);
			System.out.println("moodBoardId : " + moodBoardId);
			System.out.println("moodboardPath : " + moodboardPath);

			String sqlQuery = "INSERT INTO order_mood (order_id, mood_board_id, path) values (?, ?, ?)";

			Object[] conditionObject = new Object[] { orderId, moodBoardId, moodboardPath };

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOrderMoodBoard : " + e);
			return -1;
		}
	}

	public int addLiveOrder(Order order, Publication publication) {
		try {
			CalendarUtil calendarUtil = new CalendarUtil();
			
			String sqlQuery = "INSERT INTO live_order (publication_id, order_id, job_no, club_id, order_status_id, question, is_crequest, timestamp) values (?, ?, ?, ?, ?, ?, ?, ?)";

			Object[] conditionObject = new Object[] { publication.getPublicationId(), order.getOrderId(),
					order.getJobNo(), publication.getClubId(), 1, 0, 0, calendarUtil.getESTCurrentDateTime()  };

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOrderMoodBoard : " + e);
			return -1;
		}
	}
	
	
	public int addOnlieOrderSize(int orderId, int sizeId) {
		try {

			String sqlQuery = "INSERT INTO order_multiple_size (order_id, size_id) values (?, ?)";

			Object[] conditionObject = new Object[] {orderId, sizeId};

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOnlieOrderSize : " + e);
			return -1;
		}
	}
	
	
	public int addOnlieCustomOrderSize(int orderId, double customWidth, double customHeight) {
		try {

			String sqlQuery = "INSERT INTO order_multiple_custom_size (order_id, custom_width, custom_height) values (?, ?, ?)";

			Object[] conditionObject = new Object[] {orderId, customWidth, customHeight};

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOnlieCustomOrderSize : " + e);
			return -1;
		}
	}
	
	
	public int updateOrderSize(int orderId, double customWidth, double customHeight) {
		try {

			String sqlQuery = "UPDATE `order` SET width=?, height=? WHERE order_id=?";

			Object[] conditionObject = new Object[] {customWidth, customHeight, orderId};

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOnlieCustomOrderSize : " + e);
			return -1;
		}
	}
	
	

}
