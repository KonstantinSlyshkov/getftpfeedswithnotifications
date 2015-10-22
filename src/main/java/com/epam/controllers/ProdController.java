package com.epam.controllers;

import com.epam.FeedUtils;
import com.epam.enums.Environments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Kostiantyn_Slyshkov on 10/12/2015.
 */
@RestController
public class ProdController {

	@RequestMapping("prod")
	public Map getFeedsInformationForProd() {
		return FeedUtils.getFeedsMapByEnvironment(Environments.PRODUCTION);
	}

	@RequestMapping("qa")
	public Map getFeedsInformationForQA() {
		return FeedUtils.getFeedsMapByEnvironment(Environments.QA);
	}

	@RequestMapping("uat2")
	public Map getFeedsInformationForUat2() {;
		return FeedUtils.getFeedsMapByEnvironment(Environments.UAT2);
	}

	@RequestMapping("preprod")
	public Map getFeedsInformationForPreProd () {
		return FeedUtils.getFeedsMapByEnvironment(Environments.PRE_PRODUCTION);
	}
}
