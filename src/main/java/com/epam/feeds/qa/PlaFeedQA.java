package com.epam.feeds.qa;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class PlaFeedQA extends Feed {
	private static final String PATH_TO_FILE = "/google-pla/qa/";
	private static final String FEED_NAME_NOTIFICATION = "pla";
	private static final String FILE_NAME = "SPCK_PLA_ACTIVE";

	public PlaFeedQA(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
