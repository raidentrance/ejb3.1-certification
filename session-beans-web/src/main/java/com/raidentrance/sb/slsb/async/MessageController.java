/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.sb.slsb.async;

import com.raidentrance.session.beans.slsb.async.MessageProcessor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class MessageController {

    @EJB
    private MessageProcessor messageProcessor;

    public void executeHardWork() {
        messageProcessor.executeHardWork();
        showMessage("Result", "Hard work scheduled");
    }

    public void executeHardWorkAndGetResponse() throws InterruptedException, ExecutionException {
        Future<String> response = messageProcessor.executeHardWorkAndSendResponse();
        Future<String> response1 = messageProcessor.executeHardWorkAndSendResponse();
        System.out.println("Hard work scheduled");
        String result = response.get();
        String result1 = response1.get();
        showMessage("Result", result);
        showMessage("Result1", result1);
    }

    private void showMessage(String header, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(header, message));
    }

}
