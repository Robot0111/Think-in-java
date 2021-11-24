package com.think.Strings;

import java.math.BigInteger;
import java.util.Formatter;

public class Conversion {
    public static void main(String[] args) {
        Formatter f =new Formatter(System.out);
        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s:%s\n",u);
        //f.format("d:%d\n",u);
        f.format("c: %c\n",u);
        f.format("b: %b\n",u);
        //f.format("f: %f\n",u);
        //f.format("e: %e\n",u);
        //f.format("X: %x\n",u);

        int v = 121;
        System.out.println("v = 121");
        f.format("d: %d\n",v);
        f.format("c: %c\n",v);
        f.format("b: %b\n",v);
        f.format("s: %s\n",v);
        //f.format("f: %f\n",v);
        //f.format("e: %e\n",v);
        f.format("x: %x\n",v);
        f.format("h: %h\n",v);

        BigInteger w = new BigInteger("50000000000000");
        System.out.println("w = new BigInteger(\"50000000000000\")");
        f.format("d: %d\n",w);
        //f.format("c: %c\n",w);
        f.format("b: %b\n",w);
        f.format("s: %s\n",w);
        //f.format("f: %f\n",w);
        //f.format("e: %e\n",w);
        f.format("x: %x\n",w);
        f.format("h: %h\n",w);

        double x = 179.543;

        System.out.println("x = 179.543");
        //f.format("d: %d\n",x);
        //f.format("c: %c\n",x);
        f.format("b: %b\n",x);
        f.format("s: %s\n",x);
        f.format("f: %f\n",x);
        f.format("e: %e\n",x);
        //f.format("x: %x\n",x);
        f.format("h: %h\n",x);

        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
        //f.format("d: %d\n",y);
    }
}
