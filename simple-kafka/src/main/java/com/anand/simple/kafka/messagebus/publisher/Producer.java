package com.anand.simple.kafka.messagebus.publisher;

import java.util.List;
import java.util.Map;

public interface Producer<T> {

	  public void send(String topic, T message);

	  public void send(List<Map<String,T>> messageToMultipTopic);

	  public void close();
}
