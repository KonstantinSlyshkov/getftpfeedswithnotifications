package com.epam.environments;

import com.epam.enums.Feeds;
import com.epam.feeds.Feed;
import com.epam.feeds.qa.*;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class QAEnvironment extends Environment {

	public QAEnvironment(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Feed getFeed(Feeds feed) {
		switch (feed) {
			case PLAFeed:
				return new PlaFeedQA(ftpClient);
			case SAndPBanner:
				return new SearchAndPromoteBannerQA(ftpClient);
			case SAndPBundle:
				return new SearchAndPromoteBundleQA(ftpClient);
			case SAndPProducts:
				return new SearchAndPromoteProductsQA(ftpClient);
			case AdobeFeed:
				return new AdobeFeedQA(ftpClient);
			default:
				throw new UnsupportedOperationException("no current implementation");
		}
	}
}
