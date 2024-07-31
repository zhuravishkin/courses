package com.zhuravishkin.courses.stepik.java.basecourse.textanalyzer;

public class TextProcessor {
    public static void main(String[] args) {
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer t : analyzers) {
            Label label = t.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }
}
