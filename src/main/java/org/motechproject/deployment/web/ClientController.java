package org.motechproject.deployment.web;

import org.motechproject.deployment.domain.ClientRecord;
import org.motechproject.deployment.service.ClientService;
import org.motechproject.deployment.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *Controller to retrieve server information
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clientInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addClientInfo(@RequestBody ClientRecord clientRecord) {
        clientService.AddClientRecord(clientRecord);
    }
}
