package com.zhuravishkin.courses.design_patterns.structural.adapter;

// Client
public class AdapterDemo {
    public static void main(String[] args) {
        // Устаревший класс
        XmlParser xmlParser = new XmlParser();

        // Адаптер позволяет работать с JSON
        JsonParser jsonParser = new XmlToJsonAdapter(xmlParser);

        // Клиент передает JSON
        jsonParser.parseJson("{ \"message\": \"Hello, Adapter!\" }");
    }
}

// Target: Современный интерфейс для работы с JSON
interface JsonParser {
    void parseJson(String json);
}

// Adaptee: Устаревший класс, работающий с XML
class XmlParser {
    public void parseXml(String xml) {
        System.out.println("Parsing XML: " + xml);
    }
}

// Adapter: Преобразует XML в JSON
class XmlToJsonAdapter implements JsonParser {
    private final XmlParser xmlParser;

    public XmlToJsonAdapter(XmlParser xmlParser) {
        this.xmlParser = xmlParser;
    }

    @Override
    public void parseJson(String json) {
        // Преобразуем JSON в XML (упрощенный пример)
        String xml = "<xml>" + json + "</xml>";
        xmlParser.parseXml(xml);
    }
}
