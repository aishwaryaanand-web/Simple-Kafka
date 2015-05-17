package com.anand.simple.kafka.messagebus.utils;

import java.util.Enumeration;
import java.util.Properties;

public class KafKaUtils {

	public static Properties getDefaultKafkaProperties() {
		Properties props = filterNullOrEmptyProps(createTempPropducerProps());
		System.out.println(props);
		return props;
	}

	public static Properties overideDefaultProdProp(Properties props) {
		Properties overridenProps;
		if (props != null) {
			overridenProps = getDefaultKafkaProperties();
		} else {
			overridenProps = new Properties();
		}
		return overridenProps;
	}

	public static boolean hasPartitionClassInProps(Properties props) {
		boolean hasPartition = false;
		if (props != null) {
			if (isNotNullOrEmpty(props.getProperty(KafkaConstants.PARTITIONER_CLASS))) {
				hasPartition = true;
			}
		}
		return hasPartition;
	}

	public static boolean isNotNullOrEmpty(String value) {
		boolean emptyOrNull = false;
		if (value != null && !value.isEmpty()) {
			emptyOrNull = true;
		}
		return emptyOrNull;
	}

	private static Properties createTempPropducerProps() {
		Properties props = new Properties();
		props.put(KafkaConstants.BATCH_NUM_MESSAGES, "");
		props.put(KafkaConstants.BATCH_SIZE, "");
		props.put(KafkaConstants.BUFFER_SIZE, "102400");
		props.put(KafkaConstants.CALLBACK_HANDLER, "");
		props.put(KafkaConstants.CALLBACK_HANDLER_PROPS, "");
		props.put(KafkaConstants.COMPRESSED_TOPICS, "");
		props.put(KafkaConstants.COMPRESSION_CODEC, "none");
		props.put(KafkaConstants.CONNECT_TIMEOUT_MS, "5000");
		props.put(KafkaConstants.EVENT_HANDLER, "");
		props.put(KafkaConstants.EVENT_HANDLER_PROPS, "");
		props.put(KafkaConstants.MAX_MESSAGE_SIZE, "1000000");
		props.put(KafkaConstants.METADATA_BROKER_LIST, "localhost:9093,localhost:9095");
		props.put(KafkaConstants.PARTITIONER_CLASS, "");
		props.put(KafkaConstants.PRODUCER_TYPE, "sync");
		props.put(KafkaConstants.QUEUE_BUFFERING_MAX_MESSAGES, "");
		props.put(KafkaConstants.QUEUE_BUFFERING_MAX_MS, "");
		props.put(KafkaConstants.QUEUE_ENQUEUE_TIMEOUT_MS, "");
		props.put(KafkaConstants.QUEUE_SIZE, "");
		props.put(KafkaConstants.QUEUE_TIME, "");
		props.put(KafkaConstants.RECONNECT_INTERVAL, "10 * 1000 * 1000");
		props.put(KafkaConstants.SERIALIZER_CLASS, "kafka.serializer.StringEncoder");
		props.put(KafkaConstants.SOCKET_TIMEOUT_MS, "30000");
		props.put(KafkaConstants.ZK_CONNECT, "");
		props.put(KafkaConstants.ZK_READ_NUM_RETRIES, "3");
		return props;
	}

	public static Properties filterNullOrEmptyProps(Properties props) {
		Properties properties = new Properties();
		Enumeration e = props.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			System.out.println(key + " -- " + props.getProperty(key));
			if (isNotNullOrEmpty(props.getProperty(key))) {
				properties.put(key, props.getProperty(key));
			}
		}
		return properties;
	}
}
