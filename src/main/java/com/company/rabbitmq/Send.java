package com.company.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Send {
    public void insertMhs(String smahasiswa) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("insertMahasiswa", false, false, false, null);
            channel.basicPublish("", "insertMahasiswa", null, smahasiswa.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sending '" + smahasiswa + "'");
        }
    }

    public void updateMhsById(String smahasiswa) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("updateMahasiswaById", false, false, false, null);
            channel.basicPublish("", "updateMahasiswaById", null, smahasiswa.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sending '" + smahasiswa + "'");
        }
    }

    public void absensiMhs(String smahasiswa) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("absensiMahasiswa", false, false, false, null);
            channel.basicPublish("", "absensiMahasiswa", null, smahasiswa.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sending '" + smahasiswa + "'");
        }
    }
}
