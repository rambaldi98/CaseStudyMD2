package controller;

import commons.FunctionValidation;
import commons.GenericFunction;
import commons.Menu;
import commons.WriteFile;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

    public static final String ENTER_NAME ="Enter customer name";
    public static final String INVALID_NAME = "Customer name must be capitalized";
    public static final String ENTER_ID ="Enter customer ID";
    public static final String INVALID_ID = "Customer ID must be fomat KH-XXXX";
    public static final String ENTER_PHONE ="Enter customer phone";
    public static final String INVALID_PHONE = "Customer phone fomat 0-9";
    public static final String ENTER_EMAIL ="Enter customer email";
    public static final String INVALID_EMAIL = "Customer email fomat abc@gmail.com";

    private static List<Customer> customerList = new ArrayList<>();



    public static void addNewCustomer() {
        customerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.CUSTOMER);
        Customer customer = new Customer();
        customer.setName(FunctionValidation.getValidName(ENTER_NAME,INVALID_NAME));

        customer.setId(FunctionValidation.getValiId(customer,ENTER_ID,INVALID_ID));

         while (findById(customer.getId()) != null){
             System.err.println("already exist ID");
             customer.setId(FunctionValidation.getValiId(customer,ENTER_ID,INVALID_ID));
         }

        customer.setPhone(FunctionValidation.getValidPhone(ENTER_PHONE,INVALID_PHONE));
        customer.setEmail(FunctionValidation.getValidEmail(ENTER_EMAIL,INVALID_EMAIL));

//        customerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.CUSTOMER);
        customerList.add(customer);
        customerList.sort(new SortIdWithCustomer());
        WriteFile.writeCustomer((ArrayList<Customer>) customerList);
        System.out.println("Add new customer " + customer.getName()+" Successfull");
    }

    public static Customer findById(String id) {
        customerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.CUSTOMER);
        return customerList.stream().filter(
                customer1 -> customer1.getId().equals(id))
                .findFirst().orElse(null);
    }
    public static boolean isIdCustomer(String id) {
        customerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.CUSTOMER);
        if(customerList.stream().filter(
                customer1 -> customer1.getId().equals(id))
                .findFirst().orElse(null) == null)
            return false;
        return true;
    }

    public static void deleteCustomer(String id){

        Customer customer = findById(id);
        if(customer != null) {
            customerList.remove(customer);
            WriteFile.writeCustomer((ArrayList<Customer>) customerList);
            System.out.println("Delete Customer : "+ customer.getName() + " Successfull" );
        } else {
            System.err.println(" not find  id");
        }
    }

    public static void show() {
        customerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.CUSTOMER);
//        customerList.sort(new SortIdWithCustomer());
//        System.out.println(customerList.get(0).getId().substring(3,7));
        GenericFunction.displayList((ArrayList)customerList);
    }
    public static void show(String id) {
        Customer customer = null;
        customer = findById(id);
        if(customer != null) {
            Menu.showColCustomer();
            System.out.println(customer);
        } else
            System.err.println("not find");
    }

}
