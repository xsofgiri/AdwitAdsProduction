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

import com.production.entity.CatArtInstruction;
import com.production.entity.CatNewAdType;
import com.production.entity.CatResult;
import com.production.entity.CsrToAdrepOptions;
import com.production.entity.Designer;
import com.production.entity.FlexitiveSize;
import com.production.entity.LiveOrder;
import com.production.entity.MoodBoard;
import com.production.entity.NoteSent;
import com.production.entity.NoteTeamLeadDesigner;
import com.production.entity.Orders;
import com.production.entity.OrderCustomSize;
import com.production.entity.OrderMultipleCustomSize;
import com.production.entity.OrderQA;
import com.production.entity.PixelSize;
import com.production.entity.ProductionConversation;
import com.production.entity.PubProject;
import com.production.entity.Publication;
import com.production.entity.QuestionTemplate;
import com.production.mapper.CatArtInstructionMapper;
import com.production.mapper.CatNewAdTypeMapper;
import com.production.mapper.CatResultMapper;
import com.production.mapper.CsrToAdrepOptionsMapper;
import com.production.mapper.FlexitiveSizeMapper;
import com.production.mapper.LiveOrderMapper;
import com.production.mapper.NoteTeamLeadDesignerMapper;
import com.production.mapper.OrderMapper;
import com.production.mapper.OrderMultipleCustomSizeMapper;
import com.production.mapper.OrderQAMapper;
import com.production.mapper.PixelSizeMapper;
import com.production.mapper.QuestionTemplateMapper;
import com.production.util.CalendarUtil;
import com.production.util.Constants;
import com.production.util.FTPUtil;

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

			flexitiveSize = (FlexitiveSize) jdbcTemplate.queryForObject(sqlQuery, conditionObject,
					new RowMapper<FlexitiveSize>() {
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

	public int placeOrder(Orders order) {
		int orderId = -1;
		CalendarUtil calendarUtil = new CalendarUtil();
		try {

			java.util.Date getNextMondayDate = calendarUtil
					.addDaysToJavaUtilDate(calendarUtil.parseDate(calendarUtil.getESTCurrentDate(), "yyyy-MM-dd"));
			System.out.println("getNextMondayDate :" + getNextMondayDate);

			Date dateNeeded = Constants.isStringNotNull(order.getDateNeeded())
					? calendarUtil.convertDateJavaToSql(calendarUtil.parseDate(order.getDateNeeded(), "dd/mm/yyyy"))
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
					"", webAdFormatId, calendarUtil.getESTCurrentDateTime(), order.getMaxFileSize(),
					order.getWebOrderType(), order.getClubId() };

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

	public int addLiveOrder(Orders order, Publication publication) {
		try {
			CalendarUtil calendarUtil = new CalendarUtil();

			String sqlQuery = "INSERT INTO live_order (publication_id, order_id, job_no, club_id, order_status_id, question, is_crequest, timestamp) values (?, ?, ?, ?, ?, ?, ?, ?)";

			Object[] conditionObject = new Object[] { publication.getPublicationId(), order.getOrderId(),
					order.getJobNo(), publication.getClubId(), 1, 0, 0, calendarUtil.getESTCurrentDateTime() };

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOrderMoodBoard : " + e);
			return -1;
		}
	}

	public int addOnlieOrderSize(int orderId, int sizeId) {
		try {

			String sqlQuery = "INSERT INTO order_multiple_size (order_id, size_id) values (?, ?)";

			Object[] conditionObject = new Object[] { orderId, sizeId };

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOnlieOrderSize : " + e);
			return -1;
		}
	}

	public int addOnlieCustomOrderSize(int orderId, double customWidth, double customHeight) {
		try {

			String sqlQuery = "INSERT INTO order_multiple_custom_size (order_id, custom_width, custom_height) values (?, ?, ?)";

			Object[] conditionObject = new Object[] { orderId, customWidth, customHeight };

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOnlieCustomOrderSize : " + e);
			return -1;
		}
	}

	public int updateOrderSize(int orderId, double customWidth, double customHeight) {
		try {

			String sqlQuery = "UPDATE `order` SET width=?, height=? WHERE order_id=?";

			Object[] conditionObject = new Object[] { customWidth, customHeight, orderId };

			return jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("addOnlieCustomOrderSize : " + e);
			return -1;
		}
	}

	public Orders getOrderDetails(int orderId) {
		Orders orders = null;

		String query = "SELECT * FROM orders where order_id =?";

		try {
			System.out.println("query : " + query);
			System.out.println("orderId : " + orderId);

			Object[] conditionObject = new Object[] { orderId };

			orders = (Orders) jdbcTemplate.queryForObject(query, conditionObject, new OrderMapper());

			if (orders != null && orders.getOrderTypeId() == 1) {

				if (orders.getWebAdFormatId() == 5) {

					if (orders.getFlexitiveSizeId() > 0) {
						String multipleSizeQuery = "SELECT FS.flexitive_size_id, FS.ratio, FS.min, FS.max, FS.text FROM "
								+ " flexitive_size FS  where FS.flexitive_size_id =?";

						FlexitiveSize flexitiveSize = (FlexitiveSize) jdbcTemplate.queryForObject(multipleSizeQuery,
								conditionObject, new FlexitiveSizeMapper());
						if (flexitiveSize != null) {
							orders.setFlexitiveSize(flexitiveSize);
						}
					}

					String multipleSizeQuery = "SELECT FS.flexitive_size_id, FS.ratio, FS.min, FS.max, FS.text FROM "
							+ "order_multiple_size OMZ left join flexitive_size FS on OMZ.size_id=FS.flexitive_size_id"
							+ " where OMZ.order_id =?";

					ArrayList<FlexitiveSize> flexitiveSizeList = (ArrayList<FlexitiveSize>) jdbcTemplate
							.query(multipleSizeQuery, conditionObject, new FlexitiveSizeMapper());
					if (flexitiveSizeList != null && flexitiveSizeList.size() > 0) {
						orders.setFlexitiveSizeList(flexitiveSizeList);
					}

				} else {

					if (orders.getPixelSizeId() > 0) {
						String multipleSizeQuery = "SELECT PS.pixel_size_id, PS.name, PS.width, PS.height, PS.is_active, PS.is_deleted FROM "
								+ " pixel_size PS  where PS.pixel_size_id =?";

						PixelSize pixelSize = (PixelSize) jdbcTemplate.queryForObject(multipleSizeQuery,
								conditionObject, new PixelSizeMapper());
						if (pixelSize != null) {
							orders.setPixelSize(pixelSize);
						}
					}

					String multipleSizeQuery = "SELECT PS.pixel_size_id, PS.name, PS.width, PS.height, PS.is_active, PS.is_deleted FROM "
							+ "order_multiple_size OMZ left join pixel_size PS on OMZ.size_id=PS.pixel_size_id"
							+ " where OMZ.order_id =?";

					ArrayList<PixelSize> pixelSizeList = (ArrayList<PixelSize>) jdbcTemplate.query(multipleSizeQuery,
							conditionObject, new PixelSizeMapper());
					if (pixelSizeList != null && pixelSizeList.size() > 0) {
						orders.setPixelSizeList(pixelSizeList);
					}

				}

				String customSizeQuery = "SELECT order_multiple_custom_size_id, order_id, custom_width, custom_height FROM "
						+ "order_multiple_custom_size where order_id =?";

				ArrayList<OrderMultipleCustomSize> customSizeList = (ArrayList<OrderMultipleCustomSize>) jdbcTemplate
						.query(customSizeQuery, conditionObject, new OrderMultipleCustomSizeMapper());
				if (customSizeList != null && customSizeList.size() > 0) {
					orders.setMultipleCustomSizes(customSizeList);
				}

			}

			if (orders != null && orders.getQuestion() > 0) {

				String qaQuery = "SELECT * FROM " + "order_q_a where order_id =?";

				OrderQA orderQA = (OrderQA) jdbcTemplate.queryForObject(qaQuery, conditionObject, new OrderQAMapper());
				if (orderQA != null) {
					orders.setOrderQA(orderQA);
				}

			}

			String orderStatusQuery = "SELECT name from order_status where order_status_id =?";
			Object[] statusConditionObject = new Object[] { orders.getOrderStatusId() };

			String orderStatus = (String) jdbcTemplate.queryForObject(orderStatusQuery, statusConditionObject,
					String.class);

			orders.setOrderStatus(orderStatus);

			//orders.setFileList(FTPUtil.getOrderFileList(orders.getFilePath()));

		} catch (Exception e) {
			System.out.println("getOrderDetails : " + e);
		}

		return orders;
	}

	public ArrayList<QuestionTemplate> getListOfQuestionTemplate() {
		ArrayList<QuestionTemplate> questionTemplateList = new ArrayList<QuestionTemplate>();
		try {
			String sqlQuery = "SELECT question_template_id, name, message FROM question_template";

			questionTemplateList = (ArrayList<QuestionTemplate>) jdbcTemplate.query(sqlQuery,
					new QuestionTemplateMapper());

		} catch (Exception e) {
			System.out.println("getListOfQuestionTemplate : " + e);
		}
		return questionTemplateList;
	}

	public ArrayList<CatNewAdType> getAdTypeList() {
		ArrayList<CatNewAdType> adTypeList = new ArrayList<CatNewAdType>();
		try {
			String sqlQuery = "SELECT cat_new_adtype_id, name, category FROM cat_new_adtype where cat_new_adtype_id>0";

			adTypeList = (ArrayList<CatNewAdType>) jdbcTemplate.query(sqlQuery, new CatNewAdTypeMapper());

		} catch (Exception e) {
			System.out.println("getAdTypeList : " + e);
		}
		return adTypeList;
	}

	public ArrayList<CatArtInstruction> getArtInstructionList() {
		ArrayList<CatArtInstruction> artInstructionList = new ArrayList<CatArtInstruction>();
		try {
			String sqlQuery = "SELECT cat_artinstruction_id, name FROM cat_artinstruction where cat_artinstruction_id>0";

			artInstructionList = (ArrayList<CatArtInstruction>) jdbcTemplate.query(sqlQuery,
					new CatArtInstructionMapper());

		} catch (Exception e) {
			System.out.println("getArtInstructionList : " + e);
		}
		return artInstructionList;
	}

	public int updateSendQuestionStatus(OrderQA orderQA) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			String sqlQuery = "UPDATE orders set question=1, activity_time=? where order_id=?";
			Object[] conditionObject = new Object[] { calendarUtil.getESTCurrentDateTime(), orderQA.getOrderId() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE live_order set question=1 where order_id=?";
			conditionObject = new Object[] { orderQA.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "INSERT INTO order_q_a (order_id, rev_sold_job_id, csr_id,"
					+ " question, Qtimestamp) values (?, ?, ?, ?, ?)";
			conditionObject = new Object[] { orderQA.getOrderId(), orderQA.getRevSoldJobId(), orderQA.getCsrId(),
					orderQA.getQuestion(), calendarUtil.getESTCurrentDateTime() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("updateSendQuestionStatus : " + e);
		}
		return result;
	}

	public int acceptOrder(Orders order, CatResult catResult) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		int orderStatus = 2, productionStatus = 1;

		try {

			String sqlQuery = "UPDATE orders set is_rush=?, order_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { order.isRush() ? 1 : 0, orderStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE live_order set category=?, csr_id=?, order_status_id=?, production_status_id=? where order_id=?";
			conditionObject = new Object[] { catResult.getCategory(), catResult.getCsrId(), orderStatus,
					productionStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "SELECT cat_result_id FROM cat_result WHERE order_id=?";
			conditionObject = new Object[] { order.getOrderId() };
			result = dbUtil.getJDBCIntResult(sqlQuery, conditionObject);

			if (result == 0) {
				sqlQuery = "INSERT INTO cat_result (order_id, cat_new_adtype_id, cat_artinstruction_id, production_status_id, "
						+ "category, csr_id, category_date, time, version) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				conditionObject = new Object[] { order.getOrderId(), catResult.getCatNewAdtypeId(),
						catResult.getCatArtInstructionId(), catResult.getProductionStatusId(), catResult.getCategory(),
						catResult.getCsrId(), calendarUtil.getESTCurrentDateTime(), calendarUtil.getESTCurrentTime(),
						catResult.getVersion() };

				result = jdbcTemplate.update(sqlQuery, conditionObject);
			}

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public int startDesign(Orders order, CatResult catResult) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			String sqlQuery = "UPDATE orders set order_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { 3, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE live_order set order_status_id=?, production_status_id=?, designer_id=? where order_id=?";
			conditionObject = new Object[] { 3, 1, catResult.getDesignerId(), order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set designer_id=?, slug=?, designer_production_date=?, start_time=?,"
					+ " production_status_id=?, source_path=? where order_id=?";
			conditionObject = new Object[] { catResult.getDesignerId(), catResult.getSlug(),
					calendarUtil.getESTCurrentDateTime(), calendarUtil.getESTCurrentTime(), 1,
					catResult.getSourcePath(), order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public int endDesign(Orders order, CatResult catResult) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			int orderStatus = 0, liveOrderStatus = 0, productionStatus = 0;

			if ("P".equals(catResult.getCategory()) || "T".equals(catResult.getCategory())) {
				orderStatus = 4;
				liveOrderStatus = 3;
				productionStatus = 3;
			} else {
				orderStatus = 3;
				liveOrderStatus = 2;
				productionStatus = 2;
			}

			System.out.println("catResult.getCategory() : " + catResult.getCategory());
			System.out.println("orderStatus : " + orderStatus);
			System.out.println("liveOrderStatus : " + liveOrderStatus);
			System.out.println("productionStatus : " + productionStatus);

			String sqlQuery = "UPDATE orders set order_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { orderStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE live_order set order_status_id=?, production_status_id=?, designer_id=? where order_id=?";
			conditionObject = new Object[] { orderStatus, productionStatus, catResult.getDesignerId(),
					order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set production_status_id=? where order_id=?";
			conditionObject = new Object[] { productionStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			System.out.println("catResult.getStartTime() : " + catResult.getStartTime());
			System.out.println("calendarUtil.getESTCurrentDateTime() : " + calendarUtil.getESTCurrentDateTime());

			java.util.Date startDate = calendarUtil.parseDate(catResult.getDesignerProductionDate(),
					"yyyy-mm-dd hh:mm:ss");
			java.util.Date endDate = calendarUtil.parseDate(calendarUtil.getESTCurrentDateTime(),
					"yyyy-mm-dd hh:mm:ss");

			System.out.println("startDate : " + startDate);
			System.out.println("endDate : " + endDate);

			long timeTaken = calendarUtil.getDateDiffInMinutes(startDate, endDate);
			System.out.println(timeTaken);

			sqlQuery = "INSERT INTO designer_ads_time (order_id, start_time, end_date, end_time, time_taken, designer_id)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			conditionObject = new Object[] { order.getOrderId(), catResult.getDesignerProductionDate(),
					calendarUtil.getESTCurrentDate(), calendarUtil.getESTCurrentTime(), timeTaken,
					catResult.getDesignerId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public int sendOrderToQA(Orders order, CatResult catResult, Designer designer) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			int orderStatus = 4, productionStatus = 3;

			String sqlQuery = "UPDATE orders set order_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { orderStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE live_order set order_status_id=?, production_status_id=? where order_id=?";
			conditionObject = new Object[] { orderStatus, productionStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set production_status_id=?, teamlead_designer_id=?, teamlead_designer_time=?,"
					+ " teamlead_designer_date=? where order_id=?";
			conditionObject = new Object[] { productionStatus, designer.getDesignerId(),
					calendarUtil.getESTCurrentTime(), calendarUtil.getESTCurrentDate(), order.getOrderId() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public int sendOrderBackToDesigner(Orders order, CatResult catResult, Designer designer) {
		int result = 0;

		try {

			int productionStatus = 6;

			String sqlQuery = "UPDATE live_order set production_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { productionStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set production_status_id=?  where order_id=?";
			conditionObject = new Object[] { productionStatus, order.getOrderId() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public int orderMakeChangesByTL(Orders order, CatResult catResult, Designer designer) {
		int result = 0;

		try {

			int productionStatus = 8;

			String sqlQuery = "UPDATE live_order set production_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { productionStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set production_status_id=?  where order_id=?";
			conditionObject = new Object[] { productionStatus, order.getOrderId() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public int sendOrderBackToDesignerFromCSR(Orders order, CatResult catResult, Designer designer) {
		int result = 0;

		try {

			int orderStatus = 3, productionStatus = 7;

			String sqlQuery = "UPDATE orders set order_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { orderStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE live_order set order_status_id=?, production_status_id=?, csr_id_QA=? where order_id=?";
			conditionObject = new Object[] { orderStatus, productionStatus, designer.getDesignerId(),
					order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set production_status_id=?  where order_id=?";
			conditionObject = new Object[] { productionStatus, order.getOrderId() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("sendOrderBackToDesignerFromCSR : " + e);
		}
		return result;
	}

	public int addProductionConversation(ProductionConversation pc) {

		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			String sqlQuery = "INSERT INTO production_conversation (order_id, rev_sold_job_id, designer_id, tl_designer_id,"
					+ " csr_id, time, message, operation, file_path)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] conditionObject = new Object[] { pc.getOrderId(), pc.getRevSoldJobId(), pc.getDesignerId(),
					pc.getTlDesignerId(), pc.getCsrId(), calendarUtil.getESTCurrentDateTime(), pc.getMessage(),
					pc.getOperation(), pc.getFilePath() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

	public CatResult getCatResultDetails(int orderId) {
		CatResult catResult = null;
		try {
			String sqlQuery = "SELECT * FROM cat_result WHERE order_id=?";
			Object[] conditionObject = new Object[] { orderId };
			catResult = jdbcTemplate.queryForObject(sqlQuery, conditionObject, new CatResultMapper());

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return catResult;
	}

	public ArrayList<NoteTeamLeadDesigner> getDesignNotes(String displayType) {
		ArrayList<NoteTeamLeadDesigner> notesList = new ArrayList<NoteTeamLeadDesigner>();
		try {

			String sqlQuery = "SELECT note_teamlead_designer_id, name, display FROM note_teamlead_designer WHERE display=?";
			Object[] conditionObject = new Object[] { displayType };
			notesList = (ArrayList<NoteTeamLeadDesigner>) jdbcTemplate.query(sqlQuery, conditionObject,
					new NoteTeamLeadDesignerMapper());

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return notesList;
	}

	public ArrayList<CsrToAdrepOptions> getCSRToAdRepNotes() {
		ArrayList<CsrToAdrepOptions> notesList = new ArrayList<CsrToAdrepOptions>();
		try {

			String sqlQuery = "SELECT id, name, is_active FROM csr_to_adrep_options WHERE is_active=?";
			Object[] conditionObject = new Object[] { "1" };
			notesList = (ArrayList<CsrToAdrepOptions>) jdbcTemplate.query(sqlQuery, conditionObject, new CsrToAdrepOptionsMapper());

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return notesList;
	}
	
	
	public int sendOrderToAdRep(Orders order, CatResult catResult, Designer designer) {
		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			int orderStatus = 5, productionStatus = 5;

			String sqlQuery = "UPDATE orders set order_status_id=? where order_id=?";
			Object[] conditionObject = new Object[] { orderStatus, order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "UPDATE cat_result set production_status_id=?, QA_csr_id=?, csr_QA_timestamp=?,"
					+ " source_file=?, pdf_file=?, sold_pdf=? where order_id=?";
			conditionObject = new Object[] { productionStatus, designer.getDesignerId(),
					calendarUtil.getESTCurrentDateTime(), catResult.getSourceFile(), catResult.getPdfFile(),
					catResult.getSoldPdf(), order.getOrderId() };

			result = jdbcTemplate.update(sqlQuery, conditionObject);

			sqlQuery = "delete from live_order where order_id=?";
			conditionObject = new Object[] { order.getOrderId() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

			
			
		} catch (Exception e) {
			System.out.println("sendOrderToAdRep : " + e);
		}
		return result;
	}
	
	
	public int addNoteSent(NoteSent noteSent) {

		int result = 0;
		CalendarUtil calendarUtil = new CalendarUtil();

		try {

			String sqlQuery = "INSERT INTO note_sent (order_id, rev_sold_job_id, note, timestamp)  VALUES (?, ?, ?, ?)";
			Object[] conditionObject = new Object[] { noteSent.getOrderId(), noteSent.getRevSoldJobId(), noteSent.getNote(),
					calendarUtil.getESTCurrentDateTime() };
			result = jdbcTemplate.update(sqlQuery, conditionObject);

		} catch (Exception e) {
			System.out.println("acceptOrder : " + e);
		}
		return result;
	}

}
