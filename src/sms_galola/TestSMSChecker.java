package sms_galola;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSMSChecker {

    @Test
    public void testSMSCheckerPromo1() {
        Database.connectDB();


        //Conversation by user and system for Piso Pizza Promo which has not started yet
        //Since Pizza Promo has not yet started, system will only reply "Sorry, you have entered an invalid keyword."
        //SMSChecker is commented out to avoid multiple SMS being inserted in SMS Database
        Map<String, String> promo1test1 = new HashMap<>();
        promo1test1.put("mobileNumber", "+639055142990");
        promo1test1.put("message", "PROMO");
        promo1test1.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test1);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test1));

        Map<String, String> promo1test2 = new HashMap<>();
        promo1test2.put("mobileNumber", "+639055142990");
        promo1test2.put("message", "Sorry, you have entered an invalid keyword.");
        promo1test2.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test2);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test2));


        //Invalid messages sent by user
        Map<String, String> promo1test3 = new HashMap<>();
        promo1test3.put("mobileNumber", "+639055142990");
        promo1test3.put("message", "PRMO");
        promo1test3.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test3);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test3));

        Map<String, String> promo1test4 = new HashMap<>();
        promo1test4.put("mobileNumber", "+639055142990");
        promo1test4.put("message", "promo");
        promo1test4.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test4);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test4));

        Map<String, String> promo1test5 = new HashMap<>();
        promo1test5.put("mobileNumber", "+639055142990");
        promo1test5.put("message", "PRoMO ");
        promo1test5.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test5);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test5));

        Map<String, String> promo1test6 = new HashMap<>();
        promo1test6.put("mobileNumber", "+639055142990");
        promo1test6.put("message", "REGISTER");
        promo1test6.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test6);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test6));

        Map<String, String> promo1test7 = new HashMap<>();
        promo1test7.put("mobileNumber", "+639055142990");
        promo1test7.put("message", "REGISTER.");
        promo1test7.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test7);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test7));

        Map<String, String> promo1test8 = new HashMap<>();
        promo1test8.put("mobileNumber", "+639055142990");
        promo1test8.put("message", " REGISTER");
        promo1test8.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test8);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test8));

        Map<String, String> promo1test9 = new HashMap<>();
        promo1test9.put("mobileNumber", "+639055142990");
        promo1test9.put("message", "REGISTR");
        promo1test9.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test9);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test9));

        Map<String, String> promo1test10 = new HashMap<>();
        promo1test10.put("mobileNumber", "+639055142990");
        promo1test10.put("message", "register");
        promo1test10.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test10);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test10));

        Map<String, String> promo1test11 = new HashMap<>();
        promo1test11.put("mobileNumber", "+639055142990");
        promo1test11.put("message", "Galola, Sharmaine");
        promo1test11.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test11);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test11));

        Map<String, String> promo1test12 = new HashMap<>();
        promo1test12.put("mobileNumber", "+639055142990");
        promo1test12.put("message", "Hey Bro");
        promo1test12.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test12);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test12));

        Map<String, String> promo1test13 = new HashMap<>();
        promo1test13.put("mobileNumber", "+639195550809");
        promo1test13.put("message", "PIZZA");
        promo1test13.put("shortCode", "1234555");
        //SMSChecker.smsChecker(promo1test13);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo1test13));


        Database.disconnectDB();
    }

    
    @Test
    public void testSMSCheckerPromo2() {
        Database.connectDB();


        //Conversation by user and system for Piso Chicken Promo which is ongoing
        //SMSChecker is commented out to avoid multiple SMS being inserted in SMS Database
        Map<String, String> promo2test1 = new HashMap<>();
        promo2test1.put("mobileNumber", "+639055142990");
        promo2test1.put("message", "PROMO2");
        promo2test1.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test1);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2test1));

        Map<String, String> promo2test2 = new HashMap<>();
        promo2test2.put("mobileNumber", "+639055142990");
        promo2test2.put("message", "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                "Available for Original, Crunchy, or Spicy chicken. " +
                "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.");
        promo2test2.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test2);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2test2));

        Map<String, String> promo2test3 = new HashMap<>();
        promo2test3.put("mobileNumber", "+639055142990");
        promo2test3.put("message", "REGISTER");
        promo2test3.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test3);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2test3));

        Map<String, String> promo2test4 = new HashMap<>();
        promo2test4.put("mobileNumber", "+639055142990");
        promo2test4.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo2test4.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test4);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2test4));

        Map<String, String> promo2test5 = new HashMap<>();
        promo2test5.put("mobileNumber", "+639055142990");
        promo2test5.put("message", "Galola, Sharmaine");
        promo2test5.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test5);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2test5));

        Map<String, String> promo2test6= new HashMap<>();
        promo2test6.put("mobileNumber", "+639055142990");
        promo2test6.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo2test6.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test6);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo2test6));


        //Invalid messages sent by user
        Map<String, String> promo2test7= new HashMap<>();
        promo2test7.put("mobileNumber", "+639055142990");
        promo2test7.put("message", "PRMO");
        promo2test7.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test7);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test7));

        Map<String, String> promo2test8 = new HashMap<>();
        promo2test8.put("mobileNumber", "+639055142990");
        promo2test8.put("message", "PROMO ");
        promo2test8.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test8);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test8));

        Map<String, String> promo2test9 = new HashMap<>();
        promo2test9.put("mobileNumber", "+639055142990");
        promo2test9.put("message", "promo");
        promo2test9.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test9);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test9));

        Map<String, String> promo2test10 = new HashMap<>();
        promo2test10.put("mobileNumber", "+639055142990");
        promo2test10.put("message", "REGISTER.");
        promo2test10.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test10);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test10));

        Map<String, String> promo2test11 = new HashMap<>();
        promo2test11.put("mobileNumber", "+639055142990");
        promo2test11.put("message", " REGISTER");
        promo2test11.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test11);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test11));

        Map<String, String> promo2test12 = new HashMap<>();
        promo2test12.put("mobileNumber", "+639055142990");
        promo2test12.put("message", "REGISTR");
        promo2test12.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test12);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test12));

        Map<String, String> promo2test13 = new HashMap<>();
        promo2test13.put("mobileNumber", "+639055142990");
        promo2test13.put("message", "Galola");
        promo2test13.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test13);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test13));

        Map<String, String> promo2test14 = new HashMap<>();
        promo2test14.put("mobileNumber", "+639055142990");
        promo2test14.put("message", "Tara Mcdo");
        promo2test14.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test14);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test14));


        //Reply of System to invalid messages
        Map<String, String> promo2test15 = new HashMap<>();
        promo2test15.put("mobileNumber", "+639055142990");
        promo2test15.put("message", "Sorry, you have entered an invalid keyword.");
        promo2test15.put("shortCode", "5432100");
        //SMSChecker.smsChecker(promo2test15);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo2test15));


        Database.disconnectDB();

    }


    @Test
    public void testSMSCheckerPromo3() {
        Database.connectDB();


        //Conversation by user and system for Piso Chicken Promo which is ongoing
        //SMSChecker is commented out to avoid multiple SMS being inserted in SMS Database
        Map<String, String> promo3test1 = new HashMap<>();
        promo3test1.put("mobileNumber", "+639055142990");
        promo3test1.put("message", "PROMO3");
        promo3test1.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test1);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo3test1));

        Map<String, String> promo3test2 = new HashMap<>();
        promo3test2.put("mobileNumber", "+639055142990");
        promo3test2.put("message", "Promo code accepted. Enjoy your favorite MEGA-sized Fries for only 1 PHP! " +
                "Available for Salted, Cheese, Sweet Corn, Sour Cream, and Bacon-flavored fries. " +
                "Just text REGISTER to 3456789 then, text your Lastname, Firstname to 3456789 to avail this promo.");
        promo3test2.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test2);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo3test2));

        Map<String, String> promo3test3 = new HashMap<>();
        promo3test3.put("mobileNumber", "+639055142990");
        promo3test3.put("message", "REGISTER");
        promo3test3.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test3);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo3test3));

        Map<String, String> promo3test4 = new HashMap<>();
        promo3test4.put("mobileNumber", "+639055142990");
        promo3test4.put("message", "To complete the promo registration, please send Lastname, Firstname to 5432100.");
        promo3test4.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test4);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo3test4));

        Map<String, String> promo3test5 = new HashMap<>();
        promo3test5.put("mobileNumber", "+639055142990");
        promo3test5.put("message", "Galola, Sharmaine");
        promo3test5.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test5);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo3test5));

        Map<String, String> promo3test6= new HashMap<>();
        promo3test6.put("mobileNumber", "+639055142990");
        promo3test6.put("message", "You have successfully registered for this promo! Please show this message at the cashier upon purchase.");
        promo3test6.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test6);
        assertEquals("SUCCESSFUL SMS", Database.retrieveSMSStatus(promo3test6));


        //Invalid messages sent by user
        Map<String, String> promo3test7= new HashMap<>();
        promo3test7.put("mobileNumber", "+639055142990");
        promo3test7.put("message", "PRMO");
        promo3test7.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test7);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test7));

        Map<String, String> promo3test8 = new HashMap<>();
        promo3test8.put("mobileNumber", "+639055142990");
        promo3test8.put("message", "PROMO ");
        promo3test8.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test8);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test8));

        Map<String, String> promo3test9 = new HashMap<>();
        promo3test9.put("mobileNumber", "+639055142990");
        promo3test9.put("message", "promo");
        promo3test9.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test9);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test9));

        Map<String, String> promo3test10 = new HashMap<>();
        promo3test10.put("mobileNumber", "+639055142990");
        promo3test10.put("message", "REGISTER.");
        promo3test10.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test10);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test10));

        Map<String, String> promo3test11 = new HashMap<>();
        promo3test11.put("mobileNumber", "+639055142990");
        promo3test11.put("message", " REGISTER");
        promo3test11.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test11);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test11));

        Map<String, String> promo3test12 = new HashMap<>();
        promo3test12.put("mobileNumber", "+639055142990");
        promo3test12.put("message", "REGISTR");
        promo3test12.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test12);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test12));

        Map<String, String> promo3test13 = new HashMap<>();
        promo3test13.put("mobileNumber", "+639055142990");
        promo3test13.put("message", "Galola");
        promo3test13.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test13);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test13));

        Map<String, String> promo3test14 = new HashMap<>();
        promo3test14.put("mobileNumber", "+639055142990");
        promo3test14.put("message", "Tara Mcdo");
        promo3test14.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test14);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test14));


        //Reply of System to invalid messages
        Map<String, String> promo3test15 = new HashMap<>();
        promo3test15.put("mobileNumber", "+639055142990");
        promo3test15.put("message", "Sorry, you have entered an invalid keyword.");
        promo3test15.put("shortCode", "3456789");
        //SMSChecker.smsChecker(promo3test15);
        assertEquals("FAILED SMS", Database.retrieveSMSStatus(promo3test15));


        Database.disconnectDB();

    }
}
