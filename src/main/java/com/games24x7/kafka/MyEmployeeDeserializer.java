package com.games24x7.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class MyEmployeeDeserializer implements Deserializer<MyEmployeeList> {
    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public MyEmployeeList deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        MyEmployeeList emp = null;

        try {
            emp = mapper.readValue(bytes, MyEmployeeList.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public void close() {

    }
}
