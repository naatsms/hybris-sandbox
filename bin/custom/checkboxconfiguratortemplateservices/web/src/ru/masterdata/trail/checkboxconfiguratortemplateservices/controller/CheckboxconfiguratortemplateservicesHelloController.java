/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package ru.masterdata.trail.checkboxconfiguratortemplateservices.controller;

import static ru.masterdata.trail.checkboxconfiguratortemplateservices.constants.CheckboxconfiguratortemplateservicesConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.masterdata.trail.checkboxconfiguratortemplateservices.service.CheckboxconfiguratortemplateservicesService;


@Controller
public class CheckboxconfiguratortemplateservicesHelloController
{
	@Autowired
	private CheckboxconfiguratortemplateservicesService checkboxconfiguratortemplateservicesService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", checkboxconfiguratortemplateservicesService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
