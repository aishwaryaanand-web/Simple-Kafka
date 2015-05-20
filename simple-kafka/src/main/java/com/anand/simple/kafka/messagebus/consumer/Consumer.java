package com.anand.simple.kafka.messagebus.consumer;
/**
 * Consumer that can consume message of Type T from Apache Kafka, Message Type T will be decided by decoder 
 * for consumer.
 * 
 * @author Aishwarya Anand
 * @param <T>
 *            - Type T is message type that Consumer will receive
 */
public interface Consumer<T> {

	/**
	 * Consumes message of a specific Type
	 * 
	 * @return  T
	 *            - Type T is message type that Consumer will consume from
	 * 		Apache Kafka
	 */
	T receive();
}
