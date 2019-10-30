package org.dav.ndw.interview.tickets.service;

import org.dav.ndw.interview.tickets.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> allClients();
    void add(Client client);
    void edit(Client client);
    void delete(Client client);
    Client getById(int id);
}
