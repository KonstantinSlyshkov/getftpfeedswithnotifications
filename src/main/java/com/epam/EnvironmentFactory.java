package com.epam;

import com.epam.enums.Environments;
import com.epam.environments.*;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
public class EnvironmentFactory {

	public static Environment getEnvironment(Environments environment, FTPClient ftpClient) {
		switch (environment) {
			case PRODUCTION:
				return new ProdEnvironment(ftpClient);
			case PRE_PRODUCTION:
				return new PreProdEnvironment(ftpClient);
			case QA:
				return new QAEnvironment(ftpClient);
			case UAT2:
				return new Uat2Environment(ftpClient);
			default:
				throw new UnsupportedOperationException("Environment wasn't implemented");
		}
	}
}
