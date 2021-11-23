package com.frikiteam.events.service;

import com.frikiteam.events.domain.model.Event;
import com.frikiteam.events.domain.model.Itinerary;
import com.frikiteam.events.domain.repositories.EventRepository;
import com.frikiteam.events.domain.repositories.ItineraryRepository;
import com.frikiteam.events.domain.service.ItineraryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ItineraryServiceImplTest {
    @MockBean
    private ItineraryRepository itineraryRepository;
    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private ItineraryService itineraryService;

    @TestConfiguration
    static class ItineraryServiceTestConfiguration {
        @Bean
        public ItineraryService itineraryService() {
            return new ItineraryServiceImpl();
        }
    }

    @Test
    public void whenGetAllItineraryByIdWithValidIdThenReturnsItineraries() {
        // Arrange
        long id = 1;

        List<Itinerary> expected = new ArrayList<>();
        Itinerary itinerary = new Itinerary();
        itinerary.setId(id);
        itinerary.setName("Itinerary 1");
        expected.add(itinerary);
        Event event = new Event();
        event.setId(1L);
        event.setItineraries(expected);

        when(eventRepository.findById(id)).thenReturn(Optional.of(event));

        // ACt
        List<Itinerary> itineraries = itineraryService.getAllByEventId(1L);
        System.out.println(itineraries.get(0).getName());

        // Assert
        assertThat(!itineraries.isEmpty());
    }

    @Test
    public void whenCreateItineraryThenReturnsItinerary() {
        Itinerary itinerary = new Itinerary();
        itinerary.setName("itinerary");
        Event event = new Event();

        when(itineraryRepository.save(itinerary)).thenReturn(itinerary);
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        Itinerary create = itineraryService.createItinerary(1L, itinerary);

        assertThat(create);
    }

    @Test
    public void whenUpdateItineraryThenReturnsItinerary() {
        Itinerary itinerary = new Itinerary();
        itinerary.setName("itinerary");

        when(itineraryRepository.findById(1L)).thenReturn(Optional.of(itinerary));
        when(itineraryRepository.save(itinerary)).thenReturn(itinerary);

        Itinerary update = itineraryService.update(1L, itinerary);

        assertThat(update);
    }

    @Test
    public void whenDeleteItineraryThenReturnsItinerary() {
        Itinerary itinerary = new Itinerary();
        itinerary.setId(1L);
        itinerary.setName("itinerary");

        when(itineraryRepository.findById(1L)).thenReturn(Optional.of(itinerary));
        itineraryService.delete(1L);
    }

}
