package com.anand.simple.kafka.messagebus.serializer;

import kafka.serializer.Decoder;
import kafka.serializer.Encoder;
import kafka.utils.VerifiableProperties;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class SimpleJSONSerializer implements Encoder<JSONObject>, Decoder<JSONObject> {

	public SimpleJSONSerializer(VerifiableProperties verifiableProperties) {
		/* This constructor must be present for successful compile. */
	}

	public JSONObject fromBytes(byte[] arg0) {
		Gson gson = new Gson();
		return gson.fromJson(new String(arg0), JSONObject.class);
	}

	public byte[] toBytes(JSONObject arg0) {
		Gson gson = new Gson();
		return gson.toJson(arg0).getBytes();
	}
}
