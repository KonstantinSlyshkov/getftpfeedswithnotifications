package com.epam.feeds.prod;

import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

import java.util.*;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class AdobeFeedProd extends Feed {

	private static final String PATH_TO_FILE = "/adobe-recs/prod/";
	private static final String FEED_NAME_NOTIFICATION = "Adobe production feed file ";
	private static final String FILE_NAME = "SPCK_RECS.csv";

	public AdobeFeedProd(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Map<String, String> getFeedInfo() {
		return super.getAdobeFeedFileProps(PATH_TO_FILE, FILE_NAME, FEED_NAME_NOTIFICATION);
	}

}
