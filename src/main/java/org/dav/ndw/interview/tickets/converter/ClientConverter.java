package org.dav.ndw.interview.tickets.converter;

import org.dav.ndw.interview.tickets.model.Client;
import org.dav.ndw.interview.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ClientConverter implements Converter<Object, Client> {

    private TicketService ticketService;

    @Bean
    public ClientConverter getClientConverter() {
        return new ClientConverter();
    }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public Client convert(Object source) {
        Integer id = Integer.parseInt((String) source);
        Client client = ticketService.getClientById(id);
        return client;
    }
}
