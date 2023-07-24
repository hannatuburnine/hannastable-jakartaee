package com.hannastable.resources;

import com.hannastable.daos.ClientsDao;
import com.hannastable.dtos.ClientDTO;
import com.hannastable.models.Client;
import com.hannastable.services.ClientsService;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import net.bytebuddy.asm.MemberSubstitution;

import java.util.ArrayList;

@Path("/clients")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class ClientsResource {

    @GET
    public ArrayList<ClientDTO> getAllClients() {
        ClientsService clientsService = new ClientsService();
        ArrayList<ClientDTO> clientList = clientsService.getAllClients();
        return clientList;
    }

    @POST
    public Client createClient(Client client) throws Exception {
        ClientsService clientsService = new ClientsService();
        Client returnedClient = clientsService.createClient(client);
        return returnedClient;
    }

    @GET
    @Path("/{id}")
    public Client getOneClient(@PathParam("id") int id) {
        ClientsService clientsService = new ClientsService();
        Client returnedClient = clientsService.getOneClient(id);
        return returnedClient;
    }

    @DELETE
    @Path("/{id}")
    public void deleteClient(@PathParam("id") int id) {
        ClientsService clientsService = new ClientsService();
        Client returnedClient = clientsService.deleteClient(id);
    }

    @PUT
    @Path("/{id}")
    public Client updateClient(@PathParam("id") int id, Client updatedInfo) {
        ClientsService clientsService = new ClientsService();
        Client returnedClient = clientsService.updateClient(id, updatedInfo);
        return returnedClient;
    }


}
