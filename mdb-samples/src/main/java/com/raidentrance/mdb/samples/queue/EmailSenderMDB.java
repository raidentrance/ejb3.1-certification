/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.mdb.samples.queue;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author alejandrobautista
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/emailQueue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class EmailSenderMDB implements MessageListener {
    
    public EmailSenderMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage messageTxt=(TextMessage)message;
            System.out.println("Message received : "+messageTxt.getText());
        } catch (JMSException ex) {
            Logger.getLogger(EmailSenderMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
