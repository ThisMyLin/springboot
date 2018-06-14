package com.xiaozhai.Service;

import javax.jms.Message;

public interface JmsService {

    public void consumer(Message message);
}
