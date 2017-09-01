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
package ru.masterdata.trail.checkboxconfiguratortemplateservices.setup;

import static ru.masterdata.trail.checkboxconfiguratortemplateservices.constants.CheckboxconfiguratortemplateservicesConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import ru.masterdata.trail.checkboxconfiguratortemplateservices.constants.CheckboxconfiguratortemplateservicesConstants;
import ru.masterdata.trail.checkboxconfiguratortemplateservices.service.CheckboxconfiguratortemplateservicesService;


@SystemSetup(extension = CheckboxconfiguratortemplateservicesConstants.EXTENSIONNAME)
public class CheckboxconfiguratortemplateservicesSystemSetup
{
	private final CheckboxconfiguratortemplateservicesService checkboxconfiguratortemplateservicesService;

	public CheckboxconfiguratortemplateservicesSystemSetup(final CheckboxconfiguratortemplateservicesService checkboxconfiguratortemplateservicesService)
	{
		this.checkboxconfiguratortemplateservicesService = checkboxconfiguratortemplateservicesService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		checkboxconfiguratortemplateservicesService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CheckboxconfiguratortemplateservicesSystemSetup.class.getResourceAsStream("/checkboxconfiguratortemplateservices/sap-hybris-platform.png");
	}
}
