package com.example.demo;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class SmsProcessor {

    private final DataSource dataSource;

    public SmsProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void storeSmsData(String toNumber, String fromNumber, String message) {
        try (Connection connection = dataSource.getConnection()) {
            String insertQuery = "INSERT INTO sms_records (to_number, from_number, message, timestamp) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, toNumber);
                preparedStatement.setString(2, fromNumber);
                preparedStatement.setString(3, message);

                // Set the timestamp to the current time
                Timestamp timestamp = new Timestamp(new Date().getTime());
                preparedStatement.setTimestamp(4, timestamp);

                preparedStatement.executeUpdate();

                System.out.println("SMS record inserted into the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}