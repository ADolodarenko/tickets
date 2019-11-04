package org.dav.ndw.interview.tickets.service;

import org.dav.ndw.interview.tickets.model.Client;
import org.dav.ndw.interview.tickets.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Client> allClients();
    void addClient(Client client);
    void editClient(Client client);
    void deleteClient(Client client);
    Client getClientById(int id);
    Client getClientByLogin(String login);
    List<Ticket> allTickets();
    void addTicket(Ticket ticket);
    void deleteTicket(Ticket ticket);
    Ticket getTicketById(int id);
}
