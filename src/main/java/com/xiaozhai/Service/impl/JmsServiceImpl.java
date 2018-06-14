package com.xiaozhai.Service.impl;

import com.xiaozhai.Service.JmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service
public class JmsServiceImpl implements JmsService {

    private static Logger logger = LoggerFactory.getLogger(JmsServiceImpl.class);

    @JmsListener(destination = "springboot")
    @Override
    public void consumer(Message message) {
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                String text = textMessage.getText();
                logger.info("处理逻辑，"+text);
            } catch (JMSException e) {
                logger.error(e.getMessage());
            }
        }else{
            logger.error("消息类型不匹配");
        }
    }
}
