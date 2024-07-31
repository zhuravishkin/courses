package com.zhuravishkin.courses.stepik.java.basecourse.cycles;

public class TextPerRole {
    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(TextPerRole.printTextPerRole(roles, textLines));
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            String s = roles[i] + ":";
            stringBuilder.append(s + "\n");
            for (int j = 0; j < textLines.length; j++) {
                String a = textLines[j];
                if (a.startsWith(s)) {
                    a = a.replaceFirst(s + " ", "");
                    stringBuilder.append(j + 1 + ") " + a + "\n");
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
