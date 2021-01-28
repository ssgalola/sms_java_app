package sms_galola;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SMS implements SMSManagerInterface{
    private String MSISDN;
    private String RECIPIENT;
    private String SENDER;
    private Integer SHORTCODE;
    private String TRANSACTIONID;
    private LocalDateTime TIMESTAMP;
    private String MESSAGE;
    private String SMSSTATUS;

    public SMS() {

    }

    final private static Logger logger = Logger.getLogger(Database.class.getName());

    //SMS Getters and Setters
    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getRECIPIENT() {
        return RECIPIENT;
    }

    public void setRECIPIENT(String RECIPIENT) {
        this.RECIPIENT = RECIPIENT;
    }

    public String getSENDER() {
        return SENDER;
    }

    public void setSENDER(String SENDER) {
        this.SENDER = SENDER;
    }

    public Integer getSHORTCODE() {
        return SHORTCODE;
    }

    public void setSHORTCODE(Integer SHORTCODE) {
        this.SHORTCODE = SHORTCODE;
    }

    public String getTRANSACTIONID() {
        return TRANSACTIONID;
    }

    public void setTRANSACTIONID(String TRANSACTIONID) {
        this.TRANSACTIONID = TRANSACTIONID;
    }

    public LocalDateTime getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(LocalDateTime TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getSMSSTATUS() {
        return SMSSTATUS;
    }

    public void setSMSSTATUS(String SMSSTATUS) {
        this.SMSSTATUS = SMSSTATUS;
    }


    //SMS Constructor
    public SMS(String MSISDN, String RECIPIENT, String SENDER,
               Integer SHORTCODE, String TRANSACTIONID, LocalDateTime TIMESTAMP,
               String MESSAGE){
        this.MSISDN = MSISDN;
        this.RECIPIENT = RECIPIENT;
        this.SENDER = SENDER;
        this.SHORTCODE = SHORTCODE;
        this.TRANSACTIONID = TRANSACTIONID;
        this.TIMESTAMP = TIMESTAMP;
        this.MESSAGE = MESSAGE;
    }



    //Functions implemented relative to SMSManagerInterface
    @Override
    public void insertSMS() {
        String insertQuery = "INSERT INTO sms (MSISDN, RECIPIENT, SENDER, " +
                "SHORTCODE, TRANSACTIONID, TIMESTAMP, MESSAGE, SMSSTATUS) " +
                "VALUES ('" + getMSISDN() + "', '" + getRECIPIENT() + "', '" + getSENDER() + "', " +
                             getSHORTCODE() + ", '" + getTRANSACTIONID() + "', '" + getTIMESTAMP() + "', " +
                             "AES_ENCRYPT('" + getMESSAGE() + "', SHA2('key', 512)), '" + getSMSSTATUS() + "')";
        Database.insertData(insertQuery);
    }

    @Override
    public ArrayList<String> retrieveSMSGivenStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate) {
        String selectQuery = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                             "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                             "FROM sms WHERE TIMESTAMP BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                             "ORDER BY SHORTCODE, SENDER";
        return Database.retrieveSMSData(selectQuery);
    }

    @Override
    public ArrayList<String> retrieveSMSGivenPromoCode(String promoCode) {
        String selectQueryPromo = "SELECT shortCode FROM promo WHERE promoCode='" + promoCode + "'";
        ArrayList<String> shortCode = Database.retrieveSingleColumnData(selectQueryPromo);
        String selectQuerySMS = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                                "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                                "FROM sms WHERE SHORTCODE='" + shortCode.get(0) + "' " +
                                "ORDER BY SHORTCODE, SENDER";
        return Database.retrieveSMSData(selectQuerySMS);
    }

    @Override
    public ArrayList<String> retrieveSMSGivenMsisdn(String msisdn) {
        String selectQuery = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                             "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                             "FROM sms WHERE MSISDN='" + msisdn + "' " +
                             "ORDER BY SHORTCODE, SENDER";
        return Database.retrieveSMSData(selectQuery);

    }

    @Override
    public ArrayList<String> retrieveSMSSentBySystem() {
        String selectQueryPromo = "SELECT shortCode FROM promo";
        ArrayList<String> shortCodeList = Database.retrieveSingleColumnData(selectQueryPromo);
        String selectQuerySMS = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                                "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                                "FROM sms WHERE SENDER IN (";
        for (String s : shortCodeList) {
            selectQuerySMS = selectQuerySMS + "'" + s + "', ";
        }
        selectQuerySMS = selectQuerySMS.substring(0, selectQuerySMS.length()-2) + ") ORDER BY SHORTCODE, SENDER";
        return Database.retrieveSMSData(selectQuerySMS);
    }

    @Override
    public ArrayList<String> retrieveSMSReceivedBySystem() {
        String selectQueryPromo = "SELECT shortCode FROM promo";
        ArrayList<String> shortCodeList = Database.retrieveSingleColumnData(selectQueryPromo);
        String selectQuerySMS = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                                "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                                "FROM sms WHERE RECIPIENT IN (";
        for (String s : shortCodeList) {
            selectQuerySMS = selectQuerySMS + "'" + s + "', ";
        }
        selectQuerySMS = selectQuerySMS.substring(0, selectQuerySMS.length()-2) + ") ORDER BY SHORTCODE, SENDER";
        return Database.retrieveSMSData(selectQuerySMS);
    }

    @Override
    public ArrayList<String> retrieveSMSGivenSeveralMsisdn(String... values) {
        String selectQuerySMS = "SELECT MSISDN, RECIPIENT, SENDER, SHORTCODE, TRANSACTIONID, TIMESTAMP," +
                                "CAST(AES_DECRYPT(MESSAGE, SHA2('key', 512)) AS CHAR) as MESSAGE, SMSSTATUS " +
                                "FROM sms WHERE MSISDN IN (";
        for (String s : values) {
            selectQuerySMS = selectQuerySMS + "'" + s + "', ";
        }
        selectQuerySMS = selectQuerySMS.substring(0, selectQuerySMS.length()-2) + ") ORDER BY SHORTCODE, SENDER";
        return Database.retrieveSMSData(selectQuerySMS);
    }


}
