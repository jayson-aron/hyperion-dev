package com.hyperiondev.thelibrarian;

import com.hyperiondev.thelibrarian.isbn.Validator;

public class Main {
    public static void main(String[] args) {

        if (args  == null || args.length == 0) {
            System.out.println("No arguments");
            System.exit(0);
        }

        Validator validator = new Validator(args[0]);

        String result = validator.validate();

        System.out.println(result);
    }
}