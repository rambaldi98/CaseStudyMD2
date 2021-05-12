package commons;



import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.BookingComputer;
import model.Computer;
import model.Customer;
import model.Employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static commons.WriteFile.*;

public class GenericFunction {
    public enum EntityType{
        CUSTOMER,
        COMPUTER,
        BOOKINGCOMPUTER,
        EMPLOYEE
    }

    public static <E> void displayList(ArrayList<E> list){

        E a = list.get(0);


        if( a instanceof Computer){
            System.out.println("-----------list Computer--------");
            System.out.println(
                    "name \t\tid\t\tstatus"
            );
        } else if(a instanceof Customer){
            System.out.println("-----------list customer--------");
            System.out.println(
                    "name\t\t\tid\t\t\tphone\t\t\temail"
            );
        } else if(a instanceof  BookingComputer) {
            System.out.println("-----------list bill--------");
            System.out.println(
                    "id\t\t\tCustomer\t\t\tComputer\t\t\tTimeUse\t\t\tprice\t\t\tdate\t\t\tstatus"
            );
        }


        for(E b : list){

            if(b instanceof Computer)
                System.out.println(((Computer)b).toString());
//            else if(b instanceof Employee)
//                System.out.println(((Employee)b).toString());
            else if(b instanceof Customer)
                System.out.println(((Customer)b).toString());
            else if(b instanceof BookingComputer)
                System.out.println(((BookingComputer) b).toString());
        }
    }

    public static<E> ArrayList<E> getListFromCSV(EntityType entityType) {


        String csvPath = "";
        String[] headerRecord;

        switch (entityType) {
            case COMPUTER :
                csvPath = pathComputer;
                headerRecord =headerColComputer;
                break;
            case CUSTOMER:
                csvPath = pathCustomer;
                headerRecord = headerColCustomer;
                break;
            case BOOKINGCOMPUTER:
                csvPath = pathBookingComputer;
                headerRecord = headerColBookingComputer;
                break;
            case EMPLOYEE:
                csvPath = pathEmployee;
                headerRecord = headerEmployee;
                break;
            default:
                throw new IllegalStateException("unexpected" + entityType);
        }
        Path path = Paths.get(csvPath);

        if(!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(csvPath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // mapping of columns with their positions
        ColumnPositionMappingStrategy<E> strategy = new ColumnPositionMappingStrategy<>();

        switch (entityType) {
            case CUSTOMER :
                strategy.setType((Class<? extends E>) Customer.class);
                break;
            case COMPUTER:
                strategy.setType((Class<? extends E>) Computer.class);
                break;
            case BOOKINGCOMPUTER:
                strategy.setType((Class<? extends E>) BookingComputer.class);
                break;
            case EMPLOYEE:
                strategy.setType((Class<? extends E>) Employee.class);

        }
        // Set mappingStrategy type to Product Type
//        strategy.setColumnMapping(headerRecord);
        strategy.setColumnMapping(headerRecord);


        List<E> csvToBean = null;
        try{
            csvToBean = new CsvToBeanBuilder<E>(new FileReader(csvPath))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
        }catch (FileNotFoundException e){
           e.printStackTrace();
        }
        return (ArrayList<E>) csvToBean;

    }


}
