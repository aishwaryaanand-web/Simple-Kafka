package com.anand.simple.kafka.messagebus.consumer;

import java.util.concurrent.Callable;

import kafka.serializer.Decoder;

public class KafkaHighLevelConsumer implements KafkaHighLevelConsumerService {

	
	protected class HighLevelConsumer<T> implements Consumer<T>, Callable<T>{

		public T call() throws Exception {
			return null;
		}

		public T receive() {
			return null;
		}                            
		
	}

	public <T> Consumer<T> getHighLevelConsumer(String topic, Class<? extends Decoder<T>> clazz, boolean multithreaded) {
		return null;
	}

	public <T> Consumer<T> getHighLevelConsumer(String topic, Class<? extends Decoder<T>> clazz, int noOfConsumerThreads) {
		return null;
	}
	
}
