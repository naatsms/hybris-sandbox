package ru.masterdata.trail.checkboxconfiguratortemplatefacades.populators;

import java.util.List;

import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.checkboxconfiguratortemplateservices.model.CheckboxConfiguredProductInfoModel;
import de.hybris.platform.commercefacades.order.data.ConfigurationInfoData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.order.model.AbstractOrderEntryProductInfoModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

/**
 * Created by Михаил on 01.09.2017.
 */
public class CheckboxConfigurationsPopulator<T extends AbstractOrderEntryProductInfoModel> implements Populator<T, List<ConfigurationInfoData>> {

  @Override
  public void populate(T source, List<ConfigurationInfoData> target) throws ConversionException {
    if (source.getConfiguratorType() == ConfiguratorType.CHECKBOX) {
      if (!(source instanceof CheckboxConfiguredProductInfoModel)) {
        throw new ConversionException("Instance with type " + source.getConfiguratorType() + " is of class "
                                      + source.getClass().getName() + " which is not convertible to "
                                      + CheckboxConfiguredProductInfoModel.class.getName());
      }
      final ConfigurationInfoData item = new ConfigurationInfoData();
      final CheckboxConfiguredProductInfoModel model = ((CheckboxConfiguredProductInfoModel) source);
      item.setConfiguratorType(model.getConfiguratorType());
      item.setConfigurationLabel(model.getConfigurationLabel());
      item.setConfigurationValue(String.valueOf(model.isChecked()));
      item.setStatus(source.getProductInfoStatus());
      target.add(item);
    }
  }

}
