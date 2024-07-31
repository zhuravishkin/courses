package com.zhuravishkin.courses.demo.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HTMLParser {
    public static void main(String[] args) {
        Document doc;
        String title = null;
        try {
            doc = Jsoup.connect("https://google.com/").get();
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Jsoup Can read HTML page from URL, title : " + title);
    }
}
