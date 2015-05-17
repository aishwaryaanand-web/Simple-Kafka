package com.anand.simple.kafka.messagebus.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ProducerImpl<K, T> implements Producer<T> {

	kafka.javaapi.producer.Producer<K, T> producer;
	ProducerConfig config = null;

	public ProducerImpl(Properties props) {
		if (props != null) {
			this.config = new ProducerConfig(props);
			producer = new kafka.javaapi.producer.Producer<K, T>(config);
		}
	}

	public void send(String topic, T message) {
		this.producer.send(new KeyedMessage<K, T>(topic, message));
	}

	
	@SuppressWarnings("unchecked")
	public  void send(String topic, String partionNum, T message) {
		this.producer.send(new KeyedMessage<K, T>(topic, (K) partionNum, message));
	}

	public void send(List<Map<String, T>> messageToMultipTopic) {
		if (messageToMultipTopic != null) {
			List<KeyedMessage<K, T>> msgList = new ArrayList<KeyedMessage<K, T>>();
			for (Map<String, T> map : messageToMultipTopic) {
				for (Map.Entry<String, T> entry : map.entrySet()) {
					msgList.add(new KeyedMessage<K, T>(entry.getKey(), entry.getValue()));
				}
			}
			this.producer.send(msgList);
		}

	}

	public void close() {
		this.producer.close();
	}

}
