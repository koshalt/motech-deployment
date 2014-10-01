package org.motechproject.deployment.web;

import org.motechproject.deployment.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *Controller to retrieve server information
 */
@Controller
public class StatusController {

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/serverName", method = RequestMethod.GET)
    @ResponseBody
    public String serverName() {
        return statusService.serverName();
    }

    @RequestMapping(value = "serverStatus", method = RequestMethod.GET)
    @ResponseBody
    public String serverStatus() {
        return statusService.serverStatus();
    }

    @RequestMapping(value = "serverTime", method = RequestMethod.GET)
    @ResponseBody
    public String serverTime() {
        return statusService.serverTime();
    }
}
