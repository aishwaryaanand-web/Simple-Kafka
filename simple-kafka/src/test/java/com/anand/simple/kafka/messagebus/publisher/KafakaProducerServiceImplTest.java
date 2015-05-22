package com.anand.simple.kafka.messagebus.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;

import com.anand.simple.kafka.messagebus.ProducerFactory;
import com.anand.simple.kafka.messagebus.publisher.KafakaProducerService;
import com.anand.simple.kafka.messagebus.publisher.KafakaProducerServiceImpl;
import com.anand.simple.kafka.messagebus.publisher.Producer;
import com.anand.simple.kafka.messagebus.serializer.SimpleJSONSerializer;
import com.anand.simple.kafka.messagebus.utils.KafkaConstants;

public class KafakaProducerServiceImplTest {

	public KafakaProducerServiceImplTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		getProducerTest_Simple();
		getProducerTest_WithProps();
		getProducerTest_WithSimpleJSONEncoder();
	}
	
	

	private static void getProducerTest_Simple() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		Producer<String> producer =kafakaProducerService.getProducer();
		producer.send("TestTopic1","100","First Message To Kafka");
	}
	
	private static void getProducerTest_WithProps() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		Properties prop=new Properties();
		prop.put(KafkaConstants.PARTITIONER_CLASS, "com.anand.simple.kafka.messagebus.partitoner.SimplePartitioner");
		Producer<String> producer =kafakaProducerService.getProducer(prop);
		producer.send("TestTopic","0","First Message To Kafka using partiotn");
	}
	
	private static void getProducerTest_WithPropsOne() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		
		Producer<String> producer =kafakaProducerService.getProducer();
		producer.send("TestTopic","First Message To Kafka");
	}
	
	
	private static void getProducerTest_WithPropsTwo() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		Producer<String> producer =kafakaProducerService.getProducer();
		producer.send("TestTopic","First Message To Kafka");
	}
	
	private static void getProducerTest_WithPropsThree() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		Producer<String> producer =kafakaProducerService.getProducer();
		producer.send("TestTopic","First Message To Kafka");
	}
	
	private static void getProducerTest_WithSimpleJSONEncoder() {
		KafakaProducerService kafakaProducerService =new KafakaProducerServiceImpl();
		Map<String,String> map=new HashMap<String,String>();
		map.put("Type", "Passing JSON object");
		map.put("Message", "Helllo My JSON");	
		Producer<JSONObject> producer =kafakaProducerService.getProducer(SimpleJSONSerializer.class);
		producer.send("TestTopic",new JSONObject(map));
	}
}
