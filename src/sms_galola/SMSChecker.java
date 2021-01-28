package sms_galola;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.RandomStringGenerator;
import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

public class SMSChecker {

    final private static Logger logger = Logger.getLogger(Database.class.getName());

    //SMS Checker, accepts all SMS fields except SMS Success or Fail Status
    //Checks if the SMS is SUCCESSFUL SMS or FAILED SMS
    //Then, it inputs resulting SMS Status to Status column of SMS table
    public static void smsChecker(Map<String, String> smsToCheck) {
        LocalDateTime timeExecuted = LocalDateTime.now(); //Timestamp of message is execution of SMSChecker
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0', 'z')
                .filteredBy(LETTERS, DIGITS).build(); //For transactionID

        //Messages sent by the system are in smsBySystem
        Set<String> smsBySystem = new HashSet<>(List.of(
                "Promo code accepted. Get one 9-inch pizza for only 1 PHP! " +
                        "Available for Creamy Cheese, Hawaiian, and Pepperoni pizza. " +
                        "Just text REGISTER to 1234555 then, text your Lastname, Firstname to 1234555 to avail this promo.",
                "Promo code accepted. Enjoy your favorite chicken meal complete with rice and drinks for only 1 PHP! " +
                        "Available for Original, Crunchy, or Spicy chicken. " +
                        "Just text REGISTER to 5432100 then, text your Lastname, Firstname to 5432100 to avail this promo.",
                "Promo code accepted. Enjoy your favorite MEGA-sized Fries for only 1 PHP! " +
                        "Available for Salted, Cheese, Sweet Corn, Sour Cream, and Bacon-flavored fries. " +
                        "Just text REGISTER to 3456789 then, text your Lastname, Firstname to 3456789 to avail this promo.",
                "To complete the promo registration, please send Lastname, Firstname to 1234555.",
                "To complete the promo registration, please send Lastname, Firstname to 5432100.",
                "To complete the promo registration, please send Lastname, Firstname to 3456789.",
                "You have successfully registered for this promo! Please show this message at the cashier upon purchase.",
                "Sorry, you have entered an invalid keyword."));

        //If message was sent by system
        if (smsBySystem.contains(smsToCheck.get("message"))) {
            SMS newSystemSMS = new SMS(smsToCheck.get("mobileNumber"), smsToCheck.get("mobileNumber"),
                    smsToCheck.get("shortCode"), Integer.parseInt(smsToCheck.get("shortCode")), generator.generate(8),
                    timeExecuted, smsToCheck.get("message"));
            if (newSystemSMS.getMESSAGE() == "Sorry, you have entered an invalid keyword.") {
                newSystemSMS.setSMSSTATUS("FAILED SMS");
            } else {
                newSystemSMS.setSMSSTATUS("SUCCESSFUL SMS");
            }
            logger.log(Level.INFO, "SMS Checker : {0}", newSystemSMS.getSMSSTATUS());
            newSystemSMS.insertSMS();

        } else {
            //If message was not sent by the system, it was sent by the user
            SMS newSMS = new SMS(smsToCheck.get("mobileNumber"), smsToCheck.get("shortCode"),
                    smsToCheck.get("mobileNumber"), Integer.parseInt(smsToCheck.get("shortCode")), generator.generate(8),
                    timeExecuted, smsToCheck.get("message"));

            //Retrieve promo details given the matching shortCode
            String selectQueryPromo = "SELECT promoCode FROM promo WHERE shortCode='" + smsToCheck.get("shortCode") + "'";
            ArrayList<String> promoCode = Database.retrieveSingleColumnData(selectQueryPromo);
            if (promoCode.size() == 1) {
                String selectQueryStartDate = "SELECT startDate FROM promo WHERE promoCode='" + promoCode.get(0) + "'";
                ArrayList<String> startDateList = Database.retrieveSingleColumnData(selectQueryStartDate);
                String selectQueryEndDate = "SELECT endDate FROM promo WHERE promoCode='" + promoCode.get(0) + "'";
                ArrayList<String> endDateList = Database.retrieveSingleColumnData(selectQueryEndDate);

                //Converts String DateTime (from Arraylist) into LocalDateTIme data type
                LocalDateTime startDate = LocalDateTime.parse(startDateList.get(0),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                LocalDateTime endDate = LocalDateTime.parse(endDateList.get(0),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                if (timeExecuted.isAfter(startDate) && timeExecuted.isBefore(endDate)) {
                    Pattern pattern = Pattern.compile("[A-Z][a-z]+, [A-Z][a-z]+");
                    Matcher matcher = pattern.matcher(smsToCheck.get("message"));
                    if (smsToCheck.get("message") == "PROMO" || smsToCheck.get("message") == "PROMO2" ||
                            smsToCheck.get("message") == "PROMO3" || smsToCheck.get("message") == "REGISTER") {
                        newSMS.setSMSSTATUS("SUCCESSFUL SMS");
                    } else if (matcher.find()) {
                        newSMS.setSMSSTATUS("SUCCESSFUL SMS");
                    }
                    else {
                        newSMS.setSMSSTATUS("FAILED SMS");
                    }
                } else {
                    newSMS.setSMSSTATUS("FAILED SMS");
                }
            } else {
                newSMS.setSMSSTATUS("FAILED SMS");
            }
            logger.log(Level.INFO, "SMS Checker : {0}", newSMS.getSMSSTATUS());
            newSMS.insertSMS();
        }
    }
}
