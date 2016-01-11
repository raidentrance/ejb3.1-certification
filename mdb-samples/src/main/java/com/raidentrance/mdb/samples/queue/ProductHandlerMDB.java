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
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author alejandrobautista
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/productQueue"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ProductHandlerMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        BytesMessage bytesMessage = (BytesMessage) message;
        try {
            System.out.println("Product number: " + bytesMessage.readInt());
            System.out.println("Weight: " + bytesMessage.readDouble());
            System.out.println("Quantity: " + bytesMessage.readInt());
            System.out.println("Price: " + bytesMessage.readDouble());
        } catch (JMSException ex) {
            Logger.getLogger(ProductHandlerMDB.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}
