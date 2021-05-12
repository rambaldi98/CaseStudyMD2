package commons;

import java.util.Scanner;
import java.util.Stack;

public class Menu {

    public static void displayMenuMain(){
        System.out.println("-------- Menu SYSTEM -------");
        System.out.println("1. Computer Manager"
                + "\n2. Customer Manager"
                + "\n3. Bill Manager"
                + "\n0. Exit"
        );
    }

    public static void displayMenuComputerManager() {
        System.out.println("------ Computer Manager------");
        System.out.println("1. Add new Computer"
                + "\n2. Delete Computer"
                + "\n3. Show Computer By ID"
                + "\n4. Show All Computer"
                + "\n0. Back to MENU SYSTEM"
        );
    }

    public static void displayMenuCustomerManager() {
        System.out.println("----------- Customer Manger ---------");
        System.out.println("1. Add new Customer"
                + "\n2. Delete Customer"
                + "\n3. Show Customer By Id"
                + "\n4. Show all Customer"
                + "\n0. Back to Menu System"
        );
    }

    public static void displayMenuBillManager() {
        System.out.println("------------- Bill Manager-----------");
        System.out.println("1. Add new Bill"
                + "\n2. Delete Bill"
                + "\n3. Show Bill By Id"
                + "\n4. Show all bill"
                + "\n5. cash pay bill"
                + "\n0. Back to Menu System"
        );
    }
    public static void menuContinue() {
        System.out.println("-----Enter to continue----------");
        ScannerUntil.scanner.nextLine();
    }
    public static void showColComputer(){
        System.out.println("Name" +"\t\t"+
                "ID" +"\t\t"+
                "Status");
    }

    public static void showColCustomer(){
        System.out.println("Name" +"\t\t"+
                "ID" +"\t\t\t"+
                "Phone" +"\t\t\t"+
                "email");
    }
    public static void showColBill(){
        System.out.println("id" + "\t\t\t"+
                "customer" +"\t\t\t"+
                "computer" +"\t\t\t"+
                "timeUse" +"\t\t\t"+
                "price" +"\t\t\t"+
                "date" +"\t\t\t"+
                "status");
    }



}
