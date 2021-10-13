package service;

import model.Event;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

public class EventParserTest {

    @Test
    public void parsingTest() throws IOException, URISyntaxException {
        String filePath = "testFile.txt";

        List<Event> parser = new EventParser().parseEvents(filePath);

        assertEquals(6, parser.size());
    }
}