package com.think.Strings;

public class ExerciseHashCode {
    public String toString(){
        return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }
    public static void main(String[] args) {
        ExerciseHashCode a = new ExerciseHashCode();
        System.out.printf(a.toString());
    }
}
