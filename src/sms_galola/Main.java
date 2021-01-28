package sms_galola;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        Database.connectDB(); //Connect to SMS database

        //Populate data in Promo table
        /*Promo promo1 = new Promo(
                "PROMO",
                "Get one 9-inch pizza for only 1 PHP! " +
                      "Available for Creamy Cheese, Hawaiian, and Pepperoni pizza. " +
                      "Just text REGISTER to 1234555 then, text your Lastname, Firstname to 1234555 to avail this promo.",
                1234555,
                LocalDateTime.parse("2021-02-01 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse("2021-06-30 23:59:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        promo1.insertPromo();

        Promo promo2 = new Promo(
                "PROMO2",
                "Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP!" +
                      "Available for Original, Crunchy, or Spicy chicken." +
                      "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.",
                5432100,
                LocalDateTime.parse("2021-01-01 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse("2021-03-30 23:59:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        promo2.insertPromo();

         Promo promo3 = new Promo(
                "PROMO3",
                "Enjoy your favorite MEGA-sized Fries for only 1 PHP!" +
                      "Available for Salted, Cheese, Sweet Corn, Sour Cream, and Bacon-flavored fries." +
                      "Just text REGISTER to 3456789 then, text your Lastname, Firstname to 3456789 to avail this promo.",
                3456789,
                LocalDateTime.parse("2020-12-01 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                LocalDateTime.parse("2021-02-30 23:59:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        promo3.insertPromo();*/


        //Populate data in SMS table + SMS Checking
        /*//Piso Pizza Promo
        Map<String, String> promo1sms1 = new HashMap<>();
        promo1sms1.put("mobileNumber", "+639055142990");
        promo1sms1.put("message", "PROMO");
        promo1sms1.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms1);

        Map<String, String> promo1sms2 = new HashMap<>();
        promo1sms2.put("mobileNumber", "+639055142990");
        promo1sms2.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms2.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms2);


        //Invalid messages sent by user
        Map<String, String> promo1sms3 = new HashMap<>();
        promo1sms3.put("mobileNumber", "+639055142990");
        promo1sms3.put("message", "PRMO");
        promo1sms3.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms3);

        Map<String, String> promo1sms4 = new HashMap<>();
        promo1sms4.put("mobileNumber", "+639055142990");
        promo1sms4.put("message", "promo");
        promo1sms4.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms4);

        Map<String, String> promo1sms5 = new HashMap<>();
        promo1sms5.put("mobileNumber", "+639055142990");
        promo1sms5.put("message", "PRoMO ");
        promo1sms5.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms5);

        Map<String, String> promo1sms6 = new HashMap<>();
        promo1sms6.put("mobileNumber", "+639055142990");
        promo1sms6.put("message", "REGISTER");
        promo1sms6.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms6);

        Map<String, String> promo1sms7 = new HashMap<>();
        promo1sms7.put("mobileNumber", "+639055142990");
        promo1sms7.put("message", "REGISTER.");
        promo1sms7.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms7);

        Map<String, String> promo1sms8 = new HashMap<>();
        promo1sms8.put("mobileNumber", "+639055142990");
        promo1sms8.put("message", " REGISTER");
        promo1sms8.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms8);

        Map<String, String> promo1sms9 = new HashMap<>();
        promo1sms9.put("mobileNumber", "+639055142990");
        promo1sms9.put("message", "REGISTR");
        promo1sms9.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms9);

        Map<String, String> promo1sms10 = new HashMap<>();
        promo1sms10.put("mobileNumber", "+639055142990");
        promo1sms10.put("message", "register");
        promo1sms10.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms10);

        Map<String, String> promo1sms11 = new HashMap<>();
        promo1sms11.put("mobileNumber", "+639055142990");
        promo1sms11.put("message", "Galola, Sharmaine");
        promo1sms11.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms11);

        Map<String, String> promo1sms12 = new HashMap<>();
        promo1sms12.put("mobileNumber", "+639055142990");
        promo1sms12.put("message", "Hey Bro");
        promo1sms12.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms12);


        //From other numbers
        Map<String, String> promo1sms13 = new HashMap<>();
        promo1sms13.put("mobileNumber", "+639285556966");
        promo1sms13.put("message", "PROMO");
        promo1sms13.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms13);

        Map<String, String> promo1sms14 = new HashMap<>();
        promo1sms14.put("mobileNumber", "+639285556966");
        promo1sms14.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms14.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms14);

        Map<String, String> promo1sms15 = new HashMap<>();
        promo1sms15.put("mobileNumber", "+639285556966");
        promo1sms15.put("message", "REGISTER");
        promo1sms15.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms15);

        Map<String, String> promo1sms16 = new HashMap<>();
        promo1sms16.put("mobileNumber", "+639285556966");
        promo1sms16.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms16.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms16);

        Map<String, String> promo1sms17 = new HashMap<>();
        promo1sms17.put("mobileNumber", "+639325557081");
        promo1sms17.put("message", "Pre san ka na?");
        promo1sms17.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms17);

        Map<String, String> promo1sms18 = new HashMap<>();
        promo1sms18.put("mobileNumber", "+639195550809");
        promo1sms18.put("message", "PIZZA");
        promo1sms18.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms18);

        Map<String, String> promo1sms19 = new HashMap<>();
        promo1sms19.put("mobileNumber", "+639195550809");
        promo1sms19.put("message", "REGISTER");
        promo1sms19.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms19);

        Map<String, String> promo1sms20 = new HashMap<>();
        promo1sms20.put("mobileNumber", "+639195550809");
        promo1sms20.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms20.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms20);

        Map<String, String> promo1sms21 = new HashMap<>();
        promo1sms21.put("mobileNumber", "+639075550683");
        promo1sms21.put("message", "Ma uwi na po ako.");
        promo1sms21.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms21);

        Map<String, String> promo1sms22 = new HashMap<>();
        promo1sms22.put("mobileNumber", "+639295552977");
        promo1sms22.put("message", "Register");
        promo1sms22.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms22);

        Map<String, String> promo1sms23 = new HashMap<>();
        promo1sms23.put("mobileNumber", "+639295552977");
        promo1sms23.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms23.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms23);

        Map<String, String> promo1sms24 = new HashMap<>();
        promo1sms24.put("mobileNumber", "+639195550845");
        promo1sms24.put("message", "PROMO");
        promo1sms24.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms24);

        Map<String, String> promo1sms25 = new HashMap<>();
        promo1sms25.put("mobileNumber", "+639195550845");
        promo1sms25.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms25.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms25);

        Map<String, String> promo1sms26 = new HashMap<>();
        promo1sms26.put("mobileNumber", "+639105555764");
        promo1sms26.put("message", "GO90");
        promo1sms26.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms26);

        Map<String, String> promo1sms27 = new HashMap<>();
        promo1sms27.put("mobileNumber", "+639105555764");
        promo1sms27.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms27.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms27);

        Map<String, String> promo1sms28 = new HashMap<>();
        promo1sms28.put("mobileNumber", "+639295556747");
        promo1sms28.put("message", "D2 n kmi wer na u");
        promo1sms28.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms28);

        Map<String, String> promo1sms29 = new HashMap<>();
        promo1sms29.put("mobileNumber", "+639075556773");
        promo1sms29.put("message", "Kim, Seokjin.");
        promo1sms29.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms29);

        Map<String, String> promo1sms30 = new HashMap<>();
        promo1sms30.put("mobileNumber", "+639075556773");
        promo1sms30.put("message", "Sorry, you have entered an invalid keyword.");
        promo1sms30.put("shortCode", "1234555");
        SMSChecker.smsChecker(promo1sms30);

        
        //Piso Chicken Promo
        Map<String, String> promo2sms1 = new HashMap<>();
        promo2sms1.put("mobileNumber", "+639055142990");
        promo2sms1.put("message", "PROMO2");
        promo2sms1.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms1);

        Map<String, String> promo2sms2 = new HashMap<>();
        promo2sms2.put("mobileNumber", "+639055142990");
        promo2sms2.put("message", "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                "Available for Original, Crunchy, or Spicy chicken. " +
                "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.");
        promo2sms2.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms2);

        Map<String, String> promo2sms3 = new HashMap<>();
        promo2sms3.put("mobileNumber", "+639055142990");
        promo2sms3.put("message", "REGISTER");
        promo2sms3.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms3);

        Map<String, String> promo2sms4 = new HashMap<>();
        promo2sms4.put("mobileNumber", "+639055142990");
        promo2sms4.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo2sms4.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms4);

        Map<String, String> promo2sms5 = new HashMap<>();
        promo2sms5.put("mobileNumber", "+639055142990");
        promo2sms5.put("message", "Galola, Sharmaine");
        promo2sms5.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms5);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2sms5));

        Map<String, String> promo2sms6= new HashMap<>();
        promo2sms6.put("mobileNumber", "+639055142990");
        promo2sms6.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo2sms6.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms6);


        //Invalid messages sent by user
        Map<String, String> promo2sms7= new HashMap<>();
        promo2sms7.put("mobileNumber", "+639055142990");
        promo2sms7.put("message", "PRMO");
        promo2sms7.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms7);

        Map<String, String> promo2sms8 = new HashMap<>();
        promo2sms8.put("mobileNumber", "+639055142990");
        promo2sms8.put("message", "PROMO ");
        promo2sms8.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms8);

        Map<String, String> promo2sms9 = new HashMap<>();
        promo2sms9.put("mobileNumber", "+639055142990");
        promo2sms9.put("message", "promo");
        promo2sms9.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms9);

        Map<String, String> promo2sms10 = new HashMap<>();
        promo2sms10.put("mobileNumber", "+639055142990");
        promo2sms10.put("message", "REGISTER.");
        promo2sms10.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms10);

        Map<String, String> promo2sms11 = new HashMap<>();
        promo2sms11.put("mobileNumber", "+639055142990");
        promo2sms11.put("message", " REGISTER");
        promo2sms11.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms11);

        Map<String, String> promo2sms12 = new HashMap<>();
        promo2sms12.put("mobileNumber", "+639055142990");
        promo2sms12.put("message", "REGISTR");
        promo2sms12.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms12);

        Map<String, String> promo2sms13 = new HashMap<>();
        promo2sms13.put("mobileNumber", "+639055142990");
        promo2sms13.put("message", "Galola");
        promo2sms13.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms13);

        Map<String, String> promo2sms14 = new HashMap<>();
        promo2sms14.put("mobileNumber", "+639055142990");
        promo2sms14.put("message", "Tara Mcdo");
        promo2sms14.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms14);


        //Reply of System to invalid messages
        Map<String, String> promo2sms15 = new HashMap<>();
        promo2sms15.put("mobileNumber", "+639055142990");
        promo2sms15.put("message", "Sorry, you have entered an invalid keyword.");
        promo2sms15.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms15);


        //Messages from other numbers
        Map<String, String> promo2sms16 = new HashMap<>();
        promo2sms16.put("mobileNumber", "+639235557236");
        promo2sms16.put("message", "PROMO2");
        promo2sms16.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms16);

        Map<String, String> promo2sms17 = new HashMap<>();
        promo2sms17.put("mobileNumber", "+639235557236");
        promo2sms17.put("message", "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                "Available for Original, Crunchy, or Spicy chicken. " +
                "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.");
        promo2sms17.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms17);

        Map<String, String> promo2sms18 = new HashMap<>();
        promo2sms18.put("mobileNumber", "+639235557236");
        promo2sms18.put("message", "REGISTER");
        promo2sms18.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms18);

        Map<String, String> promo2sms19 = new HashMap<>();
        promo2sms19.put("mobileNumber", "+639235557236");
        promo2sms19.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo2sms19.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms19);

        Map<String, String> promo2sms20 = new HashMap<>();
        promo2sms20.put("mobileNumber", "+639235557236");
        promo2sms20.put("message", "Jeon, Jungkook");
        promo2sms20.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms20);

        Map<String, String> promo2sms21= new HashMap<>();
        promo2sms21.put("mobileNumber", "+639235557236");
        promo2sms21.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo2sms21.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms21);

        Map<String, String> promo2sms22 = new HashMap<>();
        promo2sms22.put("mobileNumber", "+639325559933");
        promo2sms22.put("message", "Hello po Mam shopee po ito nasa pinto niyo na ako");
        promo2sms22.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms22);

        Map<String, String> promo2sms23 = new HashMap<>();
        promo2sms23.put("mobileNumber", "+639105553055");
        promo2sms23.put("message", "CHICKEN");
        promo2sms23.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms23);

        Map<String, String> promo2sms24 = new HashMap<>();
        promo2sms24.put("mobileNumber", "+639105553055");
        promo2sms24.put("message", "Sorry, you have entered an invalid keyword.");
        promo2sms24.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms24);

        Map<String, String> promo2sms25 = new HashMap<>();
        promo2sms25.put("mobileNumber", "+639175557453");
        promo2sms25.put("message", "PROMO2");
        promo2sms25.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms25);

        Map<String, String> promo2sms26 = new HashMap<>();
        promo2sms26.put("mobileNumber", "+639175557453");
        promo2sms26.put("message", "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                "Available for Original, Crunchy, or Spicy chicken. " +
                "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.");
        promo2sms26.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms26);

        Map<String, String> promo2sms27 = new HashMap<>();
        promo2sms27.put("mobileNumber", "+639175557453");
        promo2sms27.put("message", "REGISTER");
        promo2sms27.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms27);

        Map<String, String> promo2sms28 = new HashMap<>();
        promo2sms28.put("mobileNumber", "+639175557453");
        promo2sms28.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo2sms28.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms28);

        Map<String, String> promo2sms29 = new HashMap<>();
        promo2sms29.put("mobileNumber", "+639175557453");
        promo2sms29.put("message", "Min, Yoongi");
        promo2sms29.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms29);

        Map<String, String> promo2sms30= new HashMap<>();
        promo2sms30.put("mobileNumber", "+639175557453");
        promo2sms30.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo2sms30.put("shortCode", "5432100");
        SMSChecker.smsChecker(promo2sms30);


        //Piso Fries Promo
        Map<String, String> promo3sms1 = new HashMap<>();
        promo3sms1.put("mobileNumber", "+639055142990");
        promo3sms1.put("message", "PROMO3");
        promo3sms1.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms1);

        Map<String, String> promo3sms2 = new HashMap<>();
        promo3sms2.put("mobileNumber", "+639055142990");
        promo3sms2.put("message", "Promo code accepted. Enjoy your favorite MEGA-sized Fries for only 1 PHP! " +
                "Available for Salted, Cheese, Sweet Corn, Sour Cream, and Bacon-flavored fries. " +
                "Just text REGISTER to 3456789 then, text your Lastname, Firstname to 3456789 to avail this promo.");
        promo3sms2.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms2);

        Map<String, String> promo3sms3 = new HashMap<>();
        promo3sms3.put("mobileNumber", "+639055142990");
        promo3sms3.put("message", "REGISTER");
        promo3sms3.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms3);

        Map<String, String> promo3sms4 = new HashMap<>();
        promo3sms4.put("mobileNumber", "+639055142990");
        promo3sms4.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo3sms4.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms4);

        Map<String, String> promo3sms5 = new HashMap<>();
        promo3sms5.put("mobileNumber", "+639055142990");
        promo3sms5.put("message", "Galola, Sharmaine");
        promo3sms5.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms5);

        Map<String, String> promo3sms6= new HashMap<>();
        promo3sms6.put("mobileNumber", "+639055142990");
        promo3sms6.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo3sms6.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms6);


        //Invalid messages sent by user
        Map<String, String> promo3sms7= new HashMap<>();
        promo3sms7.put("mobileNumber", "+639055142990");
        promo3sms7.put("message", "PRMO");
        promo3sms7.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms7);

        Map<String, String> promo3sms8 = new HashMap<>();
        promo3sms8.put("mobileNumber", "+639055142990");
        promo3sms8.put("message", "PROMO ");
        promo3sms8.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms8);

        Map<String, String> promo3sms9 = new HashMap<>();
        promo3sms9.put("mobileNumber", "+639055142990");
        promo3sms9.put("message", "promo");
        promo3sms9.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms9);

        Map<String, String> promo3sms10 = new HashMap<>();
        promo3sms10.put("mobileNumber", "+639055142990");
        promo3sms10.put("message", "REGISTER.");
        promo3sms10.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms10);

        Map<String, String> promo3sms11 = new HashMap<>();
        promo3sms11.put("mobileNumber", "+639055142990");
        promo3sms11.put("message", " REGISTER");
        promo3sms11.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms11);

        Map<String, String> promo3sms12 = new HashMap<>();
        promo3sms12.put("mobileNumber", "+639055142990");
        promo3sms12.put("message", "REGISTR");
        promo3sms12.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms12);

        Map<String, String> promo3sms13 = new HashMap<>();
        promo3sms13.put("mobileNumber", "+639055142990");
        promo3sms13.put("message", "Galola");
        promo3sms13.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms13);

        Map<String, String> promo3sms14 = new HashMap<>();
        promo3sms14.put("mobileNumber", "+639055142990");
        promo3sms14.put("message", "Tara Mcdo");
        promo3sms14.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms14);


        //Reply of System to invalid messages
        Map<String, String> promo3sms15 = new HashMap<>();
        promo3sms15.put("mobileNumber", "+639055142990");
        promo3sms15.put("message", "Sorry, you have entered an invalid keyword.");
        promo3sms15.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms15);

        //Messages from other numbers
        Map<String, String> promo3sms16 = new HashMap<>();
        promo3sms16.put("mobileNumber", "+639175559621");
        promo3sms16.put("message", "PROMO3");
        promo3sms16.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms16);

        Map<String, String> promo3sms17 = new HashMap<>();
        promo3sms17.put("mobileNumber", "+639175559621");
        promo3sms17.put("message", "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                "Available for Original, Crunchy, or Spicy chicken. " +
                "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.");
        promo3sms17.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms17);

        Map<String, String> promo3sms18 = new HashMap<>();
        promo3sms18.put("mobileNumber", "+639175559621");
        promo3sms18.put("message", "REGISTER");
        promo3sms18.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms18);

        Map<String, String> promo3sms19 = new HashMap<>();
        promo3sms19.put("mobileNumber", "+639175559621");
        promo3sms19.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo3sms19.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms19);

        Map<String, String> promo3sms20 = new HashMap<>();
        promo3sms20.put("mobileNumber", "+639175559621");
        promo3sms20.put("message", "Jung, Hoseok");
        promo3sms20.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms20);

        Map<String, String> promo3sms21= new HashMap<>();
        promo3sms21.put("mobileNumber", "+639175559621");
        promo3sms21.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo3sms21.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms21);

        Map<String, String> promo3sms22 = new HashMap<>();
        promo3sms22.put("mobileNumber", "+639085555683");
        promo3sms22.put("message", "Hello po foodpanda po ito saang street po kayo");
        promo3sms22.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms22);

        Map<String, String> promo3sms23 = new HashMap<>();
        promo3sms23.put("mobileNumber", "+639295558896");
        promo3sms23.put("message", "FRIES");
        promo3sms23.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms23);

        Map<String, String> promo3sms24 = new HashMap<>();
        promo3sms24.put("mobileNumber", "+639295558896");
        promo3sms24.put("message", "Sorry, you have entered an invalid keyword.");
        promo3sms24.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms24);

        Map<String, String> promo3sms25 = new HashMap<>();
        promo3sms25.put("mobileNumber", "+639225557141");
        promo3sms25.put("message", "PROMO3");
        promo3sms25.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms25);

        Map<String, String> promo3sms26 = new HashMap<>();
        promo3sms26.put("mobileNumber", "+639225557141");
        promo3sms26.put("message", "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                "Available for Original, Crunchy, or Spicy chicken. " +
                "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.");
        promo3sms26.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms26);

        Map<String, String> promo3sms27 = new HashMap<>();
        promo3sms27.put("mobileNumber", "+639225557141");
        promo3sms27.put("message", "REGISTER");
        promo3sms27.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms27);

        Map<String, String> promo3sms28 = new HashMap<>();
        promo3sms28.put("mobileNumber", "+639225557141");
        promo3sms28.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo3sms28.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms28);

        Map<String, String> promo3sms29 = new HashMap<>();
        promo3sms29.put("mobileNumber", "+639225557141");
        promo3sms29.put("message", "Park, Jimin");
        promo3sms29.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms29);

        Map<String, String> promo3sms30= new HashMap<>();
        promo3sms30.put("mobileNumber", "+639225557141");
        promo3sms30.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo3sms30.put("shortCode", "3456789");
        SMSChecker.smsChecker(promo3sms30);*/


        //Retrieve functions
        /*SMS retrieve1 = new SMS();

//        ArrayList<String> response1 = retrieve1.retrieveSMSGivenStartDateAndEndDate(
//                LocalDateTime.parse("2019-01-24 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
//                LocalDateTime.parse("2023-01-24 12:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

//        ArrayList<String> response2 = retrieve1.retrieveSMSGivenPromoCode("PROMO");

//        ArrayList<String> response3 = retrieve1.retrieveSMSGivenMsisdn("+639055142990");

//        ArrayList<String> response4 = retrieve1.retrieveSMSSentBySystem();

//        ArrayList<String> response5 = retrieve1.retrieveSMSReceivedBySystem();

//        ArrayList<String> response6 = retrieve1.retrieveSMSGivenSeveralMsisdn("+639235557236", "+639195550845", "+639105555764");
*/

        //Generate Reports
        /*
//        Database.retrieveSMSDataGivenSMSStatus("FAILED SMS");
//        Database.retrieveSMSDataBySMSTypeGivenSMSStatus("FAILED SMS");
//        Database.retrieveSMSDataGivenSMSStatus("SUCCESSFUL SMS");
//        Database.retrieveSMSDataBySMSTypeGivenSMSStatus("SUCCESSFUL SMS");
//        Database.retrieveListOfPeople();
//        Database.totalCountOfSMSReceivedBySystem();
//        Database.totalCountOfSMSSentBySystem();*/

        Database.disconnectDB(); //Disconnect to SMS database
    }

}
