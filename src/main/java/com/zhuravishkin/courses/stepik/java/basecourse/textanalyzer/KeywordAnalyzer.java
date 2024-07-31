package com.zhuravishkin.courses.stepik.java.basecourse.textanalyzer;

import java.util.Arrays;

abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        boolean match = Arrays.stream(getKeywords()).noneMatch(text::contains);
        return match ? Label.OK : getLabel();
    }
}
