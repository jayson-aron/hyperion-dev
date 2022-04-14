package com.hyperiondev.thelibrarian;

import com.hyperiondev.thelibrarian.isbn.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/***
 * Test suit for testing the successful verification of ISBN-10 and ISBN-13 numbers.
 */
public class ValidationTest {

    @Test
    public void test1() {
        Validator validator = new Validator("9780316066525");
        assertEquals("Valid", validator.validate());
    }

    @Test
    public void test2() {
        Validator validator = new Validator("9783866155237");
        assertEquals("Valid", validator.validate());
    }

    @Test
    public void test3() {
        Validator validator = new Validator("9780345453747");
        assertEquals("Valid", validator.validate());
    }

    @Test
    public void test4() {
        Validator validator = new Validator("031606652X");
        assertEquals("Invalid", validator.validate());
    }

    @Test
    public void test5() {
        Validator validator = new Validator("979783876155237");
        assertEquals("Invalid", validator.validate());
    }

    @Test
    public void test6() {
        Validator validator = new Validator("0345453747");
        assertEquals("Invalid", validator.validate());
    }

    @Test
    public void test7() {
        Validator validator = new Validator("0316066524");
        assertEquals("9780316066525", validator.validate());
    }

    @Test
    public void test8() {
        Validator validator = new Validator("3866155239");
        assertEquals("9783866155237", validator.validate());
    }

    @Test
    public void test9() {
        Validator validator = new Validator("817450494X");
        assertEquals("9788174504944", validator.validate());
    }
}
