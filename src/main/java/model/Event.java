package model;

import java.util.Objects;

public class Event {

    private String id;
    private String state;
    private String type;
    private String host;
    private Long timestamp;

    public Event() {
    }

    public Event(String id, String state, String type, String host, Long timestamp) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) && state.equals(event.state) && Objects.equals(type, event.type) && Objects.equals(host, event.host) && timestamp.equals(event.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, type, host, timestamp);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
