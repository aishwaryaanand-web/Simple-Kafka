package com.anand.simple.kafka.messagebus.partitoner;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

public class SimplePartitioner implements Partitioner {

	public SimplePartitioner(VerifiableProperties verProperties) {
	
	}

	public int partition(Object arg0, int arg1) {
		int partiton = 0;
		if (Integer.parseInt((String) arg0) > arg1) {
			partiton = Integer.parseInt((String) arg0) % arg1;
		} else {
			partiton = Integer.parseInt((String) arg0);
		}
		return partiton;
	}

}
