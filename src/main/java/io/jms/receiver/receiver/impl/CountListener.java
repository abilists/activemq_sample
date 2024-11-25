package io.jms.receiver.receiver.impl;

import io.jms.receiver.entities.bean.CountBean;
import io.jms.receiver.receiver.AbstractJmsBaseListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountListener extends AbstractJmsBaseListener {

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /* (非 Javadoc)
     * @see jp.ameba.jms.receiver.listener.AbstractJmsBaseListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage(Message mes) {
        if(mes instanceof ObjectMessage){
            ObjectMessage objMessage = (ObjectMessage) mes;
            try {
                CountBean bean = (CountBean) objMessage.getObject();
                logger.info("receive object ID:" + bean.getCount());
            } catch (JMSException e) {
            	logger.error("invalid Object",e);
            }
        }
    }

}