package com.epam;

import com.epam.enums.Environments;
import com.epam.enums.Feeds;
import com.epam.environments.Environment;
import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
//TODO don't forget to rename class
public class IdontKnowHowToNameThisMixerClass {
	private static FTPClient ftpClient = new FTPClient();

	public static void sendFullNotification(Environments environment) {
		try {
			ftpClient.connect("ftp.epam.com");
			ftpClient.login("pCTCO-FSUP", "6CJcZdcxF5");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FeedInfo feedInfo = new FeedInfo(environment);
			Map<String, String> feeds = feedInfo.getFullFeedsInfo();
			EmailNotification.sendMessage(feeds);
		} finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

	private static class FeedInfo {
		private Environments environment;
		public FeedInfo(Environments environment) {
			this.environment = environment;
		}
		public Map<String, String> getFullFeedsInfo(){
			return extractFeedsAndMergeThem();
		}

		//TODO here I've just fucked up Java, so need to change architecture and update
		private Map<String, String> extractFeedsAndMergeThem() {
			Environment env = EnvironmentFactory.getEnvironment(environment, ftpClient);
			Map<String, String> feedInfo = env.getFeed(Feeds.SAndPProducts).getFeedInfo();
			Map<String, String> feedInfo1 = env.getFeed(Feeds.SAndPBanner).getFeedInfo();
			Map<String, String> feedInfo2 = env.getFeed(Feeds.PLAFeed).getFeedInfo();
			Map<String, String> feedInfo3 = env.getFeed(Feeds.AdobeFeed).getFeedInfo();
			Map<String, String> feedInfo4 = env.getFeed(Feeds.SAndPBundle).getFeedInfo();
			Map<String, String> tmp = new HashMap<String, String>();
			tmp.putAll(feedInfo);
			tmp.putAll(feedInfo1);
			tmp.putAll(feedInfo2);
			tmp.putAll(feedInfo3);
			tmp.putAll(feedInfo4);
			return tmp;
		}
	}
}
