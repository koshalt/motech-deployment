package org.motechproject.deployment.event;

import org.motechproject.event.MotechEvent;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kosh on 10/2/14.
 */
public final class Generator {

    public static MotechEvent sendDeploymentEvent(String serverName, Date serverTime, String message) {
        Map<String, Object> params = new HashMap<>();
        params.put(Parameters.SERVERNAME, serverName);
        params.put(Parameters.SERVERTIME, serverTime);
        params.put(Parameters.MESSAGE, message);
        return new MotechEvent(Subjects.MODULE_INSTALLED, params);
    }
}
