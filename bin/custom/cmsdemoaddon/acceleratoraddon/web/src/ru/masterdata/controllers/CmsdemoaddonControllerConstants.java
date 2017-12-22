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
package ru.masterdata.controllers;

import de.hybris.platform.cms2.jalo.contents.components.PollingCMSComponent;
import de.hybris.platform.cms2.model.contents.components.PollingCMSComponentModel;

/**
 */
public interface CmsdemoaddonControllerConstants
{
	public interface Cms {

    String _Prefix = "/view/"; // NOSONAR
    String _Suffix = "Controller"; // NOSONAR

	  String PollingCmsComponentController = _Prefix + PollingCMSComponentModel._TYPECODE + _Suffix;

  }// implement here controller constants used by this extension
}
