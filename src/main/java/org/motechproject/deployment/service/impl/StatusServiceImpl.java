package org.motechproject.deployment.service.impl;

import org.motechproject.deployment.service.StatusService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kosh on 10/1/14.
 */
public class StatusServiceImpl implements StatusService {

    public String serverStatus() {
        return "OK";
    }

    public String serverName() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostName();
        } catch (UnknownHostException uh) {
            return "Could not get server name - " + uh.toString();
        }
    }

    public String serverTime() {
        SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm a");
        return df.format(new Date());
    }
}
