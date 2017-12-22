package de.hybris.platform.yb2bacceleratorstorefront.controllers.cms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hybris.platform.cms2.model.contents.components.PollingCMSComponentModel;
import de.hybris.platform.yb2bacceleratorstorefront.controllers.ControllerConstants;

/**
 * @author Goncharenko Mikhail, created on 21.12.2017.
 */
@Controller("PollingCMSComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.PollingCmsComponentController)
public class PollingCMSComponentController extends AbstractAcceleratorCMSComponentController<PollingCMSComponentModel> {

  @Override
  protected void fillModel(HttpServletRequest request, Model model, PollingCMSComponentModel component) {
    model.addAttribute("question", component.getQuestion());
    model.addAttribute("answers", component.getAnswers());
    model.addAttribute("pollType",component.getPollType().getCode());
    model.addAttribute("responseUrl",ControllerConstants.Actions.Cms.PollingCmsComponentController);
  }

  @RequestMapping(method = RequestMethod.POST)
  public void acceptAnswer() {
    //Do something disgusting
  }

}