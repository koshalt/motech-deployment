package org.motechproject.deployment.service.impl;

import org.motechproject.deployment.event.Generator;
import org.motechproject.deployment.repository.StatusRecordDataService;
import org.motechproject.deployment.service.StatusService;
import org.motechproject.event.listener.EventRelay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Status service implementation to get server details
 */
@Service("statusService")
public class StatusServiceImpl implements StatusService {

    private String serverName;

    @Autowired
    private StatusRecordDataService statusRecordDataService;

    @Autowired
    private EventRelay eventRelay;

    public StatusServiceImpl() {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            serverName = ip.getHostName();
        } catch (UnknownHostException uh) {
            serverName =  "Could not get server name - " + uh.toString();
        }

        eventRelay.sendEventMessage(Generator.sendDeploymentEvent(this.serverName, new Date(), "Status service initialized"));
    }

    public String serverStatus() {
        return "OK";
    }

    public String serverName() {
        return this.serverName;
    }

    public String serverTime() {
        SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm a");
        return df.format(new Date());
    }
}
