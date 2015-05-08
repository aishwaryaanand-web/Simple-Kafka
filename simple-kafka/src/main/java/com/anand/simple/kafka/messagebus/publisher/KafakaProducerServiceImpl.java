package com.anand.simple.kafka.messagebus.publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.anand.simple.kafka.messagebus.utils.KafKaUtils;

import kafka.serializer.Encoder;

public class KafakaProducerServiceImpl implements KafakaProducerService {

	public Producer<String> getProducer() {
		return new ProducerImpl<String, String>(KafKaUtils.getDefaultKafkaProperties());
	}

	public Producer<String> getProducer(Properties producerProps) {
		if(producerProps!=null){
			if(!KafKaUtils.hasPartitionClassInProps(producerProps)){
				return new ProducerImpl<String, String>(KafKaUtils.overideDefaultProdProp(producerProps));
			}else{
				
			}
		}
		return null;
	}

	public List<Producer<String>> getProducers(int numOfProducer) {
		List<Producer<String>> producerList=new ArrayList<Producer<String>>();
		if(numOfProducer>0){
			for (int i = 0; i < numOfProducer; i++) {
				producerList.add(getProducer());
			}
		}
		return producerList;
	}

	public List<Producer<String>> getProducers(int numOfProducer, Properties producerProps) {
		List<Producer<String>> producerList=new ArrayList<Producer<String>>();
		if(numOfProducer>0){
			for (int i = 0; i < numOfProducer; i++) {
				producerList.add(getProducer(producerProps));
			}
		}
		return producerList;
	}

	public <T> List<Producer<T>> getProducers(int numOfProducer, Encoder<?> encoder) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<Producer<T>> getProducers(int numOfProducer, Properties producerProps, Encoder<?> encoder) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Producer<T> getProducer(Properties producerProps, Encoder<?> encoder) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Producer<T> getProducer(Encoder<?> encoder) {
		// TODO Auto-generated method stub
		return null;
	}

}
