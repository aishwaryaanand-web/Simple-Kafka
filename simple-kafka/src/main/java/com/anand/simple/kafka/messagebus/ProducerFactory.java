package com.anand.simple.kafka.messagebus;

import com.anand.simple.kafka.messagebus.publisher.KafakaProducerService;
import com.anand.simple.kafka.messagebus.publisher.KafakaProducerServiceImpl;

public class ProducerFactory {

	public static KafakaProducerService getProducerService(){
		return new KafakaProducerServiceImpl();
	}
}
