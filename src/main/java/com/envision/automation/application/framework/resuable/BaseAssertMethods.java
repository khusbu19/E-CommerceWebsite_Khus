package com.envision.automation.application.framework.resuable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseAssertMethods {

    public static void shouldBeEqual(String actual, String expected, String... messageOnFailure){
        if(messageOnFailure.length>0){
            Assert.assertEquals(actual,expected,messageOnFailure[0]);
        }
        else {
            Assert.assertEquals(actual,expected);
        }
    }

    public static void shouldNotBeEqual(String actual, String expected, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertNotEquals(actual,expected,messageOnFailure[0]);
        }
        else {
            Assert.assertNotEquals(actual, expected);
        }
    }
    public static void shouldNotBeEqual(int actual, int expected, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertNotEquals(actual,expected,messageOnFailure[0]);
        }
        else {
            Assert.assertNotEquals(actual, expected);
        }
    }
    public static void shouldBeTrue(Boolean status, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertTrue(status,messageOnFailure[0]);
        }
        else {
            Assert.assertTrue(status);
        }
    }

    public static void shouldBeFalse(Boolean status, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertFalse(status,messageOnFailure[0]);
        }
        else {
            Assert.assertFalse(status);
        }
    }

    public static void shouldBeDisplayed(WebElement element, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertTrue(element.isDisplayed(),messageOnFailure[0]);
        }
        else {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    public static void shouldNotBeDisplayed(WebElement element, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertFalse(element.isDisplayed(),messageOnFailure[0]);
        }
        else {
            Assert.assertFalse(element.isDisplayed());
        }
    }

    public static void textShouldBeEqual(WebElement element,String valueToBeChecked, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertTrue(element.getText().equalsIgnoreCase(valueToBeChecked),messageOnFailure[0]);
        }
        else {
            Assert.assertTrue(element.getText().equalsIgnoreCase(valueToBeChecked));
        }
    }

    public static void shouldContain(WebElement element,String valueToBeChecked, String... messageOnFailure){
        if(messageOnFailure.length>1){
            Assert.assertTrue(element.getText().contains(valueToBeChecked),messageOnFailure[0]);
        }
        else {
            Assert.assertTrue(element.getText().contains(valueToBeChecked));
        }
    }

}
