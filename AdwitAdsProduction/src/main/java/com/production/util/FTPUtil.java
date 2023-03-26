package com.production.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import com.production.entity.CatResult;
import com.production.entity.OrderFile;
import com.production.entity.Orders;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FTPUtil {

	private static String SERVER = "13.126.162.172";
	private static int PORT = 21;
	private static String USER = "adwitac";
	private static String PASS = "adwit@123";

	private static String SOURCEFILE_PATH = "/adwitdata/mnt_point_sourcefiles/sourcefile";
	private static String MOUNT_PATH = "/adwitdata/mnt_point_sourcefiles/";

	private static String MOUNT_SOURCEFILE_PATH = "/adwitdata/mnt_point_sourcefiles/sourcefile";

	/*
	 * public static void main(String[] args) {
	 * 
	 * FTPClient ftpClient = new FTPClient();
	 * 
	 * try {
	 * 
	 * ftpClient.connect(SERVER, PORT); // showServerReply(ftpClient);
	 * 
	 * int replyCode = ftpClient.getReplyCode(); if
	 * (!FTPReply.isPositiveCompletion(replyCode)) {
	 * System.out.println("Connect failed"); return; }
	 * 
	 * boolean success = ftpClient.login(USER, PASS); // showServerReply(ftpClient);
	 * 
	 * if (!success) { System.out.println("Could not login to the server"); return;
	 * }
	 * 
	 * // Lists files and directories FTPFile[] files = ftpClient .listFiles(
	 * "/adwitdata/mnt_point_pdfuploads_downloads/downloads/1128210-print1100011/");
	 * for (FTPFile file : files) {
	 * 
	 * if (file != null && file.getSize() > 0) { String details = file.getName(); if
	 * (!details.equals(".") && !details.equals("..")) { // details += "\t\t" +
	 * dateFormater.format(file.getTimestamp().getTime());
	 * System.out.println(details); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // uses simpler methods // String[] files2 = ftpClient.listNames(); //
	 * printNames(files2);
	 * 
	 * } catch (IOException ex) {
	 * System.out.println("Oops! Something wrong happened"); ex.printStackTrace(); }
	 * finally { // logs out and disconnects from server try { if
	 * (ftpClient.isConnected()) { ftpClient.logout(); ftpClient.disconnect(); } }
	 * catch (IOException ex) { ex.printStackTrace(); } } }
	 */
	private static void printFileDetails(FTPFile[] files) {
		DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (FTPFile file : files) {

			if (file != null && file.getSize() > 0) {
				String details = file.getName();
				if (!details.equals(".") && !details.equals("..")) {
//					details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
					System.out.println(details);
				}

			}

		}
	}

	private static void printNames(String files[]) {
		if (files != null && files.length > 0) {
			for (String aFile : files) {
				System.out.println(aFile);
			}
		}
	}

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

	public static ArrayList<String> getFTPOrderFileList(String directory) {

		FTPClient ftpClient = new FTPClient();
		ArrayList<String> fileList = new ArrayList<String>();
		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return null;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return null;
			}

			// Lists files and directories
			// FTPFile[] files =
			// ftpClient.listFiles("/adwitdata/mnt_point_pdfuploads_downloads/" + directory
			// + "/");
			FTPFile[] files = ftpClient.listFiles(MOUNT_PATH + directory + "/");

			for (FTPFile file : files) {

				if (file != null && file.getSize() > 0) {
					String details = file.getName();
					if (!details.equals(".") && !details.equals("..")) {
						System.out.println(details);
						fileList.add(details);
					}

				}

			}

		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return fileList;
	}

	public static ArrayList<String> getOrderFileList(String directory) {

		ArrayList<String> fileList = new ArrayList<String>();
		try {

			SpringProperty sProperty = new SpringProperty();
			String mountParentFolder = sProperty.getPropertyValue("mountParentFolder");

			System.out.println("mountParentFolder : " + mountParentFolder + directory + "/");

			File directoryPath = new File(mountParentFolder + directory + "/");
			File filesList[] = directoryPath.listFiles();

			for (File file : filesList) {

				if (file != null && file.length() > 0) {
					String details = file.getName();
					if (!details.equals(".") && !details.equals("..")) {
						System.out.println(details);
						fileList.add(details);
					}

				}

			}

		} catch (Exception ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		}
		return fileList;
	}

	public static ArrayList<OrderFile> getOrderFile(String directory, String fileExtension) {

		ArrayList<OrderFile> fileList = new ArrayList<OrderFile>();
		try {
			SpringProperty sProperty = new SpringProperty();
			String mountParentFolder = sProperty.getPropertyValue("mountParentFolder");

			System.out.println("mountParentFolder : " + mountParentFolder + directory + "/");

			// directory = directory.replace(" ", "\\ ");

			File directoryPath = new File(mountParentFolder + directory + "/");
			File filesList[] = directoryPath.listFiles();

			if (filesList != null && filesList.length > 0) {
				for (File file : filesList) {

					if (file != null && file.getTotalSpace() > 0) {
						String details = file.getName().toLowerCase();

						if (!details.equals(".") && !details.equals("..")) {
							System.out.println(details);
							OrderFile orderFile = new OrderFile();
							orderFile.setFileName(file.getName());
							long bytes = file.length();
							long kilobytes = (bytes / 1024);
							// long megabytes = (kilobytes / 1024);

							orderFile.setFileSize(kilobytes);
//							orderFile.setFileFormat(file.getType());

							if (fileExtension != null && details.lastIndexOf(fileExtension) > 0)
								fileList.add(orderFile);
							else if (fileExtension == null)
								fileList.add(orderFile);
						}

					}

				}
			}

		} catch (Exception ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		}

		return fileList;
	}

	public static ArrayList<OrderFile> getFTPOrderFile(String directory, String fileExtension) {

		FTPClient ftpClient = new FTPClient();
		ArrayList<OrderFile> fileList = new ArrayList<OrderFile>();
		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return null;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return null;
			}

			// Lists files and directories
			// FTPFile[] files =
			// ftpClient.listFiles("/adwitdata/mnt_point_pdfuploads_downloads/" + directory
			// + "/");
			directory = directory.replace(" ", "\\ ");

			FTPFile[] files = ftpClient.listFiles(MOUNT_PATH + directory + "/");
			System.out.println(directory + " | files : " + files.length);

			for (FTPFile file : files) {

				if (file != null && file.getSize() > 0) {
					String details = file.getName().toLowerCase();
					file.getSize();

					if (!details.equals(".") && !details.equals("..")) {
						System.out.println(details);
						OrderFile orderFile = new OrderFile();
						orderFile.setFileName(file.getName());
						orderFile.setFileSize(file.getSize());
//						orderFile.setFileFormat(file.getType());

						if (fileExtension != null && details.lastIndexOf(fileExtension) > 0)
							fileList.add(orderFile);
						else if (fileExtension == null)
							fileList.add(orderFile);
					}

				}

			}

		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return fileList;
	}

	public static boolean createSlugFolder(String dirPath) {
		boolean slugCreated = false;

		try {
			SpringProperty sProperty = new SpringProperty();
			String mountFolder = sProperty.getPropertyValue("mountFolder");

			System.out.println("mountFolder : " + mountFolder);

			Files.createDirectories(Paths.get(mountFolder + dirPath));

		} catch (Exception e) {

		}

		return slugCreated;
	}

	public static boolean createSlugFolderInFTP(String dirPath) {
		boolean slugCreated = false;
		FTPClient ftpClient = new FTPClient();

		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return false;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return false;
			}

			boolean sourceFileDirectory = ftpClient.changeWorkingDirectory(SOURCEFILE_PATH);
			System.out.println("printWorkingDirectory : " + ftpClient.printWorkingDirectory()
					+ " | sourceFileDirectory :" + sourceFileDirectory);

			if (sourceFileDirectory) {
				System.out.println("printWorkingDirectory : " + ftpClient.printWorkingDirectory());
				String[] pathElements = dirPath.split("/");
				if (pathElements != null && pathElements.length > 0) {
					for (String singleDir : pathElements) {
						if (Constants.isStringNotNull(singleDir)) {
							boolean existed = ftpClient.changeWorkingDirectory(singleDir);
							System.out.println("singleDir : " + singleDir + " | existed : " + existed + " | "
									+ ftpClient.printWorkingDirectory());
							if (!existed) {
								boolean created = ftpClient.makeDirectory(singleDir);
								if (created) {
									System.out.println("CREATED directory: " + singleDir);
									ftpClient.changeWorkingDirectory(singleDir);
								} else {
									System.out.println("COULD NOT create directory: " + singleDir);
									return false;
								}
							}
						}

					}
				}
			}

			return true;

		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return slugCreated;
	}

	public static boolean createFolder(String slugPath, String singleDir) {
		boolean slugCreated = false;

		try {
			SpringProperty sProperty = new SpringProperty();
			String mountFolder = sProperty.getPropertyValue("mountFolder");

			System.out.println("mountFolder : " + mountFolder);
			File file = new File(mountFolder + slugPath);
			System.out.println(mountFolder + slugPath + "/" + singleDir);
			if (file.exists()) {
				Files.createDirectories(Paths.get(mountFolder + slugPath + "/" + singleDir));
			}

		} catch (Exception e) {

		}

		return slugCreated;
	}

	public static boolean createFTPFolder(String slugPath, String singleDir) {

		boolean folderCreated = false;
		FTPClient ftpClient = new FTPClient();

		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return false;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return false;
			}
			boolean isPathExist = ftpClient.changeWorkingDirectory(SOURCEFILE_PATH + slugPath);
			if (isPathExist) {
				folderCreated = ftpClient.makeDirectory(singleDir);
				System.out.println("CREATED directory: " + singleDir);
			}

		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return folderCreated;

	}

	public static boolean addLinks(String dirPath) {

		boolean slugCreated = false;
		FTPClient ftpClient = new FTPClient();

		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return false;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return false;
			}

//			ftpClient.changeWorkingDirectory("sourcefile/" + dirPath);
			ftpClient.changeWorkingDirectory(SOURCEFILE_PATH + dirPath);

			String[] pathElements = dirPath.split("/");
			if (pathElements != null && pathElements.length > 0) {
				for (String singleDir : pathElements) {
					boolean existed = ftpClient.changeWorkingDirectory(singleDir);
					if (!existed) {
						boolean created = ftpClient.makeDirectory(singleDir);
						if (created) {
							System.out.println("CREATED directory: " + singleDir);
							ftpClient.changeWorkingDirectory(singleDir);
						} else {
							System.out.println("COULD NOT create directory: " + singleDir);
							return false;
						}
					}
				}
			}
			return true;

		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return slugCreated;

	}

	public static boolean uploadFile(String dirPath, MultipartFile file) {
		boolean isFileUploaded = false;
		try {

			SpringProperty sProperty = new SpringProperty();
			String mountFolder = sProperty.getPropertyValue("mountFolder");

			System.out.println("mountFolder : " + mountFolder);

			File convFile = new File(mountFolder + dirPath, file.getOriginalFilename());
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();

		} catch (Exception e) {
			System.out.println("uploadFile : " + e);
		}

		return isFileUploaded;
	}

	public static boolean uploadFileToFTP(String dirPath, MultipartFile file) {

		boolean isFileUploaded = false;
		FTPClient ftpClient = new FTPClient();

		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return false;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return false;
			}

			boolean existed = ftpClient.changeWorkingDirectory(SOURCEFILE_PATH + dirPath);
			if (existed) {
				// upload file
				SpringProperty sProperty = new SpringProperty();
				String tmpLocation = sProperty.getPropertyValue("uploadTempFolder");

				File convFile = new File(tmpLocation, file.getOriginalFilename());
				convFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(convFile);
				fos.write(file.getBytes());
				fos.close();

				InputStream inputStream = new FileInputStream(convFile);
				isFileUploaded = ftpClient.storeFile(convFile.getName(), inputStream);
				inputStream.close();
				if (isFileUploaded) {
					System.out.println("The file is uploaded successfully." + file.getOriginalFilename());
				}

			}
			return true;

		} catch (

		IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return isFileUploaded;

	}

	public static boolean deleteFile(String dirPath, String fileName) {

		boolean isFileDeleted = false;
		try {

			SpringProperty sProperty = new SpringProperty();
			String mountParentFolder = sProperty.getPropertyValue("mountParentFolder");

			System.out.println("deleteFile path :" + mountParentFolder + dirPath + "/" + fileName);

			Files.deleteIfExists(Paths.get(mountParentFolder + dirPath + "/" + fileName));

		} catch (Exception e) {
			System.out.println(e);
		}

		return isFileDeleted;

	}

	public static boolean deleteFTPFile(String dirPath, String fileName) {

		boolean isFileDeleted = false;
		FTPClient ftpClient = new FTPClient();

		try {

			ftpClient.connect(SERVER, PORT);
			// showServerReply(ftpClient);

			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Connect failed");
				return false;
			}

			boolean success = ftpClient.login(USER, PASS);
			// showServerReply(ftpClient);

			if (!success) {
				System.out.println("Could not login to the server");
				return false;
			}

			System.out.println(dirPath);
			boolean existed = ftpClient.changeWorkingDirectory(MOUNT_PATH + dirPath);
			if (existed) {
				// upload file
				System.out.println("Path exist : " + dirPath + " | fileName : " + fileName);
				isFileDeleted = ftpClient.deleteFile(fileName);

				if (isFileDeleted) {
					System.out.println("The file is deleted successfully." + fileName);
				}

			} else {
				System.out.println("Path does not exist : " + dirPath);
			}
			return true;

		} catch (

		IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		} finally {
			// logs out and disconnects from server
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return isFileDeleted;

	}

	public static HashMap<String, ArrayList<OrderFile>> getOrderFiles(String sourceDirectory) {
		HashMap<String, ArrayList<OrderFile>> adFileList = new HashMap<String, ArrayList<OrderFile>>();

		ArrayList<OrderFile> designFileList = getOrderFile(sourceDirectory, ".indd");
		if (designFileList == null || designFileList.size() == 0)
			designFileList = getOrderFile(sourceDirectory, ".idml");

		adFileList.put(Constants.ORDER_FILE_FORMAT_INDD, designFileList);

		ArrayList<OrderFile> pdfFileList = getOrderFile(sourceDirectory, ".pdf");
		adFileList.put(Constants.ORDER_FILE_FORMAT_PDF, pdfFileList);

		ArrayList<OrderFile> assetsFileList = getOrderFile(sourceDirectory + "/" + Constants.ORDER_FOLDER_LINKS, null);
		adFileList.put(Constants.ORDER_FILE_FORMAT_DOC, assetsFileList);

		ArrayList<OrderFile> fontsFileList = getOrderFile(sourceDirectory + "/" + Constants.ORDER_FOLDER_DOCUMENT_FONTS,
				null);
		adFileList.put(Constants.ORDER_FILE_FORMAT_FONT, fontsFileList);

		ArrayList<OrderFile> tlChangesFileList = getOrderFile(sourceDirectory + "/" + Constants.ORDER_FOLDER_TL_CHANGES,
				null);
		adFileList.put(Constants.ORDER_FOLDER_TL_CHANGES, tlChangesFileList);

		ArrayList<OrderFile> csrChangesFileList = getOrderFile(
				sourceDirectory + "/" + Constants.ORDER_FOLDER_CSR_CHANGES, null);
		adFileList.put(Constants.ORDER_FOLDER_CSR_CHANGES, csrChangesFileList);

		return adFileList;
	}

	/**
	 * Rename indd and pdf file to temp.indd and temp.pdf and zip the entire file.
	 * 
	 * @param sourcePath
	 * @param slugName
	 * @return
	 */
	public static int zipDirectory(Orders orders, CatResult catResult) {
		int result = 0;

		try {

			SpringProperty sProperty = new SpringProperty();
			String mountParentFolder = sProperty.getPropertyValue("mountParentFolder");
			String sourceFolder = catResult.getSourcePath();

			File dir = new File(mountParentFolder + sourceFolder);

			String zipDirName = mountParentFolder + sourceFolder + catResult.getSlug() + ".zip";

//	        zipSingleFile(file, zipFileName);

			ZipFiles zipFiles = new ZipFiles();
			zipFiles.zipDirectory(dir, zipDirName);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public static boolean renameFile(String directory, String sourceFileName, String renameFileNameTo) {
		boolean isRename = false;

		try {

			SpringProperty sProperty = new SpringProperty();
			String mountParentFolder = sProperty.getPropertyValue("mountParentFolder");

			System.out.println("mountParentFolder : " + mountParentFolder + directory + "/");

			// directory = directory.replace(" ", "\\ ");

			File sourceFile = new File(mountParentFolder + directory + "/" + sourceFileName);
			File rename = new File(mountParentFolder + directory + "/" + renameFileNameTo);

			if (sourceFile.exists()) {
				isRename = sourceFile.renameTo(rename);
			}

			if (isRename == true) {
				System.out.println("File Successfully Rename");
			} else {
				System.out.println("Operation Failed");
			}
		} catch (Exception e) {
			System.out.println("renameFile : "+e);
		}

		return isRename;

	}

	public static void main(String[] args) {
		createSlugFolder("/1128212/1128212_Sep27TestAd02_dm_T_999_V1");
	}
}
