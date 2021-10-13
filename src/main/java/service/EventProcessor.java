package service;

import model.Event;
import model.ProcessedEvent;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventProcessor {

    public List<ProcessedEvent> process(List<Event> eventList) {
        Map<String, List<Event>> eventsById = eventList.stream().collect(Collectors.groupingBy(Event::getId));
        return eventsById.keySet().stream().map(id -> {
            List<Event> events = eventsById.get(id);
            long duration = Math.abs(events.get(0).getTimestamp() - events.get(1).getTimestamp());
            boolean alert = duration > 4;
            return new ProcessedEvent(id, duration, events.get(0).getType(), events.get(0).getHost(), alert);
        }).collect(Collectors.toList());
    }
}
