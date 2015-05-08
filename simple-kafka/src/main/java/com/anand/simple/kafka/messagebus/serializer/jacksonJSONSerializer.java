package com.anand.simple.kafka.messagebus.serializer;

import java.io.IOException;
import java.util.Map;

import kafka.serializer.Decoder;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class jacksonJSONSerializer implements Encoder<Object>, Decoder<Object> {

	public jacksonJSONSerializer(VerifiableProperties verifiableProperties) {
		/* This constructor must be present for successful compile. */
	}

	public Object fromBytes(byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(bytes, Map.class);
        } catch (IOException e) {
            
        }
        return null;
    }
	
	public byte[] toBytes(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object).getBytes();
        } catch (JsonProcessingException e) {
           
        }
        return "".getBytes();
    }
}
