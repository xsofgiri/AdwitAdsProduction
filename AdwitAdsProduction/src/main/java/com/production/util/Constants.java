package com.production.util;

import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.google.common.net.InternetDomainName;


public class Constants {

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");

	public static final float COMPRESSION_QUALITY = 0.2f;

	public static final String USER_DTO = "user_dto";
	public static final String ADMIN_DTO = "admin_dto";
	
	public static final String USER_AJAX_RESPONSE_INACTIVE = "INACTIVE";
	public static final String USER_AJAX_RESPONSE_INVALID = "INVALID";
	public static final String USER_AJAX_RESPONSE_SUCCESS = "SUCCESS";
	public static final String USER_AJAX_RESPONSE_ERROR = "ERROR";
	public static final String USER_AJAX_RESPONSE_WARNING = "WARNING";
	
	public static final String USER_AJAX_RESPONSE_LOGIN_OTP = "LOGIN_OTP";
	public static final String USER_AJAX_RESPONSE_REGISTRATION_OTP = "REGISTRATION_OTP";
	
	public static final String USER_RESET_PASS_EMAIL = "user_reset_pass_email";
	public static final String USER_RESET_PASS_HASH = "user_reset_pass_hash";
	public static final String USER_RESET_PASS_PHONE = "user_reset_pass_phone";

	public static final String USER_LOGIN_COOKIE_SAVE_UNAME = "user_login_cookie_save_uname";
	public static final String USER_LOGIN_COOKIE_SAVE_PSEC = "user_login_cookie_save_psec";

	public static final String USER_ERROR_MESSAGE = "user_error_message";
	public static final String USER_SUCCESS_MESSAGE = "user_success_message";

	public static final String USER_SESSION_ERROR_MESSAGE = "user_session_error_message";
	public static final String USER_SESSION_SUCCESS_MESSAGE = "user_session_success_message";

	public static final String USER_REDIRECT_TO = "user_redirect_to";
	public static final String USER_SHOW_ACTIVATION = "user_show_activation";
	
	public static final String USER_LOGIN_INVALID_EMAIL = "user_login_invalid_email";
	public static final String USER_BILLING_DETAILS = "USER_BILLING_DETAILS";
	
	public static final String CITY_LIST = "city_list";
	public static final String CITY_DETAIL = "city_detail";
	
	
	public static boolean isCrossScriptDetected(String val) {
		boolean isDetected = false;

		try {

			if (val != null && val.length() > 0) {
				if (val.toLowerCase().contains("<form"))
					isDetected = true;
				else if (val.toLowerCase().contains("%3cform"))
					isDetected = true;
				else if (val.toLowerCase().contains("<input type"))
					isDetected = true;
				else if (val.toLowerCase().contains("%3cinput type"))
					isDetected = true;
				else if (val.toLowerCase().contains("<form action"))
					isDetected = true;
				else if (val.toLowerCase().contains("%3cform action"))
					isDetected = true;
				else if (val.toLowerCase().contains("type=submit"))
					isDetected = true;
				else if (val.toLowerCase().contains("<script"))
					isDetected = true;
				else if (val.toLowerCase().contains("%3cscript"))
					isDetected = true;
				else if (val.toLowerCase().contains("document.location"))
					isDetected = true;
				else if (val.toLowerCase().contains("document.cookie"))
					isDetected = true;
				else if (val.toLowerCase().contains("<img src"))
					isDetected = true;
				else if (val.toLowerCase().contains("%3cimg src"))
					isDetected = true;
				else if (val.toLowerCase().contains("javascript"))
					isDetected = true;
			}

		} catch (Exception e) {
			isDetected = true;
		}

		return isDetected;
	}

	public static String getCrossScriptString(String val) {
		try {
			if (val != null && val.length() > 0) {
				if (isCrossScriptDetected(val)) {
					val = null;
				} else {

					val = val.replaceAll("%3c", "");
					val = val.replaceAll("%3C", "");

					val = val.replaceAll("%3e", "");
					val = val.replaceAll("%3E", "");

					val = val.replaceAll("&lt;", "");
					val = val.replaceAll("&gt;", "");

					val = val.replaceAll("x3c", "");
					val = val.replaceAll("x3C", "");

					val = val.replaceAll("x3e", "");
					val = val.replaceAll("x3E", "");

					val = val.replaceAll("getURL", "");
					// val = val.replaceAll("x3E", "");

					val = val.replaceAll("<iframe", "");
					val = val.replaceAll("<IFRAME", "");

					val = val.replaceAll("iframe", "");
					val = val.replaceAll("IFRAME", "");

					val = val.replaceAll("<img", "");
					val = val.replaceAll("<IMG", "");

					val = val.replaceAll("<script>", "");
					val = val.replaceAll("<SCRIPT>", "");

					val = val.replaceAll("<script", "");
					val = val.replaceAll("<SCRIPT", "");

					val = val.replaceAll("script", "");
					val = val.replaceAll("SCRIPT", "");

					val = val.replaceAll("<meta", "");
					val = val.replaceAll("<META", "");

					val = val.replaceAll("<body", "");
					val = val.replaceAll("<BODY", "");

					val = val.replaceAll("&lt;body", "");
					val = val.replaceAll("&lt;BODY", "");

					val = val.replaceAll("onload", "");
					val = val.replaceAll("ONLOAD", "");

					val = val.replaceAll("ALERT", "");
					val = val.replaceAll("alert", "");

					val = val.replaceAll("<embed", "");
					val = val.replaceAll("<EMBED", "");

					val = val.replaceAll("<object", "");
					val = val.replaceAll("<OBJECT", "");

					val = val.replaceAll("<applet", "");
					val = val.replaceAll("<APPLET", "");

					val = val.replaceAll("<form", "");
					val = val.replaceAll("<FORM", "");

					val = val.replaceAll("<head", "");
					val = val.replaceAll("<HEAD", "");

					// val = val.replaceAll("<", "").replaceAll(">", "");
					val = val.replaceAll("eval\\((.*)\\)", "");
					val = val.replaceAll(
							"[\\\"\\\'][\\s]*((?i)javascript):(.*)[\\\"\\\']",
							"\"\"");
					val = val.replaceAll("((?i)script)", "");

					val = val.replaceAll("iframe", "");
					val = val.replaceAll("IFRAME", "");

					val = val.replaceAll("img ", "");
					val = val.replaceAll("IMG ", "");

					val = val.replaceAll("'", "\'");
					val = val.replaceAll("\n", "<br />");
					// val = val.replaceAll(">", "");

					val = val.replaceAll("document.cookie", "");

				}

				// val = val.replaceAll(">", "");

			}
		} catch (Exception e) {
			val = null;
		}

		return val;
	}

	public static int returnInt(String val) {
		try {
			if (val != null && !"".equals(val) && !"null".equals(val)) {
				int returnVal = Integer.parseInt(val);
				return returnVal;
			} else {
				return 0;
			}

		} catch (Exception e) {
			return 0;
		}
	}

	public static String checkNull(String val) {
		try {
			if (val != null && !"".equals(val) && !"null".equals(val)) {
				return val;
			} else {
				return "";
			}

		} catch (Exception e) {
			return "";
		}
	}

	public static boolean isStringNotNull(String val) {
		try {
			if (val != null && !"".equals(val.trim()) && !"null".equals(val) && !"undefined".equals(val)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return true;
		}
	}
	
	
	

	public static String toSlug(String input) {
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace,
				Normalizer.Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		slug = EDGESDHASHES.matcher(slug).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

	public static String generateUniqueUrlId() {
		String uniqueid = null;
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));

		uniqueid = sb.toString();

		return uniqueid.toLowerCase();

	}

	public static String shortResponse(String inputStr, int length) {
		try {
			if (inputStr.length() > length) {
				int shortIndex = inputStr.indexOf(" ", length > 0 ? length
						: 100);
				String shortResponse = inputStr.substring(0, shortIndex);
				return shortResponse + "...";
			} else {
				return inputStr;
			}
		} catch (Exception e) {
			return inputStr;
		}

	}

	public static String longResponse(String inputStr) {
		try {
			if (inputStr.length() > 101) {
				String shortResponse = inputStr.substring(
						inputStr.indexOf(" ", 101), inputStr.length());
				return shortResponse;
			} else {
				return null;
			}
		} catch (Exception e) {
			return inputStr;
		}

	}
	
	
	public static String getPublishDates(ArrayList<String> publishDates){
		String inputStr = "";
		
		try {
			
			for(String inputDate : publishDates){
				inputStr+=inputDate+", ";
			}
			
			if(inputStr.lastIndexOf(", ")>0){
				inputStr = inputStr.substring(0,  inputStr.length()-2);
			}
			
			return inputStr;
			
		}catch (Exception e) {
			return inputStr;
		}
		
		
	}
	
	
	public static int randInt(int minimum, int maximum) {

		Random rn = new Random();
		int range = maximum - minimum + 1;
		int randomNum =  rn.nextInt(range) + minimum;
		return randomNum;
	}
	
	
	public static String getSubdomain(HttpServletRequest req) {
		String subDomain = null;
		try {
			String site = req.getServerName();

			String domain = InternetDomainName.from(site).topPrivateDomain().toString();
			subDomain = site.replaceAll(domain, "");

			if (Constants.isStringNotNull(subDomain) && subDomain.length() > 0) {
				subDomain = subDomain.substring(0, subDomain.length() - 1);
			}
		} catch (Exception e) {
			System.out.println("getSubdomain e :" + e);
		}

		return subDomain;
	}

}
