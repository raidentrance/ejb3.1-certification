/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.mdb.samples.queue;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
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

    public void sendTextMessage(ConnectionFactory connectionFactory, Queue queue, String messageData) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(queue);
        TextMessage txtMessage = session.createTextMessage();
        txtMessage.setText(messageData);
        producer.send(txtMessage);
    }

    public void sendTextMessage(ConnectionFactory connectionFactory, Topic topic, String messageData) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(
                false,
                Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(topic);
        TextMessage txtMessage = session.createTextMessage();
        txtMessage.setText(messageData);
        producer.send(txtMessage);
    }
}
