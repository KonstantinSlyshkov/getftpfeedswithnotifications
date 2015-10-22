package com.epam;

import com.epam.enums.Environments;
import com.epam.enums.Feeds;
import com.epam.environments.Environment;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
@Service
public class FeedUtils {
	private static FTPClient ftpClient = new FTPClient();

	public static Map<String, String> getFeedsMapByEnvironment(Environments environment) {
		Map<String, String> feed;
		try {
			ftpClient.connect("ftp.epam.com");
			ftpClient.login("pCTCO-FSUP", "6CJcZdcxF5");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			feed = new HashMap<>();
			Environment env = EnvironmentFactory.getEnvironment(environment, ftpClient);
			for(Feeds feeds: Feeds.values()) {
				feed.putAll(env.getFeed(feeds).getFeedInfo());
			}
		} finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return feed;
	}
	
}
