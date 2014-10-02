package org.motechproject.deployment.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import java.util.Date;

/**
 * Record to store the deployment info for the module
 */
@Entity
public class StatusRecord {

    @Field
    public String serverName;

    @Field
    public Date serverTime;

    @Field
    public String message;

    public StatusRecord() {
    }

    public StatusRecord(String serverName, Date serverTime, String message) {
        this.serverName = serverName;
        this.serverTime = serverTime;
        this.message = message;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusRecord)) return false;

        StatusRecord that = (StatusRecord) o;

        if (!message.equals(that.message)) return false;
        if (!serverName.equals(that.serverName)) return false;
        if (!serverTime.equals(that.serverTime)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serverName.hashCode();
        result = 31 * result + serverTime.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StatusRecord{" +
                "serverName='" + serverName + '\'' +
                ", serverTime=" + serverTime +
                ", message='" + message + '\'' +
                '}';
    }
}
