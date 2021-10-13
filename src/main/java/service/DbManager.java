package service;

import model.ProcessedEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DbManager {

    private static String jdbcURL = "jdbc:hsqldb:hsql://localhost/logsdb";
    private static String jdbcUsername = "SA";
    private static String jdbcPassword = "";

    private static final String INSERT_EVENTS = "INSERT INTO ProcessedEvents" +
            "  (id, duration, type, host, alert) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ProcessedEvents (\n" +
            "\tid varchar(255),\n" +
            "\tduration bigint,\n" +
            "\ttype varchar(255),\n" +
            "\thost varchar(255),\n" +
            "\talert boolean\n" +
            ");";

    public void insertEvents(List<ProcessedEvent> processedEventList)  {

        try (
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement createTableStatement = connection.prepareStatement(CREATE_TABLE);
            PreparedStatement insertEventStatement = connection.prepareStatement(INSERT_EVENTS)) {

            createTableStatement.executeUpdate();

            for (ProcessedEvent processedEvent : processedEventList) {
                insertEventStatement.setString(1, processedEvent.getId());
                insertEventStatement.setLong(2, processedEvent.getDuration());
                insertEventStatement.setString(3, processedEvent.getType());
                insertEventStatement.setString(4, processedEvent.getHost());
                insertEventStatement.setBoolean(5, processedEvent.isAlert());
                insertEventStatement.executeUpdate();
            };

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
