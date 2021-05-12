package commons;



import com.opencsv.CSVWriter;
import model.BookingComputer;
import model.Computer;
import model.Customer;
import model.Employee;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class WriteFile {

    // the delimiter to use for separating entries
    public static final char DEFAULT_SEPARATOR = ',';
    //  the character to use for quoted elements
    public static final char DEFAULT_QUOTE = '"';
    // the line number to skip for start reading
    public static final int NUM_OF_LINE_SKIP = 1;

//    public static final String pathComputer = "./src/main/java/data/Computer.csv";
    public static final String pathComputer = "./data/Computer.csv";
//    public static final String pathEmployee = "./src/main/java/data/Employee.csv";
    public static final String pathCustomer = "./data/Customer.csv";
//    public static final String pathCustomer = "./src/main/java/data/Customer.csv";
    public static final String pathBookingComputer = "./data/Bill.csv";
//    public static final String pathBookingComputer = "./src/main/java/data/Bill.csv";
    public static final String pathEmployee = "./data/Employee.csv";

    public static String[] headerColComputer = new String[]{"name","id","status"};
    public static String[] headerColCustomer = new String[]{"name","id","phone","email"};
    public static String[] headerColBookingComputer = new String[] {"id","customer","computer","timeUse","price","date","status"};
    public static String[] headerEmployee = new String[]{"user","password"};

    public static void writeComputer(ArrayList<Computer> arrayList){

        try(Writer writer = new FileWriter(pathComputer);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)){
            csvWriter.writeNext(headerColComputer);
            for (Computer computer : arrayList) {
                csvWriter.writeNext(new String[] {
                        computer.getName(),
                        String.valueOf(computer.getId()),
                        String.valueOf(computer.getStatus())
                });
            }
            csvWriter.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    public static void writeEmployee(ArrayList<Employee> arrayList){
//
//    }
    public static void writeCustomer(ArrayList<Customer> arrayList){
        try(Writer writer = new FileWriter(pathCustomer);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)){
            csvWriter.writeNext(headerColCustomer);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[] {
                        customer.getName(),
                        customer.getId(),
                        customer.getPhone(),
                        customer.getEmail()
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeBill(ArrayList<BookingComputer> arrayList){

        try(Writer writer = new FileWriter(pathBookingComputer);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)){
            csvWriter.writeNext(headerColBookingComputer);
            for (BookingComputer bookingComputer : arrayList) {
                csvWriter.writeNext(new String[] {
                        bookingComputer.getId(),
                        bookingComputer.getCustomer(),
                        bookingComputer.getComputer(),
                        (bookingComputer.getTimeUse()),
                        (bookingComputer.getPrice()),
                        (bookingComputer.getDate()),
                        bookingComputer.getStatus()

                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployee(ArrayList<Employee> arrayList){

        try(Writer writer = new FileWriter(pathEmployee);
            CSVWriter csvWriter = new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)){
            csvWriter.writeNext(headerEmployee);
            for (Employee employee : arrayList) {
                csvWriter.writeNext(new String[] {
                        employee.getUser(),

                        employee.getPassword()

                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
