package org.dav.ndw.interview.tickets.service;

import org.dav.ndw.interview.tickets.dao.ClientDAO;
import org.dav.ndw.interview.tickets.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDAO clientDAO;

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    @Transactional
    public List<Client> allClients() {
        return clientDAO.allClients();
    }

    @Override
    @Transactional
    public void add(Client client) {
        clientDAO.add(client);
    }

    @Override
    @Transactional
    public void edit(Client client) {
        clientDAO.edit(client);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        clientDAO.delete(client);
    }

    @Override
    @Transactional
    public Client getById(int id) {
        return clientDAO.getById(id);
    }
}
