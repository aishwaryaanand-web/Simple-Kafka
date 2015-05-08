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
			if (isNotNullOrEmpty(props.getProperty(""))) {
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
		props.put(KakaConstants.BATCH_NUM_MESSAGES, "");
		props.put(KakaConstants.BATCH_SIZE, "");
		props.put(KakaConstants.BUFFER_SIZE, "102400");
		props.put(KakaConstants.CALLBACK_HANDLER, "");
		props.put(KakaConstants.CALLBACK_HANDLER_PROPS, "");
		props.put(KakaConstants.COMPRESSED_TOPICS, "");
		props.put(KakaConstants.COMPRESSION_CODEC, "none");
		props.put(KakaConstants.CONNECT_TIMEOUT_MS, "5000");
		props.put(KakaConstants.EVENT_HANDLER, "");
		props.put(KakaConstants.EVENT_HANDLER_PROPS, "");
		props.put(KakaConstants.MAX_MESSAGE_SIZE, "1000000");
		props.put(KakaConstants.METADATA_BROKER_LIST, "localhost:9092,localhost:9095");
		props.put(KakaConstants.PARTITIONER_CLASS, "");
		props.put(KakaConstants.PRODUCER_TYPE, "sync");
		props.put(KakaConstants.QUEUE_BUFFERING_MAX_MESSAGES, "");
		props.put(KakaConstants.QUEUE_BUFFERING_MAX_MS, "");
		props.put(KakaConstants.QUEUE_ENQUEUE_TIMEOUT_MS, "");
		props.put(KakaConstants.QUEUE_SIZE, "");
		props.put(KakaConstants.QUEUE_TIME, "");
		props.put(KakaConstants.RECONNECT_INTERVAL, "10 * 1000 * 1000");
		props.put(KakaConstants.SERIALIZER_CLASS, "kafka.serializer.StringEncoder");
		props.put(KakaConstants.SOCKET_TIMEOUT_MS, "30000");
		props.put(KakaConstants.ZK_CONNECT, "");
		props.put(KakaConstants.ZK_READ_NUM_RETRIES, "3");
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
