package com.test.testing.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class StaticVariable {
    public static double freightCost = 5.00;
    public enum Condition{
        and,
        or
    }
    public static String authenticator_secret(){
        try {
            File myObj = new File("secret.txt");
            Scanner myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
            return data;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static String randomAlphanumeric(int targetStringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    public enum accountType{
        Customer,
        Seller
    }
    public enum prodCat{
        ClothingApparel,
        Footwear,
        ElecGadgets,
        GamesToys,
        Pet,
        Stationary
    }
    public enum orderStat{
        //Customer add to cart and proceed to checkout but havent fill in checkout detail
        Pending,
        //Completed checkout process, not paid
        Awaiting_Payment,
        //Paid, waiting to deliver
        Awaiting_Shipment,
        //Seller Cancel order
        Cancelled,
        Awaiting_Refund,
        Refunded
    }
    public enum Payment_Type{
        credit_card,
        debit_card,
        ewallet
    }
    public enum Payment_Status{
        Pending,
        Paid
    }
}
