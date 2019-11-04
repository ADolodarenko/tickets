package org.dav.ndw.interview.tickets.dao;

import org.dav.ndw.interview.tickets.model.Client;
import org.dav.ndw.interview.tickets.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Client> allClients() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client order by id").list();
    }

    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
    }

    @Override
    public void editClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }

    @Override
    public void deleteClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(client);
    }

    @Override
    public Client getClientById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }

    @Override
    public Client getClientByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client where login = :login");
        query.setParameter("login", login);

        List<Client> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    @Override
    public List<Ticket> allTickets() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Ticket").list();
    }

    @Override
    public void addTicket(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(ticket);
    }

    @Override
    public Ticket getTicketById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Ticket.class, id);
    }
}
