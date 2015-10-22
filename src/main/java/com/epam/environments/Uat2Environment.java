package com.epam.environments;

import com.epam.enums.Feeds;
import com.epam.feeds.Feed;
import com.epam.feeds.Uat2.*;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class Uat2Environment extends Environment {
	public Uat2Environment(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Feed getFeed(Feeds feed) {
		switch (feed) {
			case PLAFeed:
				return new PlaFeedUat2(ftpClient);
			case SAndPBanner:
				return new SearchAndPromoteBannerUAT2(ftpClient);
			case SAndPBundle:
				return new SearchAndPromoteBundleUat2(ftpClient);
			case SAndPProducts:
				return new SearchAndPromoteProductsUat2(ftpClient);
			case AdobeFeed:
				return new AdobeFeedUAT2(ftpClient);
			default:
				throw new UnsupportedOperationException("no current implementation");
		}
	}
}
