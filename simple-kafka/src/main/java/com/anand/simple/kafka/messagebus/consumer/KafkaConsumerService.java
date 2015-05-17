package com.anand.simple.kafka.messagebus.consumer;

import java.util.List;
import java.util.Properties;

import kafka.serializer.Decoder;

public interface KafkaConsumerService {

	<T> Consumer<T> getConsumerForLatestData(Class<? extends Decoder<T>> clazz);

	<T> Consumer<T> getConsumerForLatestData(Class<? extends Decoder<T>> clazz, Properties prop);

	<T> List<Consumer<T>> getConsumersForLatestData(Class<? extends Decoder<T>> clazz);

	<T> List<Consumer<T>> getConsumersForLatestData(Class<? extends Decoder<T>> clazz, Properties prop);

	<T> Consumer<T> getConsumerForOldestData(Class<? extends Decoder<T>> clazz);

	<T> Consumer<T> getConsumerForOldestData(Class<? extends Decoder<T>> clazz, Properties prop);

	<T> List<Consumer<T>> getConsumersForOldestData(Class<? extends Decoder<T>> clazz);

	<T> List<Consumer<T>> getConsumersForOldestData(Class<? extends Decoder<T>> clazz, Properties prop);
	
}
