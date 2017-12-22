package ru.masterdata.strategies;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;

import de.hybris.platform.acceleratorcms.component.container.CMSComponentContainerStrategy;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.cms2.model.contents.components.SimpleCMSComponentModel;
import de.hybris.platform.cms2.model.contents.containers.AbstractCMSComponentContainerModel;

/**
 * @author Goncharenko Mikhail, created on 21.12.2017.
 */

public class PollingComponentContainerStrategy implements CMSComponentContainerStrategy {

  @Override
  public List<AbstractCMSComponentModel> getDisplayComponentsForContainer(AbstractCMSComponentContainerModel container) {
    List<SimpleCMSComponentModel> components = container.getSimpleCMSComponents();
    int random = RandomUtils.nextInt(components.size());
    return Collections.singletonList(components.get(random));
  }

}
