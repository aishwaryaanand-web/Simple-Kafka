package com.anand.simple.kafka.messagebus.publisher;

import java.util.List;
import java.util.Properties;

import kafka.serializer.Encoder;

/**
 * A wrapper Producer API for Apache Kafka Producer aims to simplify creation of
 * kafka producers that can send data of any type to kafka cluster
 * 
 * @author Aishwarya Anand
 */
public interface KafakaProducerService {

	/**
	 * creates a kafka producer to send String data to kafka cluster.Producer is
	 * configured with the default configuration specified in properties file.
	 * 
	 * @return Producer<String> - Kafka producer that can send String Objects to
	 *         kafka brokers
	 */
	Producer<String> getProducer();

	/**
	 * Provides a list kafka producer to send String data to kafka
	 * cluster.Producer is configured with the default configuration specified
	 * in properties file.
	 * 
	 * @param numOfProducer
	 *            - number of Producer to create
	 * @return List<Producer<String>> - list of producer as given in @param
	 */
	List<Producer<String>> getProducers(int numOfProducer);

	/**
	 * Created a kafka producer to send data of Type T to kafka cluster.Producer
	 * is configured with the default configuration specified in properties
	 * file.
	 * 
	 * @param clazz
	 *            - Encoder class for producer to send data of specific type as
	 *            given in Encoder
	 * @return <T> Producer<T> - Producer that can send data if type T
	 */
	<T> Producer<T> getProducer(Class<? extends Encoder<T>> clazz);

	/**
	 * Provides a list kafka producer to send data of Type T to kafka
	 * cluster.Producer is configured with the default configuration specified
	 * in properties file.
	 * 
	 * @param numOfProducer
	 *            - number of Producer to create
	 * @param clazz
	 *            - Encoder class for producer to send data of specific type as
	 *            given in Encoder
	 * @return <T> List<Producer<T>> - list of producer of Type T with respect
	 *         to @param
	 */
	<T> List<Producer<T>> getProducers(int numOfProducer, Class<? extends Encoder<T>> clazz);

	/**
	 * creates a kafka producer to send String data to kafka cluster.Producer is
	 * configured with given according to properties file of argument. If the
	 * required fields are not given in argument properties then remaning
	 * properties will be configured from default properties files.
	 * 
	 * @param producerProps
	 *            - properties to override the default properties of Producer
	 * @return Producer<String> - Kafka producer that can send String Objects to
	 *         kafka brokers
	 */
	Producer<String> getProducer(Properties producerProps);

	/**
	 * Provides a list kafka producer to send String data to kafka
	 * cluster.Producer is configured with given according to properties file of
	 * parameter. If the required fields are not given in argument properties
	 * then remaining properties will be configured from default properties
	 * files.
	 * 
	 * @param numOfProducer
	 *            - number of Producer to create
	 * @param producerProps
	 *            - properties to override the default properties of Producer
	 * @return List<Producer<String>> - list of producer as given in @param
	 */
	List<Producer<String>> getProducers(int numOfProducer, Properties producerProps);

	/**
	 * Created a kafka producer to send data of Type T to kafka cluster.Producer
	 * is configured with given according to properties file of argument. If the
	 * required fields are not given in argument properties then remaining
	 * properties will be configured from default properties files.
	 * 
	 * @param producerProps
	 *            - properties to override the default properties of Producer
	 * @param clazz
	 *            - Encoder class for producer to send data of specific type as
	 *            given in Encoder
	 * @return <T> Producer<T> - Producer that can send data if type T
	 */
	<T> Producer<T> getProducer(Properties producerProps, Class<? extends Encoder<T>> clazz);

	/**
	 * 
	 * Provides a list kafka producer to send data of Type T to kafka
	 * cluster.Producer is configured with given according to properties file of
	 * argument. If the required fields are not given in argument properties
	 * then remaining properties will be configured from default properties
	 * files.
	 * 
	 * @param numOfProducer
	 *            - number of Producer to create
	 * @param producerProps
	 *            - properties to override the default properties of Producer
	 * @param clazz
	 *            - Encoder class for producer to send data of specific type as
	 *            given in Encoder
	 * @return <T> List<Producer<T>> - list of producer of Type T with respect
	 *         to @param
	 */
	<T> List<Producer<T>> getProducers(int numOfProducer, Properties producerProps, Class<? extends Encoder<T>> clazz);

}
