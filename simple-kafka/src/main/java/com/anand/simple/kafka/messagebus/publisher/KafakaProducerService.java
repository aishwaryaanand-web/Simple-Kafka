package com.anand.simple.kafka.messagebus.publisher;

import java.util.List;
import java.util.Properties;

import kafka.serializer.Encoder;

public interface KafakaProducerService {

	Producer<String> getProducer();
	
	Producer<String> getProducer(Properties producerProps);
	
	List<Producer<String>> getProducers(int numOfProducer);
	
	List<Producer<String>> getProducers(int numOfProducer,Properties producerProps);
	
	<T> List<Producer<T>> getProducers(int numOfProducer,Encoder<?> encoder);
	
	<T> List<Producer<T>> getProducers(int numOfProducer,Properties producerProps,Encoder<?> encoder);
	
	<T> Producer<T> getProducer(Properties producerProps,Encoder<?> encoder);
	
	<T> Producer<T> getProducer(Encoder<?> encoder);
	
}
