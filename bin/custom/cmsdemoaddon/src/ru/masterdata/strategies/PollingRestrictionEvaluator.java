package ru.masterdata.strategies;

import de.hybris.platform.cms2.model.contents.components.PollingCMSComponentModel;
import de.hybris.platform.cms2.model.restrictions.PollingShowRestrictionModel;
import de.hybris.platform.cms2.servicelayer.data.RestrictionData;
import de.hybris.platform.cms2.servicelayer.services.evaluator.CMSRestrictionEvaluator;

/**
 * @author Goncharenko Mikhail, created on 22.12.2017.
 */
public class PollingRestrictionEvaluator implements CMSRestrictionEvaluator<PollingShowRestrictionModel> {

  @Override
  public boolean evaluate(PollingShowRestrictionModel restriction, RestrictionData restrictionData) {
    Integer totalHits = restriction.getComponents().stream()
               .map(PollingCMSComponentModel.class::cast)
               .mapToInt(PollingCMSComponentModel::getHits)
               .sum();
    return restriction.getHitsAllowed() > totalHits;
  }
}
