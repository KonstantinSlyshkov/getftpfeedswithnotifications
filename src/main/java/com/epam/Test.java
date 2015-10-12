package com.epam;

import com.epam.enums.Environments;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class Test {
	public static void main(String[] args) {
		final ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
			s.scheduleAtFixedRate(new Runnable() {
				public void run() {
					IdontKnowHowToNameThisMixerClass.sendFullNotification(Environments.PRODUCTION);
				}
			}, 18500, 6, TimeUnit.HOURS);
		}
}
