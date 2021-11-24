package com.think.Strings;

import static net.mindview.util.Print.*;
public class Immutable {

    public static String upcase(String s){
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        print(q);
        String qq = upcase(q);
        print(q);
    }
}
