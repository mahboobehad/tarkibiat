// In the name of Allah
package io.practice.entity;

import org.classpath.icedtea.Config;

public class DatabaseSourceConnector {
    private String name;
    private DatabaseSourceConnectorConfig config;

    public DatabaseSourceConnector(String name, String databaseUrl, String user, String password){
        this.name = name;
        config = new DatabaseSourceConnectorConfig();
        config.setSourceUrl(databaseUrl);
        config.setUser(user);
        config.setPassword(password);
        config.setTopicPrefix(name + "-");
    }

    public void setConfig(DatabaseSourceConnectorConfig config) {
        this.config = config;
    }

    public void setName(String name) {
        this.name = name;
    }
}
