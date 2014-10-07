package org.motechproject.deployment.event;

import org.motechproject.deployment.domain.StatusRecord;
import org.motechproject.deployment.event.Parameters;
import org.motechproject.deployment.event.Subjects;
import org.motechproject.deployment.repository.StatusRecordDataService;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.annotations.MotechListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kosh on 10/2/14.
 */
@Component
public class Handler {

    @Autowired
    private StatusRecordDataService statusRecordDataService;

    @MotechListener(subjects = {Subjects.MODULE_INSTALLED})
    public void handleInstallEvents(MotechEvent event) {
        String message = (String)event.getParameters().get(Parameters.MESSAGE);
        String serverName = (String)event.getParameters().get(Parameters.SERVERNAME);
        String serverTime = (String)event.getParameters().get(Parameters.SERVERTIME);
        try {
            Date serverDate = new SimpleDateFormat("YYYY/MM/dd HH:mm a", Locale.ENGLISH).parse(serverTime);
            StatusRecord sr = new StatusRecord(serverName, serverDate, message);
            statusRecordDataService.create(sr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
