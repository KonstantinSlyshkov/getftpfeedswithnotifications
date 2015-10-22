package com.epam.feeds.prod;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class SearchAndPromoteProductsProd extends Feed {
	private static final String PATH_TO_FILE = "/search-and-promote-feed/prod/";
	private static final String FEED_NAME_NOTIFICATION = "full";
	private static final String FILE_NAME = "product-feed-full.xml";

	public SearchAndPromoteProductsProd(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
