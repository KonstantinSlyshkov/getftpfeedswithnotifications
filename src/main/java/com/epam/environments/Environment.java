package com.epam.environments;

import com.epam.enums.Feeds;
import com.epam.feeds.Feed;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public abstract class Environment {

	FTPClient ftpClient;

	public Environment(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
	public abstract Feed getFeed(Feeds feed);
}
