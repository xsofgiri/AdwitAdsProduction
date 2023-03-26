package com.production.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FileUtil {

	public static final String BASE_URL = "https://adwitads.com/weborders/downloads/";

	public static void main(String[] args) {

		try {

			// create a URL
			FileUtil fu = new FileUtil();
			fu.getResourceFiles("https://adwitads.com/weborders/images/mood_board/Bold/");

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
		Set<String> fileList = new HashSet<>();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
			for (Path path : stream) {
				if (!Files.isDirectory(path)) {
					System.out.println("path.getFileName().toString() : "+path.getFileName().toString());
					fileList.add(path.getFileName().toString());
				}
			}
		}
		return fileList;
	}

	private List<String> getResourceFiles(String path) throws IOException {
		List<String> filenames = new ArrayList<>();

		try (InputStream in = getResourceAsStream(path);
				BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String resource;

			while ((resource = br.readLine()) != null) {
				filenames.add(resource);
			}
		}

		return filenames;
	}

	private InputStream getResourceAsStream(String resource) {
		final InputStream in = getContextClassLoader().getResourceAsStream(resource);

		return in == null ? getClass().getResourceAsStream(resource) : in;
	}

	private ClassLoader getContextClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public int uploadAdAssets(MultipartFile mfile) {
		try {

			MediaType MEDIA_TYPE_IMAGE = MediaType.parse("image/*");

			File convFile = new File(mfile.getOriginalFilename());
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(mfile.getBytes());
			fos.close();

			OkHttpClient client = new OkHttpClient(); 
			 
			RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
					.addFormDataPart("file", mfile.getOriginalFilename(), RequestBody.create(MEDIA_TYPE_IMAGE, convFile)).build();
			 
			Request request = new Request.Builder().url(BASE_URL).post(requestBody).build();

			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				throw new IOException("Unexpected code " + response);
			}

			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	
	public  static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
	    File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
	    multipart.transferTo(convFile);
	    return convFile;
	}

	
}
