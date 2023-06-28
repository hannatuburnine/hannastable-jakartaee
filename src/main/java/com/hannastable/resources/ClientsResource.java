package com.hannastable.resources;

import com.hannastable.daos.ClientsDao;
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
    public ArrayList<Client> getAllClients() {
        ClientsService clientsService = new ClientsService();
        ArrayList<Client> clientList = clientsService.getAllClients();
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
        return null;
    }

    @DELETE
    @Path("/{id}")
    public void deleteClient(@PathParam("id") int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Client> query = manager.createQuery("SELECT C FROM Client C WHERE C.id = :idDaPessoaASerPesquisada", Client.class);
        query.setParameter("idDaPessoaASerPesquisada", id);
        Client client = query.getSingleResult();
        manager.remove(client);
        manager.getTransaction().commit();
    }

    @PUT
    @Path("/{id}")
    public void updateClient(@PathParam("id") int id, Client updatedInfo) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("hannastabledb_pu");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        TypedQuery<Client> query = manager.createQuery("SELECT C FROM Client C WHERE C.id = :idOfThePersonToBeUpdated", Client.class);
        query.setParameter("idOfThePersonToBeUpdated", id);
        Client client = query.getSingleResult();
        client.setName(updatedInfo.getName());
        manager.merge(client);
        manager.getTransaction().commit();
    }


}
