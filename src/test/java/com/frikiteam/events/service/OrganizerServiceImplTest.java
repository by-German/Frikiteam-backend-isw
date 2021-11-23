package com.frikiteam.events.service;

import com.frikiteam.events.domain.model.Customer;
import com.frikiteam.events.domain.model.Organizer;
import com.frikiteam.events.domain.model.Ticket;
import com.frikiteam.events.domain.repositories.CustomerRepository;
import com.frikiteam.events.domain.repositories.OrganizerRepository;
import com.frikiteam.events.domain.service.OrganizerService;
import com.frikiteam.events.exception.ResourceNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class OrganizerServiceImplTest {
    @MockBean
    private OrganizerRepository organizerRepository;
    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private OrganizerService organizerService;

    @TestConfiguration
    static class OrganizerServiceTestConfiguration {
        @Bean
        public OrganizerService organizerService() {
            return new OrganizerServiceImpl();
        }
    }

    @Test
    public void whenGeOrganizerByIdWithValidIdThenReturnsOrganizer() {
        // Arrange
        long id = 1;
        Organizer organizer = new Organizer();
        organizer.setId(id);
        organizer.setFirstName("Alex");
        when(organizerRepository.findById(id)).thenReturn(Optional.of(organizer));

        // ACt
        Organizer foundOrganizer = organizerService.getOrganizerById(id);

        // Assert
        assertThat(foundOrganizer.getId()).isEqualTo(id);
    }

    @Test
    public void whenGeOrganizerByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        // Arrange
        long id = 1;
        String template = "Resource %s not found for %s with value %s";
        when(organizerRepository.findById(id))
                .thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Organizer", "id", id);

        // ACt
        Throwable exception = catchThrowable(() -> { // capturing exception
            Organizer foundOrganizer = organizerService.getOrganizerById(id);
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    public void whenDeleteOrganizerByIdWithInvalidIdThenReturnsResourceNotFoundException() {
        // Arrange
        long id = 1;
        String template = "Resource %s not found for %s with value %s";
        when(organizerRepository.findById(id)).thenReturn(Optional.empty());
        String expectedMessage = String.format(template, "Organizer", "id", id);

        // ACt
        Throwable exception = catchThrowable(() -> { // capturing exception
            ResponseEntity<?> result = organizerService.deleteOrganizer(id);
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    public void whenDeleteOrganizerByIdWithValidIdThenReturnsResponseEntityOk() {
        // Arrange
        long id = 1;
        Organizer organizer = new Organizer();
        organizer.setId(id);
        organizer.setFirstName("Alex");
        when(organizerRepository.findById(id)).thenReturn(Optional.of(organizer));

        // ACt
        ResponseEntity<?> result = organizerService.deleteOrganizer(id);

        // Assert
        assertThat(result).isEqualTo(ResponseEntity.ok().build());
    }

    @Test
    public void whenSaveCustomerWithValidOrganizerReturnsOrganizer() {
        // Arrange
        Organizer organizer = new Organizer();
        organizer.setId(1L);
        organizer.setFirstName("Alex");
        when(organizerRepository.save(organizer)).thenReturn(organizer);

        // ACt
        Organizer result = organizerService.saveOrganizer(organizer);

        // Assert
        assertThat(result).isEqualTo(organizer);
    }

    @Test
    public void whenUpdateOrganizerWithValidIdThenReturnsOrganizerUpdated() {
        // Arrange
        long id = 1;
        Organizer updateOrganizer = new Organizer();
        updateOrganizer.setId(id);
        updateOrganizer.setFirstName("Alex");

        Organizer oldOrganizer = new Organizer();
        oldOrganizer.setId(1L);
        oldOrganizer.setFirstName("Alexis");

        when(organizerRepository.findById(id)).thenReturn(Optional.of(oldOrganizer));
        when(organizerRepository.save(updateOrganizer)).thenReturn(updateOrganizer);

        // ACt
        Organizer organizer = organizerService.updateOrganizer(id, updateOrganizer);

        // Assert
        assertThat(organizer).isEqualTo(updateOrganizer);
    }

    @Test
    public void whenUpdateOrganizerWithInvalidIdThenReturnsResourceNotFoundException() {
        // Arrange
        long id = 1;
        Organizer newOrganizer = new Organizer();
        newOrganizer.setId(id);
        newOrganizer.setFirstName("Alex");
        Organizer oldOrganizer = new Organizer();
        oldOrganizer.setId(1L);
        oldOrganizer.setFirstName("Alexis");
        when(organizerRepository.findById(id)).thenReturn(Optional.empty());
        when(organizerRepository.save(newOrganizer)).thenReturn(newOrganizer);
        String expectedMessage = String.format("Resource %s not found for %s with value %s", "Organizer", "id", id);

        // Act
        Throwable exception = catchThrowable(() -> { // capturing exception
            Organizer organizer = organizerService.updateOrganizer(id, newOrganizer);
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    public void whenGetAllOrganizerThenReturnsOrganizers() {
        // Arrange
        List<Organizer> organizers = new ArrayList<>();
        when(organizerRepository.findAll()).thenReturn(organizers);

        // Act
        Page<Organizer> results = organizerService.getAllOrganizers(null);

        // Assert
        assertThat(results);
    }

    @Test
    public void whenGetAllByCustomerIdThenReturnsOrganizers() {
        long customerId = 1;
        Customer customer = new Customer();
        customer.setId(customerId);
        List<Organizer> organizers = new ArrayList<>();

        customer.setOrganizers(organizers);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        Page<Organizer> results = organizerService.getAllByCustomerId(customerId, Pageable.unpaged());

        assertThat(results);
    }

    @Test
    public void whenAssignCustomerThenReturnOrganizer() {
        long organizerId = 1;
        Organizer organizer = new Organizer();
        organizer.setId(organizerId);

        long customerId = 1;
        Customer customer = new Customer();
        customer.setId(customerId);

        when(organizerRepository.findById(organizerId)).thenReturn(Optional.of(organizer));
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn(customer);

        organizer = organizerService.assignCustomer(customerId, organizerId);

        assertThat(organizer);
    }

    @Test
    public void whenUnnassignCustomerThenReturnOrganizer() {
        long organizerId = 1;
        Organizer organizer = new Organizer();
        organizer.setId(organizerId);

        long customerId = 1;
        Customer customer = new Customer();
        customer.setId(customerId);

        when(organizerRepository.findById(organizerId)).thenReturn(Optional.of(organizer));
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn(customer);

        organizer = organizerService.assignCustomer(customerId, organizerId);

        assertThat(organizer);
    }
}