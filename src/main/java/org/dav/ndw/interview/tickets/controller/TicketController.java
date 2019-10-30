package org.dav.ndw.interview.tickets.controller;

import org.dav.ndw.interview.tickets.model.Client;
import org.dav.ndw.interview.tickets.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TicketController {
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * @return ModelAndView for the list of clients.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allClients() {
        List<Client> clients = clientService.allClients();

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
        Client client = clientService.getById(id);
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
    public ModelAndView clientEdit(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");  //redirect:clients ?
        clientService.edit(client);
        return modelAndView;
    }

    /**
     * Saves new client.
     * @param client - a Client that needs to be added.
     * @return ModelAndView for the list of clients.
     */
    @RequestMapping(value = "/clientAdd", method = RequestMethod.POST)
    public ModelAndView clientAdd(@ModelAttribute("client") Client client) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");  //redirect:clients ?
        clientService.add(client);
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
        modelAndView.setViewName("redirect:/");  //redirect:clients ?
        Client client = clientService.getById(id);
        clientService.delete(client);
        return modelAndView;
    }
}
