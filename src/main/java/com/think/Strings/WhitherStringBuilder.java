package com.think.Strings;

public class WhitherStringBuilder {
    public String implicit(String[] fields){
        String result = "";
           for (int i = 0; i < fields.length; i++)
               result += fields[i];
           return result;
        }
        //使用javap -c 反编译 对比结果
        public String explicit(String[] fields){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < fields.length; i++)
            result.append(fields[i]);
        return result.toString();
        }
}

