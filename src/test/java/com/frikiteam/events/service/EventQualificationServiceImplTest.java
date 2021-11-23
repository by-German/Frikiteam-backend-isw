package com.frikiteam.events.service;

import com.frikiteam.events.domain.model.Event;
import com.frikiteam.events.domain.model.EventQualification;
import com.frikiteam.events.domain.repositories.EventQualificationRepository;
import com.frikiteam.events.domain.repositories.EventRepository;
import com.frikiteam.events.domain.service.EventQualificationService;
import com.frikiteam.events.domain.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EventQualificationServiceImplTest {
    @MockBean
    private EventQualificationRepository eventQualificationRepository;
    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private EventQualificationService eventQualificationService;

    @TestConfiguration
    static class EventQualificationTestConfiguration {
        @Bean
        public EventQualificationService eventQualification() {
            return new EventQualificationServiceImpl();
        }
    }

    @Test
    public void whenSaveEventQualificationReturnEventQualification() {
        long eventId = 1;
        Event event = new Event();
        EventQualification qualification = new EventQualification();

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));
        when(eventQualificationRepository.save(qualification)).thenReturn(qualification);

        EventQualification actual = eventQualificationService.saveEventQualification(eventId, qualification);

        assertThat(actual).isEqualTo(qualification);
    }

    @Test
    public void whenDeleteEventQualificationReturnEventQualification() {
        long eventId = 1;
        Event event = new Event();
        EventQualification qualification = new EventQualification();
        qualification.setId(eventId);

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));
        when(eventQualificationRepository.findById(eventId)).thenReturn(Optional.of(qualification));

        ResponseEntity<?> result = eventQualificationService.deleteEventQualification(qualification.getId());

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void whenGetEventQualificationByEventID() {
        long eventId = 1;
        Event event = new Event();

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(event));

        List<EventQualification> qualifications = eventQualificationService.getEventQualificationByEventId(eventId);

        assertThat(qualifications).isEqualTo(event.getEventQualifications());
    }

}
