package com.epam.feeds.qa;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class SearchAndPromoteBannerQA extends Feed {
	private static final String PATH_TO_FILE = "/search-and-promote-feed/qa/";
	private static final String FEED_NAME_NOTIFICATION = "banner";
	private static final String FILE_NAME = "banner-feed-full.xml";

	public SearchAndPromoteBannerQA(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
