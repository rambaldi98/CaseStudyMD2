package controller;

import commons.FunctionValidation;
import commons.GenericFunction;
import commons.Menu;
import commons.ScannerUntil;
import model.BookingComputer;
import model.Customer;
import model.Employee;

import java.util.List;

import static controller.ComputerManager.ENTER_ID;
import static controller.ComputerManager.addNewComputer;
import static controller.CustomerManager.*;

//package controller;
//
//import commons.Menu;
//import commons.ScannerUntil;
//import model.Computer;
//import model.Customer;
//
public class MainController {

    public static void menuLogin(){
        List<Employee> employeeList = GenericFunction.getListFromCSV(GenericFunction.EntityType.EMPLOYEE);
        System.out.println("enter admin user");
        String user = ScannerUntil.scanner.nextLine().trim();
        System.out.println("enter admin password");
        String password = ScannerUntil.scanner.nextLine().trim();
        boolean check = false;
        for (Employee e: employeeList
        ) {
            if(e.getUser().equals(user)&&e.getPassword().equals(password)){
                check = true;
                break;
            }
        }
        if(check){
            processMenuSystem();
        }
        else {
            System.err.println("Enter again admin");
            menuLogin();
        }
    }
//
    public static void processMenuSystem() {
//
        Menu.displayMenuMain();
        switch (ScannerUntil.scanner.nextLine()) {
            case "1":
                computerHandle();
                break;
            case "2":
                customerHandle();
                break;
            case "3":
                billHandle();
                break;
            case "0":
                menuLogin();
                break;
            default:
                Menu.menuContinue();
                processMenuSystem();
                break;
        }
    }


    public static void computerHandle() {

        Menu.displayMenuComputerManager();

        switch (ScannerUntil.scanner.nextLine()) {
            case "1":
                addNewComputer();
                break;
            case "2":
                deleteComputer();

                break;

            case "3":
                showComputerById();
                break;

            case "4":
                showAllComputer();
               break;


            case "0":
                processMenuSystem();
                break;
            default:

                break;

        }
        Menu.menuContinue();
        computerHandle();

    }

    public static void deleteComputer() {
        System.out.println("Enter computer id ");
        ComputerManager.deleteComputerById( ScannerUntil.scanner.nextLine());

    }
    public static void showComputerById() {
        System.out.println("Enter computer id ");


        ComputerManager.show(ScannerUntil.scanner.nextLine());

    }

    public static void showAllComputer(){
        ComputerManager.show();
    }

    public static void customerHandle() {

        Menu.displayMenuCustomerManager();

        switch (ScannerUntil.scanner.nextLine()) {
            case "1":
                addNewCustomer();
                break;
            case "2":
                deleteCustomer();
                break;
            case "3":
                showCustomerById();
                break;
            case "4":
                showAllCustomer();
                break;
            case "0":
                processMenuSystem();
                break;
            default:
                break;
        }
        Menu.menuContinue();
        customerHandle();

    }

    public static void addNewCustomer() {
        CustomerManager.addNewCustomer();
    }
    public static void deleteCustomer() {
        System.out.println("Enter customer id ");
        CustomerManager.deleteCustomer( ScannerUntil.scanner.nextLine());
    }

    public static void showCustomerById() {
        System.out.println("enter customer id");
        CustomerManager.show(ScannerUntil.scanner.nextLine());
    }
    public static void showAllCustomer() {
        CustomerManager.show();
    }

    public static void billHandle(){
        Menu.displayMenuBillManager();
        switch (ScannerUntil.scanner.nextLine()){
            case "1":
                addNewBill();
                break;
            case "2":
                deleteBill();
                break;
            case "3":
                showABill();
                break;
            case "4":
                showAllBill();
                break;
            case "5":
                payBill();
                break;
            case "0":
                processMenuSystem();
                break;
            default:
                break;
        }
        Menu.menuContinue();
        billHandle();
    }
    public static void addNewBill(){
        BookingComputerManagar.addNewBill();
    }
    public static void deleteBill(){
//        System.out.println("Enter customer id ");
        BookingComputerManagar.deleteBill(FunctionValidation.getValidName(CustomerManager.ENTER_ID,INVALID_ID));
    }
    public static void showAllBill(){
        BookingComputerManagar.show();
    }
    public static void showABill(){
        BookingComputerManagar.show((FunctionValidation.getValidName(CustomerManager.ENTER_ID,INVALID_ID)));
    }

    public static void payBill(){
        System.out.println("enter BIll ID");
        BookingComputerManagar.payBill(ScannerUntil.scanner.nextLine().trim());
    }


}
