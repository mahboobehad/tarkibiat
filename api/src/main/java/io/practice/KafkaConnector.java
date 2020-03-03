package io.practice;

import io.practice.entity.ConnectorParams;
import io.practice.entity.DatabaseSourceConnector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/connector")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KafkaConnector {
    @POST
    @Path("/add")
    public Response add(ConnectorParams connectorParams) throws Exception {
        DatabaseSourceConnector connector = new DatabaseSourceConnector(connectorParams.getName(),
                connectorParams.getDatabaseUrl(), connectorParams.getUser(), connectorParams.getPassword());
        KafkaClient kafkaClient = new KafkaClient();
        kafkaClient.addConnector(connector);

        return Response.status(200).entity("Added connector").build();
    }
}
