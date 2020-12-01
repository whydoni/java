package com.company.database;

import com.company.daos.UserDao;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class DBReceive {
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private UserDao UserDao;

    public DBReceive(EntityManager entityManager){
        this.entityManager = entityManager;
        UserDao = new UserDao(entityManager);
    }

    public void connectRabbitMQ() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void addMahasiswa() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("insertMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhs = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhs + "'");
                UserDao.persist(mhs);
            };
            channel.basicConsume("insertMahasiswa", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void updateMahasiswa() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("updateMahasiswaById", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhs = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhs + "'");
                UserDao.update(mhs);
            };
            channel.basicConsume("updateMahasiswaById", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void absensiMahasiswa() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("absensiMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idString + "'");
                UserDao.absen(idString);
            };
            channel.basicConsume("absensiMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
