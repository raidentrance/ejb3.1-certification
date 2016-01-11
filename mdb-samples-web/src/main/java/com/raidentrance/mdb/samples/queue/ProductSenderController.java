/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidentrance.mdb.samples.queue;

import com.raidentrance.mdb.samples.model.ProductMessage;
import com.raidentrance.mdb.samples.queue.util.MessageHelper;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.jms.BytesMessage;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

/**
 *
 * @author alejandrobautista
 */
@ManagedBean
@RequestScoped
public class ProductSenderController {

    private ProductMessage productMessage;

    @Resource(mappedName = "jms/productQueue")
    private Queue productQueue;

    @Resource(lookup = "jms/productQueueConnectionFactory")
    private ConnectionFactory connectionFactory;

    @ManagedProperty("#{messageHelper}")
    private MessageHelper messageHelper;

    @PostConstruct
    public void init() {
        productMessage = new ProductMessage();
    }

    public void sendMessage() throws JMSException {
        BytesMessage message = messageHelper.getByteMessage(connectionFactory, productQueue);
        message.writeInt(productMessage.getProductNumber());
        message.writeDouble(productMessage.getWeight());
        message.writeInt(productMessage.getQuantity());
        message.writeDouble(productMessage.getPrice());
        messageHelper.sendMessage(connectionFactory, productQueue, message);
        showMessage("Result", "Message has been delivered");
    }

    public ProductMessage getProductMessage() {
        return productMessage;
    }

    public void setProductMessage(ProductMessage productMessage) {
        this.productMessage = productMessage;
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
