package com.anand.simple.kafka.messagebus.consumer;

import kafka.serializer.Decoder;

interface KafkaHighLevelConsumerService {

	<T> Consumer<T> getHighLevelConsumer(String topic,Class<? extends Decoder<T>> clazz, boolean multithreaded);
	
	<T> Consumer<T> getHighLevelConsumer(String topic,Class<? extends Decoder<T>> clazz, int noOfConsumerThreads);
	
}
