package sms_galola;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {

    final private static Logger logger = Logger.getLogger(Database.class.getName());
    private static Connection connection = null;


    public static void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/smsdatabase?useTimezone=true&serverTimezone=UTC", "root", "Patrickjane18_a");
            logger.info("Connected");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Connection not established.", e);
        }
    }

    public static void disconnectDB() {
        try {
            if (connection != null) {
                connection.close();
                logger.info("Disconnected");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Connection not terminated.", e);

        }
    }


    public static void insertData(String insertQuery) {
        PreparedStatement statement = null;
        int result = 0;

        try {
            statement = connection.prepareStatement(insertQuery);
            result = statement.executeUpdate();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
    }

    public static ArrayList<String> retrievePromoData(String selectQuery) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = connection.prepareStatement(selectQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + "\n");
                result.add(resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        String presentResult = "";
        for (int i = 0; i < result.size(); i++) {
            presentResult = presentResult + "Record " + (i + 1) + ": " + result.get(i) + "\n";
        }
        logger.log(Level.INFO, "Retrieved : \n{0}", presentResult);

        return result;
    }

    public static ArrayList<String> retrieveSMSData(String selectQuery) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = connection.prepareStatement(selectQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + ", "
                        + resultSet.getString(6) + ", "
                        + resultSet.getString(7) + ", "
                        + resultSet.getString(8) + "\n");
                result.add(resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + ", "
                        + resultSet.getString(6) + ", "
                        + resultSet.getString(7) + ", "
                        + resultSet.getString(8));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        String presentResult = "";
        for (int i = 0; i < result.size(); i++) {
            presentResult = presentResult + "Record " + (i + 1) + ": " + result.get(i) + "\n";
        }
        logger.log(Level.INFO, "Retrieved : \n{0}", presentResult);

        return result;
    }

    public static ArrayList<String> retrieveSingleColumnData(String selectQuery) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = connection.prepareStatement(selectQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + "\n");
                result.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        String presentResult = "";
        for (int i = 0; i < result.size(); i++) {
            presentResult = presentResult + "Record " + (i + 1) + ": " + result.get(i) + "\n";
        }
        logger.log(Level.INFO, "Retrieved : \n{0}", presentResult);

        return result;
    }


    //For TestSMSChecker
    public static String retrieveSMSStatus(Map<String, String> smsToRetrieve) {
        String selectQuery = "SELECT SMSSTATUS FROM sms WHERE MSISDN='" + smsToRetrieve.get("mobileNumber") +
                "' AND SHORTCODE=" + smsToRetrieve.get("shortCode") +
                " AND CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR(500))='" + smsToRetrieve.get("message") + "'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = connection.prepareStatement(selectQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + "\n");
                result.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        return result.get(0);
    }


    //For generating reports
    public static ArrayList<String> retrieveSMSDataGivenSMSStatus(String SMSStatus) {
        String selectQuery = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                "FROM sms WHERE SMSSTATUS='" + SMSStatus + "' ORDER BY SENDER, SHORTCODE";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = connection.prepareStatement(selectQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + ", "
                        + resultSet.getString(6) + ", "
                        + resultSet.getString(7) + ", "
                        + resultSet.getString(8) + "\n");
                result.add(resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + ", "
                        + resultSet.getString(6) + ", "
                        + resultSet.getString(7) + ", "
                        + resultSet.getString(8));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        String presentResult = "";
        for (int i = 0; i < result.size(); i++) {
            presentResult = presentResult + "Record " + (i + 1) + ": " + result.get(i) + "\n";
        }
        logger.log(Level.INFO, "Retrieved : \n{0}", presentResult);

        return result;
    }

    public static ArrayList<String> retrieveSMSDataBySMSTypeGivenSMSStatus(String SMSStatus) {
        String selectQuery = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                "FROM sms WHERE SMSSTATUS='" + SMSStatus + "' ORDER BY SHORTCODE, SENDER";

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            statement = connection.prepareStatement(selectQuery);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                logger.log(Level.INFO, resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + ", "
                        + resultSet.getString(6) + ", "
                        + resultSet.getString(7) + ", "
                        + resultSet.getString(8) + "\n");
                result.add(resultSet.getString(1) + ", "
                        + resultSet.getString(2) + ", "
                        + resultSet.getString(3) + ", "
                        + resultSet.getString(4) + ", "
                        + resultSet.getString(5) + ", "
                        + resultSet.getString(6) + ", "
                        + resultSet.getString(7) + ", "
                        + resultSet.getString(8));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "SQLException", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    statement.close();
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "ERROR IN CLOSING", e);
            }
        }
        String presentResult = "";
        for (int i = 0; i < result.size(); i++) {
            presentResult = presentResult + "Record " + (i + 1) + ": " + result.get(i) + "\n";
        }
        logger.log(Level.INFO, "Retrieved : \n{0}", presentResult);

        return result;
    }

    public static ArrayList<String> retrieveListOfPeople() {
        String selectQuerySuccessfulSMS = "SELECT CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE " +
                "FROM sms WHERE SMSSTATUS='SUCCESSFUL SMS'";
        ArrayList<String> SuccessfulSMSList = retrieveSingleColumnData(selectQuerySuccessfulSMS);
        ArrayList<String> NameList = new ArrayList<>();
        for (String s : SuccessfulSMSList) {
            Pattern pattern = Pattern.compile("[A-Z][a-z]+, [A-Z][a-z]+");
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                NameList.add(s);
            }
        }
        Set<String> smsNotAName = new HashSet<>(List.of(
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
                "PROMO", "PROMO2", "PROMO3", "REGISTER"));
//            for (String n : NameList) {
//                if (smsNotAName.contains(n)) {
//                    NameList.remove(n);
//                }
//            }

        Iterator<String> itr = NameList.iterator();
        while (itr.hasNext()){
            String name = itr.next();
            if (smsNotAName.contains(name)){
                itr.remove();
            }
        }

        String presentResult = "";
        for (int i = 0; i < NameList.size(); i++) {
            presentResult = presentResult + "Record " + (i + 1) + ": " + NameList.get(i) + "\n";
        }
        logger.log(Level.INFO, "List of Persons who Joined the Promo : \n{0}", presentResult);
        return NameList;
    }

    public static void totalCountOfSMSReceivedBySystem() {
        SMS retrieve = new SMS();
        ArrayList<String> receivedList = retrieve.retrieveSMSReceivedBySystem();
        Integer count = 0;
        for (String s : receivedList){
            count++;
        }
        logger.log(Level.INFO, "Total Count of SMS Received by System : {0}", count);

    }

    public static void totalCountOfSMSSentBySystem() {
        SMS retrieve = new SMS();
        ArrayList<String> receivedList = retrieve.retrieveSMSSentBySystem();
        Integer count = 0;
        for (String s : receivedList){
            count++;
        }
        logger.log(Level.INFO, "Total Count of SMSSent by System : {0}", count);

    }
}




