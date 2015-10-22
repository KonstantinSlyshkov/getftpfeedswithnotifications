package com.epam.feeds.Uat2;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class AdobeFeedUAT2 extends Feed {

	private static final String PATH_TO_FILE = "/adobe-recs/uat2/";
	private static final String FEED_NAME_NOTIFICATION = "adobe";
	private static final String FILE_NAME = "SPCK_RECS.csv";


	Map<String, String> adobeFeed = new HashMap<String, String>();

	public AdobeFeedUAT2(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
