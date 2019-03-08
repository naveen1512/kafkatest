package com.games24x7.kafka;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class MyEmployeeListSerializer implements Serializer<MyEmployeeList> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
    }

    @Override
    public byte[] serialize(String s, MyEmployeeList myEmployeeList) {
        byte[] serializedBytes = null;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        try {
            serializedBytes = objectMapper.writeValueAsString(myEmployeeList).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return serializedBytes;
    }

    @Override
    public void close() {

    }
}
