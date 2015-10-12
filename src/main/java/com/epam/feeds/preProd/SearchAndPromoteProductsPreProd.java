package com.epam.feeds.preProd;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class SearchAndPromoteProductsPreProd extends Feed {
	private static final String PATH_TO_FILE = "/search-and-promote-feed/prod/";
	private static final String FEED_NAME_NOTIFICATION = "S&P pre-prod full feed file ";
	private static final String FILE_NAME = "product-feed-full.xml";

	public SearchAndPromoteProductsPreProd(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}
}
