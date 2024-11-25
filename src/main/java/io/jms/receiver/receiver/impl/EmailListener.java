package io.jms.receiver.receiver.impl;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import io.jms.receiver.receiver.AbstractJmsBaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailListener extends AbstractJmsBaseListener {

	final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /* (非 Javadoc)
     * @see jp.ameba.jms.receiver.listener.AbstractJmsBaseListener#onMessage(javax.jms.Message)
     */
    @Override
    public void onMessage(Message mes) {
        if(mes instanceof ObjectMessage){
            ObjectMessage objMessage = (ObjectMessage) mes;
            try {
                @SuppressWarnings("unchecked")
				Map<String, String> map = (Map<String, String>)objMessage.getObject();

                // To send email
                String strEmailAddress = map.get("to_address");
                logger.info("email address >>> " + strEmailAddress);

            } catch (JMSException e) {
            	logger.error("invalid Object",e);
            }
        }
    }

}
