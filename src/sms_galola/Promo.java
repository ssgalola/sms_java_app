package sms_galola;

import java.time.LocalDateTime;

public class Promo {
    private String promoCode;
    private String details;
    private int shortCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    //Promo Getters and Setters
    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getShortCode() {
        return shortCode;
    }

    public void setShortCode(int shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }


    //Promo Constructor
    public Promo(String promoCode, String details, int shortCode,
                 LocalDateTime startDate, LocalDateTime endDate){
        this.promoCode = promoCode;
        this.details = details;
        this.shortCode = shortCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //InsertPromo Function (used in populating Promo Data)
    public void insertPromo() {
        String insertQuery = "INSERT INTO promo (promoCode, details, shortCode, startDate, endDate) " +
                "VALUES ('" + getPromoCode() + "', '" + getDetails() + "', " + getShortCode() + ", '" +
                getStartDate() + "', '" + getEndDate() + "');";
        Database.insertData(insertQuery);
    }


}
