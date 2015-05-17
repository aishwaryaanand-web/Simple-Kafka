package com.anand.simple.kafka.messagebus.consumer;

public interface Consumer<T> {

	T receive();
}
