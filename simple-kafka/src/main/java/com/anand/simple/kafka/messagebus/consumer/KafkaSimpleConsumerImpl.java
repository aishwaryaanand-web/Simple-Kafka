package com.anand.simple.kafka.messagebus.consumer;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import kafka.javaapi.PartitionMetadata;
import kafka.javaapi.TopicMetadata;
import kafka.javaapi.TopicMetadataRequest;
import kafka.javaapi.consumer.SimpleConsumer;


public class KafkaSimpleConsumerImpl{

	
	
	protected PartitionMetadata findLeader(String topic,int partition){
		PartitionMetadata returnMetaData=null;
		for (String seed : a_seedBrokers) {
            SimpleConsumer consumer = null;
            try {
                consumer = new SimpleConsumer(seed, a_port, 100000, 64 * 1024, "leaderLookup");
                List<String> topics = Collections.singletonList(topic);
                TopicMetadataRequest req = new TopicMetadataRequest(topics);
                kafka.javaapi.TopicMetadataResponse resp = consumer.send(req);

                List<TopicMetadata> metaData = resp.topicsMetadata();
                for (TopicMetadata item : metaData) {
                    for (PartitionMetadata part : item.partitionsMetadata()) {
                        if (part.partitionId() == partition) {
                            returnMetaData = part;
                            break loop;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error communicating with Broker [" + seed + "] to find Leader for [" + topic
                        + ", " + partition + "] Reason: " + e);
            } finally {
                if (consumer != null) consumer.close();
            }
        }
        return returnMetaData;
	}
	
	
	protected class KafkaSimpleConsumer<T> implements Consumer<T>, Callable<T>{

		public T call() throws Exception {
			return null;
		}

		public T receive() {
			return null;
		}
		
	}

}
