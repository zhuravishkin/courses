package com.zhuravishkin.courses.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;

public class JsonObjectTraversal {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("name", "john");
        JSONObject context = new JSONObject();
        context.put("name1", "sam");
        context.put("name2", "dean");
        object.put("context", context);
        System.out.println(object);

        traverse(object);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name", "john");
        ObjectNode contextNode = mapper.createObjectNode();
        contextNode.put("name1", "sam");
        contextNode.put("name2", "dean");
        node.set("context", contextNode);
        System.out.println(node);
    }

    public static void traverse(JSONObject jsonObject) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);

            // Выводим ключ и значение
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);

            // Если значение является объектом JSON, рекурсивно вызываем traverse
            if (value instanceof JSONObject) {
                traverse((JSONObject) value);
            }
        }
    }
}
