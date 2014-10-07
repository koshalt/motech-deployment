package org.motechproject.deployment.service.impl;

import org.motechproject.deployment.domain.ClientRecord;
import org.motechproject.deployment.repository.ClientRecordDataService;
import org.motechproject.deployment.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kosh on 10/7/14.
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRecordDataService clientRecordDataService;

    public void AddClientRecord(ClientRecord clientRecord) {
        clientRecordDataService.create(clientRecord);
    }
}
