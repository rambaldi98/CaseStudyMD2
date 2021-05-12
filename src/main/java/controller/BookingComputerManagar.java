package controller;

import commons.*;
import model.BookingComputer;
import model.Computer;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class BookingComputerManagar {
    public static final String ENTER_STATUS ="Enter book status";
    public static final String INVALID_STATUS = "book status must be fomat ON/OFF";
    public static final String ENTER_TIME_USE ="Enter time use";
    public static final String INVALID_TIME_USE = " time must be real number";


    private static List<BookingComputer> bookingComputerList = new ArrayList<>();


    public static void addNewBill(){
        bookingComputerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.BOOKINGCOMPUTER);
        BookingComputer bookingComputer = new BookingComputer();

        String idCustomer = FunctionValidation.getValiId(new Customer(),CustomerManager.ENTER_ID,CustomerManager.INVALID_ID);
        while (CustomerManager.findById(idCustomer) == null) {
            System.err.println("already exist Id");
            idCustomer = FunctionValidation.getValiId(new Customer(),CustomerManager.ENTER_ID,CustomerManager.INVALID_ID);
        }
        bookingComputer.setCustomer(CustomerManager.findById(idCustomer).getName());

     String idComputer = FunctionValidation.getValiId(new Computer(),ComputerManager.ENTER_ID,ComputerManager.INVALID_ID);
        while (ComputerManager.findById(idComputer) == null ||ComputerManager.findById(idComputer).getStatus().equals("ON")) {
            System.err.println("already exist Id or computer is not ready");
            idComputer = FunctionValidation.getValiId(new Computer(),ComputerManager.ENTER_ID,ComputerManager.INVALID_ID);
        }
        bookingComputer.setComputer(ComputerManager.findById(idComputer).getName());


        bookingComputer.setTimeUse((FunctionValidation.getValidNumber(ENTER_TIME_USE,INVALID_TIME_USE)));


        bookingComputer.setStatus(FunctionValidation.getValidStatus(ENTER_STATUS,INVALID_STATUS));

        bookingComputerList.add(bookingComputer);
        WriteFile.writeBill((ArrayList<BookingComputer>) bookingComputerList);
        System.out.println(" Add new Bill successfull");
    }
//    public static void deleteBill(BookingComputer bookingComputer){
//        bookingComputerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.BOOKINGCOMPUTER);
//        if(bookingComputer != null) {
//            bookingComputerList.remove(bookingComputer);
//            WriteFile.writeBill((ArrayList<BookingComputer>) bookingComputerList);
//            System.out.println("delete Bill succesfull");
//        }
//        else
//            System.out.println("not find bill");
//    }
    public static void deleteBill(String idCustomer){
        bookingComputerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.BOOKINGCOMPUTER);
       if(CustomerManager.isIdCustomer(idCustomer)){
           String name = CustomerManager.findById(idCustomer).getName();
          BookingComputer bookingComputer = bookingComputerList.stream().filter(
                  o -> o.getCustomer().equals(name))
                  .findFirst().orElse(null);
           if(bookingComputer != null) {
               bookingComputerList.remove(bookingComputer);
               WriteFile.writeBill((ArrayList<BookingComputer>) bookingComputerList);
               System.out.println("delete Bill succesfull");
           }
           else
               System.out.println("not find bill");
       }
       else {
           System.out.println("not find bill");
       }
    }

    public static void show(){
        bookingComputerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.BOOKINGCOMPUTER);
        GenericFunction.displayList((ArrayList)bookingComputerList);
    }
    public static void show(String id){
        bookingComputerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.BOOKINGCOMPUTER);
        if(CustomerManager.isIdCustomer(id)){
            String name = CustomerManager.findById(id).getName();
            BookingComputer bookingComputer = bookingComputerList.stream().filter(
                    o -> o.getCustomer().equals(name))
                    .findFirst().orElse(null);
            if(bookingComputer != null) {
                Menu.showColBill();
                System.out.println(bookingComputer.toString());
            }
            else
                System.out.println("not find bill");
        }
        else {
            System.out.println("not find bill");
        }
    }

    public static void payBill(String id){
        bookingComputerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.BOOKINGCOMPUTER);
        BookingComputer bookingComputer = bookingComputerList.stream().filter(
                o -> o.getId().equals(id)).findFirst().orElse(null);
        if(bookingComputer == null){
            System.out.println("not find bill");
        }else if(bookingComputer.getStatus().equals("ON"))
            System.out.println("bill paid");
        else {
            bookingComputerList.remove(bookingComputer);
            bookingComputer.setStatus("ON");
            ComputerManager.setStatus(bookingComputer.getComputer());
            bookingComputerList.add(bookingComputer);
            WriteFile.writeBill((ArrayList<BookingComputer>) bookingComputerList);
            System.out.println(" pay bill successfull ");

        }
    }
}
