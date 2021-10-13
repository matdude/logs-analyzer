package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Event;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class EventParser {

    public List<Event> parseEvents(String filePath) throws URISyntaxException, IOException {
        return Files.lines(Paths.get(ClassLoader.getSystemResource(filePath).toURI())).map(line -> {
            Event event = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                event = mapper.readValue(line, Event.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return event;
        }).collect(Collectors.toList());
    }
}
