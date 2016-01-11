/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.mdb.samples.queue.util;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@SessionScoped
public class MessageHelper {

    public void sendMessage(ConnectionFactory connectionFactory, Queue queue, String messageData) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        TextMessage txtMessage = session.createTextMessage();
        txtMessage.setText(messageData);
        producer.send(txtMessage);
    }

    public void sendMessage(ConnectionFactory connectionFactory, Topic topic, String messageData) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(topic);
        TextMessage txtMessage = session.createTextMessage();
        txtMessage.setText(messageData);
        producer.send(txtMessage);
    }

    public void sendMessage(ConnectionFactory connectionFactory, Queue queue, Serializable messageData) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        ObjectMessage objectMessage = session.createObjectMessage();
        objectMessage.setObject(messageData);
        producer.send(objectMessage);
    }

    public void sendMessage(ConnectionFactory connectionFactory, Topic topic, Serializable messageData) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(topic);
        ObjectMessage objectMessage = session.createObjectMessage();
        objectMessage.setObject(messageData);
        producer.send(objectMessage);
    }

    public void sendMessage(ConnectionFactory connectionFactory, Queue queue, BytesMessage message) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        producer.send(message);
    }

    public BytesMessage getByteMessage(ConnectionFactory connectionFactory, Queue queue) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        return session.createBytesMessage();
    }
}
