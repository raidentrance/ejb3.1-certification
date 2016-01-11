/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.mdb.samples.queue;

import com.raidentrance.mdb.samples.queue.util.MessageHelper;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class EmailSenderController {

    @Resource(mappedName = "jms/emailQueue")
    private Queue emailQueue;

    @Resource(lookup = "jms/emailQueueConnecionFactory")
    private ConnectionFactory connectionFactory;

    @ManagedProperty("#{messageHelper}")
    private MessageHelper messageHelper;

    private String message;

    public void sendMessage() throws JMSException {
        messageHelper.sendMessage(connectionFactory, emailQueue, message);
        showMessage("Result", "Message has been delivered");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void showMessage(String header, String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(header, message));
    }

    public MessageHelper getMessageHelper() {
        return messageHelper;
    }

    public void setMessageHelper(MessageHelper messageHelper) {
        this.messageHelper = messageHelper;
    }

}
