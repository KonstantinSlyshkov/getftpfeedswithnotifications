package com.epam.environments;

import com.epam.enums.Feeds;
import com.epam.feeds.Feed;
import com.epam.feeds.prod.*;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class ProdEnvironment extends Environment {

	public ProdEnvironment(FTPClient ftpClient) {
		super(ftpClient);
	}

	@Override
	public Feed getFeed(Feeds feed) {
		switch (feed) {
			case PLAFeed:
				return new PlaFeedProd(ftpClient);
			case SAndPBanner:
				return new SearchAndPromoteBannerProd(ftpClient);
			case SAndPBundle:
				return new SearchAndPromoteBundleProd(ftpClient);
			case SAndPProducts:
				return new SearchAndPromoteProductsProd(ftpClient);
			case AdobeFeed:
				return new AdobeFeedProd(ftpClient);
			default:
				throw new UnsupportedOperationException("no current implementation");
		}
	}
}
