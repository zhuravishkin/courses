package com.zhuravishkin.courses.demo.traverse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;

public class JsonNodeTraverse {
    @SneakyThrows
    public static void main(String[] args) {
        String jsonString = Files.readString(Path.of("src/main/java/com/zhuravishkin/demo/traverse/body.json"));

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(jsonString);
        System.out.println(rootNode);
        System.out.println(rootNode.path("address").path("city"));
        traverseJsonNode(rootNode);
    }

    public static void traverseJsonNode(JsonNode node) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                System.out.println("Field Name: " + field.getKey());
                traverseJsonNode(field.getValue());
            }
        } else if (node.isArray()) {
            Iterator<JsonNode> elements = node.elements();
            while (elements.hasNext()) {
                traverseJsonNode(elements.next());
            }
        } else {
            System.out.println("Value: " + node.asText());
        }
    }
}
