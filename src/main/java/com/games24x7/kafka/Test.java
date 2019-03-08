package com.games24x7.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test {

    public static void main(String[] args) throws Exception {
        User user = new User("123", "1");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(user));

        String jsonStr = "{\"user_id\":\"123\",\"action_type\":\"1\"}";
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(jsonStr);

        System.out.println(json.get("user_id"));
    }
}
