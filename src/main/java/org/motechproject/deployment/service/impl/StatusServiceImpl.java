package org.motechproject.deployment.service.impl;

import org.motechproject.deployment.service.StatusService;
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

    public StatusServiceImpl() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            serverName = ip.getHostName();
        } catch (UnknownHostException uh) {
            serverName =  "Could not get server name - " + uh.toString();
        }
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
