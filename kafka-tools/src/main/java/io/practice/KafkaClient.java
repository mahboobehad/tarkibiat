// In the name of Allah
package io.practice;

import com.google.gson.Gson;
import io.practice.entity.DatabaseSourceConnector;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KafkaClient {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private Properties config;
    private Gson gson;
    private Logger logger;

    public KafkaClient() throws IOException {
        InputStream input = getClass().getResourceAsStream("/config.properties");
        if (input == null)
            throw new IOException();

        config = new Properties();
        config.load(input);

        logger = LoggerFactory.getLogger(getClass().getName());

        gson = new Gson();
    }

    public void addConnector(DatabaseSourceConnector connector) throws Exception {
        HttpPost post = new HttpPost(config.getProperty(ConfigKeys.CONNECTOR_ENDPOINT));

        post.setHeader("Content-type", "application/json");

        StringEntity entity = new StringEntity(gson.toJson(connector));
        post.setEntity(entity);

        try (CloseableHttpResponse response = httpClient.execute(post)) {
            logger.info(response.toString());
        }
    }
}
