package controller;

import model.Customer;

import java.util.Comparator;

public class SortIdWithCustomer implements Comparator<Customer> {


    @Override
    public int compare(Customer o1, Customer o2) {

        return o1.getId().substring(3,7).compareTo(o2.getId().substring(3,7));
    }
}
