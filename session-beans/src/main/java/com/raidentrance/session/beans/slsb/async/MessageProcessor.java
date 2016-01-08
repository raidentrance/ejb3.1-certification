/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.session.beans.slsb.async;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author alejandrobautista
 */
@Stateless
public class MessageProcessor {

    @Asynchronous
    public void executeHardWork() {
        try {
            System.out.println("Executing hard work");
            Thread.sleep(5000);
            System.out.println("Ending hard work");
        } catch (InterruptedException ex) {
            Logger.getLogger(MessageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Asynchronous
    public Future<String> executeHardWorkAndSendResponse() {
        try {
            System.out.println("Executing hard work");
            Thread.sleep(5000);
            System.out.println("Ending hard work");
        } catch (InterruptedException ex) {
            Logger.getLogger(MessageProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new AsyncResult<>("OK");
    }
}
