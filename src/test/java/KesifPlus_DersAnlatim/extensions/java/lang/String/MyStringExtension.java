package KesifPlus_DersAnlatim.extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.lang.String;

@Extension
public class MyStringExtension {
    public static void helloWorld(@This String thiz) {
        System.out.println("hello world!");
    }

    public static String addGmail(@This String thiz) {
        return thiz + "@gmail.com";
    }
}