package com.anand.simple.kafka.messagebus.publisher;

import java.util.List;
import java.util.Map;

/**
 * Producer of Type T, where T can be of any type given its encoder and decoder
 * are configured for same. Every producer have the capablity to send message of
 * Type T to a single or multiple topics on need basis.
 * 
 * @author Aishwarya Anand
 * @param <T>
 *            - Type T is message type that producer is entitled to send
 */
public interface Producer<T> {

	/**
	 * Sends message to a specific topic
	 * 
	 * @param topic
	 *            - Topic on which producer want to send message
	 * @param message
	 *            - message that producer wants to send
	 */
	public void send(String topic, T message);

	/**
	 * Sends message to a specific topic
	 * 
	 * @param topic
	 *            - Topic on which producer want to send message
	 * @param partionNum
	 *            - Partition on which we want to send data
	 * @param message
	 *            - message that producer wants to send
	 */
	public void send(String topic, String partionNum, T message);

	/**
	 * sends messages to multiple topics
	 * 
	 * @param messageToMultipTopic
	 *            - List of different topics and messages for that topic
	 */
	public void send(List<Map<String, T>> messageToMultipTopic);

	/**
	 * close the producer
	 */
	public void close();
}
