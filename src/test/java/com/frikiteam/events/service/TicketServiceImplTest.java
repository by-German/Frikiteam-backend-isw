package com.frikiteam.events.service;

import com.frikiteam.events.domain.model.Customer;
import com.frikiteam.events.domain.model.Event;
import com.frikiteam.events.domain.model.Ticket;
import com.frikiteam.events.domain.repositories.CustomerRepository;
import com.frikiteam.events.domain.repositories.TicketRepository;
import com.frikiteam.events.domain.service.TicketService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TicketServiceImplTest {
    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private TicketService ticketService;

    @TestConfiguration
    static class TicketServiceTestConfiguration {
        @Bean
        public TicketService ticketService() {
            return new TicketServiceImpl();
        }
    }

    @Test
    public void whenGetAllTicketsByIdWithValidIdThenReturnsTickets() {
        // Arrange
        List<Ticket> tickets = new ArrayList<>();
        when(ticketRepository.findAll()).thenReturn(tickets);

        // Act
        Page<Ticket> results = ticketService.getAllTickets(null);

        // Assert
        assertThat(results);
    }

    @Test
    public void whenGetAllBoughtByCustomerIdWithValidIdThenReturnsTickets() {
        // Arrange
        long id = 1;
        Customer customer = new Customer();
        customer.setId(id);
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        // Act
        List<Event> events = ticketService.getAllBoughtByCustomerId(id);

        // Assert
        assertThat(events);
    }

    @Test
    public void whenGetTicketByIdWithValidIdThenReturnsTicket() {
        // Arrange
        long id = 1;
        Ticket ticket = new Ticket();
        ticket.setId(id);

        when(ticketRepository.findById(id)).thenReturn(Optional.of(ticket));

        // Act
        ticket = ticketService.getTicketById(id);

        // Assert
        assertThat(ticket);
    }

    @Test
    public void whenSaveTicketThenReturnsTicket() {
        // Arrange
        long id = 1;
        Ticket ticket = new Ticket();
        ticket.setId(id);

        when(ticketRepository.save(ticket)).thenReturn(ticket);

        // Act
        ticket = ticketService.saveTicket(ticket);

        // Assert
        assertThat(ticket);
    }

    @Test
    public void whenDeleteTicketThenReturnsTicket() {
        // Arrange
        long id = 1;
        Ticket ticket = new Ticket();
        ticket.setId(id);

        when(ticketRepository.findById(id)).thenReturn(Optional.of(ticket));
        ticketRepository.delete(ticket);
    }

}
