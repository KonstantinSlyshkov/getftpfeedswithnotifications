package com.epam.feeds.prod;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class PlaFeedProd extends Feed {
	private static final String PATH_TO_FILE = "/google-pla/prod/";
	private static final String FEED_NAME_NOTIFICATION = "PLA production feed file ";
	private static final String FILE_NAME = "SPCK_PLA_ACTIVE";

	public PlaFeedProd(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
