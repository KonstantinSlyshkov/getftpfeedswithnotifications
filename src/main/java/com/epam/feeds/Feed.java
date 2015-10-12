package com.epam.feeds;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.File;
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
	Map<String, String> adobeFeed = new HashMap<String, String>();

	public Feed(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	protected Map<String, String> getAdobeFeedFileProps(String path, String fileName, String notificationMessage) {
		try {
			List<FTPFile> files = Arrays.asList(ftpClient.listFiles(path));
			for (FTPFile file : files) {
				if (file.getName().equals(fileName)) {
					adobeFeed.put(notificationMessage, file.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (adobeFeed.isEmpty()) {
			adobeFeed.put(notificationMessage, " wasn't found");
		}
		return adobeFeed;
	}

	public abstract Map<String, String> getFeedInfo();

}
