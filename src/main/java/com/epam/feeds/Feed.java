package com.epam.feeds;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public abstract class Feed {

	FTPClient ftpClient;
	Map<String, String> feed = new HashMap<String, String>();

	public Feed(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	protected Map<String, String> getAdobeFeedFileProps(String path, String fileName, String notificationMessage) {
		try {
			List<FTPFile> files = Arrays.asList(ftpClient.listFiles(path));
			for (FTPFile file : files) {
				if (file.getName().equals(fileName)) {
					feed.put(notificationMessage, file.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (feed.isEmpty()) {
			feed.put(notificationMessage, " wasn't found");
		}
		return feed;
	}

	public abstract Map<String, String> getFeedInfo();

}
