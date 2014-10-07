package org.motechproject.deployment.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import java.util.Date;

/**
 * Record to store the deployment info for the module
 */
@Entity
public class ClientRecord {

    @Field
    public String clientName;

    @Field
    public Date clientTime;

    @Field
    public String message;

    public ClientRecord() {
    }

    public ClientRecord(String clientName, Date clientTime, String message) {
        this.clientName = clientName;
        this.clientTime = clientTime;
        this.message = message;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getClientTime() {
        return clientTime;
    }

    public void setClientTime(Date clientTime) {
        this.clientTime = clientTime;
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
        if (!(o instanceof ClientRecord)) return false;

        ClientRecord that = (ClientRecord) o;

        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientTime != null ? !clientTime.equals(that.clientTime) : that.clientTime != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientName != null ? clientName.hashCode() : 0;
        result = 31 * result + (clientTime != null ? clientTime.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "clientName='" + clientName + '\'' +
                ", clientTime=" + clientTime +
                ", message='" + message + '\'' +
                '}';
    }
}
