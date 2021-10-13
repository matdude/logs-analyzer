package application;

import model.Event;
import model.ProcessedEvent;
import service.DbManager;
import service.EventParser;
import service.EventProcessor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public class LogsApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {

        List<Event> eventList = new EventParser().parseEvents(args[0]);
        List<ProcessedEvent> processedEvents = new EventProcessor().process(eventList);
        new DbManager().insertEvents(processedEvents);
    }
}
