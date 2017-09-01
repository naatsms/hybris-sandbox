package ru.masterdata.trail.checkboxconfiguratortemplatefacades.strategies;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import de.hybris.platform.commercefacades.order.data.ConfigurationInfoData;
import de.hybris.platform.commercefacades.product.strategies.merge.ProductConfigurationMergeStrategy;

/**
 * Created by Михаил on 01.09.2017.
 */
public class CheckboxProductConfigurationMergeStrategy implements ProductConfigurationMergeStrategy {

  public static final String CHECKBOX_CHECKED_VALUE = "on";

  @Nonnull
  @Override
  public List<ConfigurationInfoData> merge(List<ConfigurationInfoData> baseConfiguration, List<ConfigurationInfoData> mergeConfiguration) {
    List<String> formLabels = baseConfiguration.stream()
                                               .peek(this::setConfigurationValueToBooleanString)
                                               .map(ConfigurationInfoData::getConfigurationLabel)
                                               .collect(Collectors.toList());

    List<ConfigurationInfoData> checkboxConfiguration = mergeConfiguration.stream()
                                                                          .filter(checkBoxConfiguration -> !formLabels.contains(checkBoxConfiguration.getConfigurationLabel()))
                                                                          .collect(Collectors.toList());

    checkboxConfiguration.stream()
                         .forEach(configuration -> configuration.setConfigurationValue(Boolean.FALSE.toString()));

    return checkboxConfiguration;
  }

  private void setConfigurationValueToBooleanString(ConfigurationInfoData configurationInfoData) {
    configurationInfoData.setConfigurationValue(
      Boolean.valueOf(CHECKBOX_CHECKED_VALUE.equals(configurationInfoData.getConfigurationValue())).toString());
  }
}
