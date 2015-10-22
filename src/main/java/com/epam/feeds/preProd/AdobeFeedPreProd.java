package com.epam.feeds.preProd;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/16/2015.
 */
public class AdobeFeedPreProd extends Feed {

	private static final String PATH_TO_FILE = "/adobe-recs/preprod/";
	private static final String FEED_NAME_NOTIFICATION = "adobe";
	private static final String FILE_NAME = "SPCK_RECS.csv";

	public AdobeFeedPreProd(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
