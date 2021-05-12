package controller;

import model.Computer;
import model.Customer;

import java.util.Comparator;

public class SortByIdWithComputer implements Comparator<Computer> {

    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getId().substring(3,7).compareTo(o2.getId().substring(3,7));
    }
}
