package com.epam.environments;

import com.epam.enums.Feeds;
import com.epam.feeds.Feed;
import com.epam.feeds.preProd.PlaFeedPreProd;
import com.epam.feeds.preProd.SearchAndPromoteBannerPreProd;
import com.epam.feeds.preProd.SearchAndPromoteBundlePreProd;
import com.epam.feeds.preProd.SearchAndPromoteProductsPreProd;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class PreProdEnvironment extends Environment {

	public PreProdEnvironment(FTPClient ftpClient) {
		super(ftpClient);
	}
	@Override
	public Feed getFeed(Feeds feed) {
		switch (feed) {
			case PLAFeed:
				return new PlaFeedPreProd(ftpClient);
			case SAndPBanner:
				return new SearchAndPromoteBannerPreProd(ftpClient);
			case SAndPBundle:
				return new SearchAndPromoteBundlePreProd(ftpClient);
			case SAndPProducts:
				return new SearchAndPromoteProductsPreProd(ftpClient);
			default:
				throw new UnsupportedOperationException("no current implementation");
		}
	}
}
