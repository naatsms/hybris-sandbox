package ru.masterdata.handlers;

import de.hybris.platform.cms2.model.restrictions.PollingShowRestrictionModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

/**
 * @author Goncharenko Mikhail, created on 22.12.2017.
 */
public class PollingShowDescription implements DynamicAttributeHandler<String, PollingShowRestrictionModel> {

  @Override
  public String get(PollingShowRestrictionModel model) {
    return PollingShowRestrictionModel.DESCRIPTION;
  }

  @Override
  public void set(PollingShowRestrictionModel model, String s) {
    throw new UnsupportedOperationException();
  }
}
