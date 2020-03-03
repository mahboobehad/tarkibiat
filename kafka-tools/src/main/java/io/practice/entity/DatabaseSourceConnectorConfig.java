package io.practice.entity;

import com.google.gson.annotations.SerializedName;

public class DatabaseSourceConnectorConfig {
    @SerializedName("connection.url")
    private String sourceUrl;

    @SerializedName("connection.user")
    private String user;

    @SerializedName("connection.password")
    private String password;

    @SerializedName("mode")
    private String mode = "bulk";

    @SerializedName("topic.prefix")
    private String topicPrefix;

    @SerializedName("connector.class")
    private String connectorClass = "io.confluent.connect.jdbc.JdbcSourceConnector";

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTopicPrefix(String topicPrefix) {
        this.topicPrefix = topicPrefix;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setConnectorClass(String connectorClass) {
        this.connectorClass = connectorClass;
    }
}
