package com.anand.simple.kafka.messagebus.utils;

public interface KafkaPropducerConstant {

	String METADATA_BROKER_LIST = "metadata.broker.list";
	String PARTITIONER_CLASS = "partitioner.class";
	String PRODUCER_TYPE = "producer.type";
	String COMPRESSION_CODEC = "compression.codec";
	String SERIALIZER_CLASS = "serializer.class";
	String COMPRESSED_TOPICS = "compressed.topics";
	String ZK_CONNECT = "zk.connect";
	String BUFFER_SIZE = "buffer.size";
	String CONNECT_TIMEOUT_MS = "connect.timeout.ms";
	String SOCKET_TIMEOUT_MS = "socket.timeout.ms";
	String RECONNECT_INTERVAL = "reconnect.interval";
	String RECONNECT_TIME_INTERVAL_MS = "reconnect.time.interval.ms";
	String MAX_MESSAGE_SIZE = "max.message.size";
	String ZK_READ_NUM_RETRIES = "zk.read.num.retries";
	String QUEUE_BUFFERING_MAX_MS = "queue.buffering.max.ms";
	String QUEUE_BUFFERING_MAX_MESSAGES = "queue.buffering.max.messages";
	String QUEUE_ENQUEUE_TIMEOUT_MS = "queue.enqueue.timeout.ms";
	String BATCH_NUM_MESSAGES = "batch.num.messages";
	String QUEUE_TIME = "queue.time";
	String QUEUE_SIZE = "queue.size";
	String BATCH_SIZE = "batch.size";
	String EVENT_HANDLER = "event.handler";
	String EVENT_HANDLER_PROPS = "event.handler.props";
	String CALLBACK_HANDLER = "callback.handler";
	String CALLBACK_HANDLER_PROPS = "callback.handler.props";

}
