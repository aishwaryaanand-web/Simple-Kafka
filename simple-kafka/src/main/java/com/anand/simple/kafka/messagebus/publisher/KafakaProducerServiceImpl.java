package com.anand.simple.kafka.messagebus.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kafka.serializer.Encoder;

import com.anand.simple.kafka.messagebus.utils.KafKaUtils;
import com.anand.simple.kafka.messagebus.utils.KafkaConstants;

public class KafakaProducerServiceImpl implements KafakaProducerService {

	public Producer<String> getProducer() {
		return new ProducerImpl<String, String>(KafKaUtils.getDefaultKafkaProperties());
	}

	public Producer<String> getProducer(Properties producerProps) {
		if (producerProps != null) {
			if (!KafKaUtils.hasPartitionClassInProps(producerProps)) {
				return new ProducerImpl<String, String>(KafKaUtils.overideDefaultProdProp(producerProps));
			} else {

			}
		}
		return null;
	}

	public List<Producer<String>> getProducers(int numOfProducer) {
		List<Producer<String>> producerList = new ArrayList<Producer<String>>();
		if (numOfProducer > 0) {
			for (int i = 0; i < numOfProducer; i++) {
				producerList.add(getProducer());
			}
		}
		return producerList;
	}

	public List<Producer<String>> getProducers(int numOfProducer, Properties producerProps) {
		List<Producer<String>> producerList = new ArrayList<Producer<String>>();
		if (numOfProducer > 0) {
			for (int i = 0; i < numOfProducer; i++) {
				producerList.add(getProducer(producerProps));
			}
		}
		return producerList;
	}

	public <T> Producer<T> getProducer(Class<? extends Encoder<T>> clazz) {
		Producer<T> propducer = null;
		if (clazz != null && !clazz.isInterface()) {
			Properties configProp = KafKaUtils.getDefaultKafkaProperties();
			configProp.put(KafkaConstants.SERIALIZER_CLASS, clazz.getCanonicalName());
			propducer = new ProducerImpl<String, T>(configProp);
		}
		return propducer;
	}

	public <T> List<Producer<T>> getProducers(int numOfProducer, Class<? extends Encoder<T>> clazz) {
		List<Producer<T>> producerList = new ArrayList<Producer<T>>();
		if (numOfProducer > 0) {
			for (int i = 0; i < numOfProducer; i++) {
				producerList.add(getProducer(clazz));
			}
		}
		return producerList;
	}

	public <T> List<Producer<T>> getProducers(int numOfProducer, Properties producerProps,
			Class<? extends Encoder<T>> clazz) {
		List<Producer<T>> producerList = new ArrayList<Producer<T>>();
		if (numOfProducer > 0) {
			for (int i = 0; i < numOfProducer; i++) {
				producerList.add(getProducer(producerProps, clazz));
			}
		}
		return producerList;
	}

	public <T> Producer<T> getProducer(Properties producerProps, Class<? extends Encoder<T>> clazz) {
		Producer<T> producer = null;
		if (producerProps != null && clazz != null && !clazz.isInterface()) {
			if (!KafKaUtils.hasPartitionClassInProps(producerProps)) {
				Properties configProp = KafKaUtils.overideDefaultProdProp(producerProps);
				configProp.put(KafkaConstants.SERIALIZER_CLASS, clazz.getCanonicalName());
				producer = new ProducerImpl<String, T>(configProp);
			} else {

			}
		}
		return producer;
	}

}
