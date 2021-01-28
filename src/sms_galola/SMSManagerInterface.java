package sms_galola;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface SMSManagerInterface {
    void insertSMS();
    ArrayList<String> retrieveSMSGivenStartDateAndEndDate(LocalDateTime startDate, LocalDateTime endDate);
    ArrayList<String> retrieveSMSGivenPromoCode(String promoCode);
    ArrayList<String> retrieveSMSGivenMsisdn(String msisdn);
    ArrayList<String> retrieveSMSSentBySystem();
    ArrayList<String> retrieveSMSReceivedBySystem();
    ArrayList<String> retrieveSMSGivenSeveralMsisdn(String... values);

}
