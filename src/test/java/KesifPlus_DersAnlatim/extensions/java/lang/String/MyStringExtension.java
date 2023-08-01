package KesifPlus_DersAnlatim.extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.junit.Assert;

import java.lang.String;

import static stepDefinitions.Hooks.driver;

@Extension
public class MyStringExtension {
    public static void helloWorld(@This String thiz) {
        System.out.println("hello world!");
    }

    public static String addGmail(@This String thiz) {
        return thiz + "@gmail.com";
    }

    public static void assertUrl(@This String expectedUrl){
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());
    }
}