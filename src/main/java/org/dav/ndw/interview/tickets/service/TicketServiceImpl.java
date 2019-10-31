package org.dav.ndw.interview.tickets.service;

import org.dav.ndw.interview.tickets.dao.TicketDAO;
import org.dav.ndw.interview.tickets.model.Client;
import org.dav.ndw.interview.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketDAO ticketDAO;

    @Autowired
    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    @Transactional
    public List<Client> allClients() {
        return ticketDAO.allClients();
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        ticketDAO.addClient(client);
    }

    @Override
    @Transactional
    public void editClient(Client client) {
        ticketDAO.editClient(client);
    }

    @Override
    @Transactional
    public void deleteClient(Client client) {
        ticketDAO.deleteClient(client);
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return ticketDAO.getClientById(id);
    }

    @Override
    @Transactional
    public List<Ticket> allTickets() {
        return ticketDAO.allTickets();
    }

    @Override
    @Transactional
    public void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }

    @Override
    @Transactional
    public void deleteTicket(Ticket ticket) {
        ticketDAO.deleteTicket(ticket);
    }

    @Override
    @Transactional
    public Ticket getTicketById(int id) {
        return ticketDAO.getTicketById(id);
    }
}
