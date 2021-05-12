package model;

import java.time.LocalDate;

import static java.util.Date.parse;

public class BookingComputer {

    private String id ;
    private String customer ;
    private String computer ;
    private String timeUse;
    private String price;
    private String date ;
    private String status ;

    private static double priceForOnceHour = 1000;

    private static Integer sId = 0;

    public BookingComputer() {
        this.id =  "BILL-" + String.valueOf(++sId);
        this.date = String.valueOf(LocalDate.now());
        this.status = "OFF";
    }

    public BookingComputer(String id, String customer, String computer, String timeUse, String price, String date, String status) {
        this.id = id;
        this.customer = customer;
        this.computer = computer;
        this.timeUse = timeUse;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public BookingComputer(double timeUse, String status) {
        this.id = String.valueOf(++sId);
        this.timeUse = String.valueOf(timeUse);
        this.price = String.valueOf(timeUse * priceForOnceHour);
        this.date = String.valueOf(LocalDate.now());
        this.status = status;
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
        setPrice();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice() {
        this.price =  String.valueOf( Double.parseDouble(timeUse) * priceForOnceHour);
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = String.valueOf(date);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static double getPriceForOnceHour() {
        return priceForOnceHour;
    }

    public static void setPriceForOnceHour(double priceForOnceHour) {
        BookingComputer.priceForOnceHour = priceForOnceHour;
    }

    public static Integer getsId() {
        return sId;
    }

    public static void setsId(Integer sId) {
        BookingComputer.sId = sId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public static double getPriceForOnceHour() {
//        return priceForOnceHour;
//    }
//
//    public static void setPriceForOnceHour(double priceForOnceHour) {
//        BookingComputer.priceForOnceHour = priceForOnceHour;
//    }



    public String toString(Integer d) {
        return "BookingComputer{" +
                "id='" + id + '\'' +
                ", computer=" + customer +
                ", timeUse=" + timeUse +
                ", price=" + price +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return id + "\t\t"+
                customer +"\t\t\t\t"+
                computer +"\t\t\t\t"+
                timeUse +"\t\t\t\t"+
                price +"\t\t"+
                 date +"\t\t"+
                 status;
    }
}
