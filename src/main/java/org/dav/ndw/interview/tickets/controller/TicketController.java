package org.dav.ndw.interview.tickets.controller;

import org.dav.ndw.interview.tickets.model.Client;
import org.dav.ndw.interview.tickets.model.Ticket;
import org.dav.ndw.interview.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * @return ModelAndView for the login page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * @return ModelAndView for the main page.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * @return ModelAndView for the list of clients.
     */
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ModelAndView allClients() {
        List<Client> clients = ticketService.allClients();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clients");
        modelAndView.addObject("clientsList", clients);
        return modelAndView;
    }

    /**
     * @param id - ID of the client that needs to be edited.
     * @return ModelAndView for the page for editing client that already exists.
     */
    @RequestMapping(value = "/clientEdit/{id}", method = RequestMethod.GET)
    public ModelAndView clientEditPage(@PathVariable("id") int id) {
        Client client = ticketService.getClientById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clientEdit");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    /**
     * @return ModelAndView for the page for editing new client.
     */
    @RequestMapping(value = "/clientAdd", method = RequestMethod.GET)
    public ModelAndView clientAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clientEdit");
        return modelAndView;
    }

    /**
     * Saves existing client.
     * @param client - a Client that needs to be saved.
     * @return ModelAndView for the list of clients.
     */
    @RequestMapping(value = "/clientEdit", method = RequestMethod.POST)
    public ModelAndView clientEdit(@Valid @ModelAttribute("client") Client client, BindingResult result) {
        ModelAndView modelAndView;

        if (result.hasErrors()) {
            List<FieldError> errorsList = result.getFieldErrors();
            modelAndView = new ModelAndView("clientEdit");
            modelAndView.addObject("errors", errorsList);
            modelAndView.addObject("client", client);
        } else {
            ticketService.editClient(client);

            modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/clients");
        }

        return modelAndView;
    }

    /**
     * Saves new client.
     * @param client - a Client that needs to be added.
     * @return ModelAndView for the list of clients.
     */
    @RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
    public ModelAndView clientAdd(@Valid @ModelAttribute("client") Client client, BindingResult result) {
        ModelAndView modelAndView;

        if (result.hasErrors()) {
            List<FieldError> errorsList = result.getFieldErrors();
            modelAndView = new ModelAndView("redirect:/clientAdd");
            modelAndView.addObject("errors", errorsList);
            modelAndView.addObject("client", client);
        } else {
            ticketService.addClient(client);

            modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/clients");
        }

        return modelAndView;
    }

    /**
     * Deletes existing client.
     * @param id - ID of the client that needs to be deleted.
     * @return ModelAndView for the list of clients.
     */
    @RequestMapping(value = "/clientDelete/{id}", method = RequestMethod.GET)
    public ModelAndView clientDelete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/clients");
        Client client = ticketService.getClientById(id);
        ticketService.deleteClient(client);
        return modelAndView;
    }

    /**
     * @return ModelAndView for the list of tickets.
     */
    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public ModelAndView allTickets() {
        List<Ticket> tickets = ticketService.allTickets();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tickets");
        modelAndView.addObject("ticketsList", tickets);
        return modelAndView;
    }

    /**
     * @return ModelAndView for the page for editing new ticket.
     */
    @RequestMapping(value = "/ticketAdd", method = RequestMethod.GET)
    public ModelAndView ticketAddPage() {
        List<Client> clients = ticketService.allClients();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ticketEdit");
        modelAndView.addObject("clientsList", clients);
        return modelAndView;
    }

    /**
     * Saves new ticket.
     * @param ticket - a Ticket that needs to be added.
     * @return ModelAndView for the list of tickets.
     */
    @RequestMapping(value = "/ticketAdd", method = RequestMethod.POST)
    public ModelAndView ticketAdd(@Valid @ModelAttribute("ticket") Ticket ticket, BindingResult result) {
        ModelAndView modelAndView;

        if (result.hasErrors()) {
            List<FieldError> errorsList = result.getFieldErrors();
            modelAndView = new ModelAndView("redirect:/ticketAdd");
            modelAndView.addObject("errors", errorsList);
            modelAndView.addObject("ticket", ticket);
        } else {
            ticketService.addTicket(ticket);

            modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/tickets");
        }

        return modelAndView;
    }

    /**
     * Deletes existing ticket.
     * @param id - ID of the ticket that needs to be deleted.
     * @return ModelAndView for the list of tickets.
     */
    @RequestMapping(value = "/ticketDelete/{id}", method = RequestMethod.GET)
    public ModelAndView ticketDelete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/tickets");
        Ticket ticket = ticketService.getTicketById(id);
        ticketService.deleteTicket(ticket);
        return modelAndView;
    }
}
