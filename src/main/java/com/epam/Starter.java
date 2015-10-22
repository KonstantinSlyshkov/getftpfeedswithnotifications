package com.epam;

import com.epam.enums.Environments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
@SpringBootApplication
public class Starter {
	public static void main(String[] args) {
		final ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.scheduleAtFixedRate(new Runnable() {
			public void run() {
				EmailNotification.sendMessage(FeedUtils.getFeedsMapByEnvironment(Environments.PRODUCTION));
			}
		}, 0, 6, TimeUnit.HOURS);
		ApplicationContext appCon = SpringApplication.run(Starter.class, args);
	}
}
