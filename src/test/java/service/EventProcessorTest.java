package service;

import model.Event;
import model.ProcessedEvent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class EventProcessorTest {

    @Test
    public void processTest() {
        List<Event> events = new ArrayList<Event>() {
            {
                add(new Event("id1", "state1", "type1", "host1", 1L));
                add(new Event("id1", "state2", "type1", "host1", 3L));
                add(new Event("id2", "state1", null, null, 4L));
                add(new Event("id2", "state2", null, null, 10L));
            }
        };

        List<ProcessedEvent> processedEvents = new EventProcessor().process(events);

        assertEquals(2, processedEvents.size());
        assertThat(processedEvents).containsOnly(new ProcessedEvent("id1", 2L, "type1", "host1", false), new ProcessedEvent("id2", 6L, null, null, true));
    }
}