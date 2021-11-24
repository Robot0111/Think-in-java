package com.think.Strings;

public class ExerciseHashCodeExtend extends ExerciseHashCode {

    @Override
    public String toString(){
        return super.toString();
    }
    public static void main(String[] args) {
        Object a = new ExerciseHashCode();
        Object b = new ExerciseHashCodeExtend();
        System.out.printf(a.toString());
        System.out.printf("\n");
        System.out.printf(b.toString());

    }
}
