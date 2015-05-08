package com.anand.simple.kafka.messagebus.publisher;

import com.anand.simple.kafka.messagebus.publisher.KafakaProducerService;
import com.anand.simple.kafka.messagebus.publisher.KafakaProducerServiceImpl;
import com.anand.simple.kafka.messagebus.publisher.Producer;

public class KafakaProducerServiceImplTest {

	public KafakaProducerServiceImplTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		getProducerTest_Simple();
	}

	private static void getProducerTest_Simple() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		Producer<String> producer =kafakaProducerService.getProducer();
		producer.send("TestTopic","First Message To Kafka");
	}
}
