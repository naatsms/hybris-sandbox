package ru.masterdata.trail.checkboxconfiguratortemplateservices.order.hook;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import de.hybris.platform.catalog.enums.ConfiguratorType;
import de.hybris.platform.checkboxconfiguratortemplateservices.model.CheckboxConfiguredProductInfoModel;
import de.hybris.platform.commerceservices.order.ProductConfigurationHandler;
import de.hybris.platform.commerceservices.service.data.ProductConfigurationItem;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.order.model.AbstractOrderEntryProductInfoModel;
import de.hybris.platform.product.model.AbstractConfiguratorSettingModel;
import ru.masterdata.trail.checkboxconfiguratortemplateservices.model.CheckboxConfiguratorSettingsModel;

/**
 * Created by Михаил on 01.09.2017.
 */
public class CheckboxConfigurationHandler implements ProductConfigurationHandler {

  @Override
  public List<AbstractOrderEntryProductInfoModel> createProductInfo(AbstractConfiguratorSettingModel productSettings) {
    if (!(productSettings instanceof CheckboxConfiguratorSettingsModel)) {
      throw new IllegalArgumentException("Argument must be a type of ChecboxConfiguratorSettingsModel");
    }
    CheckboxConfiguratorSettingsModel checkboxSettings = (CheckboxConfiguratorSettingsModel) productSettings;
    CheckboxConfiguredProductInfoModel result = new CheckboxConfiguredProductInfoModel();
    result.setConfiguratorType(ConfiguratorType.CHECKBOX);
    result.setConfigurationLabel(checkboxSettings.getConfigurationLabel());
    result.setChecked(checkboxSettings.isChecked());
    return Collections.singletonList(result);
  }

  @Override
  public List<AbstractOrderEntryProductInfoModel> convert(Collection<ProductConfigurationItem> items, AbstractOrderEntryModel entry) {
    return items.stream()
                .map(item -> {
                  CheckboxConfiguredProductInfoModel result = new CheckboxConfiguredProductInfoModel();
                  result.setConfigurationLabel(item.getKey());
                  result.setConfiguratorType(ConfiguratorType.CHECKBOX);
                  result.setChecked(Boolean.valueOf(item.getValue().toString()));
                  return result;
                }).collect(Collectors.toList());
  }
}
