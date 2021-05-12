package controller;

import commons.*;
import model.Computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerManager {

    public static final String ENTER_ID ="Enter computer ID";
    public static final String INVALID_ID = "computer ID must be fomat MC-XXXX";
    public static final String ENTER_STATUS ="Enter computer status";
    public static final String INVALID_STATUS = "computer status must be fomat ON/OFF";

    private static List<Computer> computerList = new ArrayList<>();



    public static void addNewComputer( ) {
        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);
        Computer computer = new Computer();
        System.out.println("Enter Computer Name");
        computer.setName(ScannerUntil.scanner.nextLine());
        computer.setId(FunctionValidation.getValiId(computer,ENTER_ID,INVALID_ID));
        while (findById(computer.getId()) != null){
            System.err.println("already exist Id");
            computer.setId(FunctionValidation.getValiId(computer,ENTER_ID,INVALID_ID));
        }
        computer.setStatus(FunctionValidation.getValidStatus(ENTER_STATUS,INVALID_STATUS));


        computerList.add(computer);
        computerList.sort(new SortByIdWithComputer());
        WriteFile.writeComputer((ArrayList<Computer>) computerList);
        System.out.println("Add new computer succesfull");

    }


    public static Computer findById(String id) {
        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);

        return computerList.stream().filter(
                computer1 -> computer1.getId().equals(id))
                .findFirst().orElse(null);
    }

    public static void deleteComputerById(String id){

//        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);
        Computer computer = findById(id);
        if(computer != null) {
            computerList.remove(computer);
            WriteFile.writeComputer((ArrayList<Computer>) computerList);
            System.out.println("Delete computer succesfully");
        }else {
            System.out.println("not find  id");
        }
    }

    public static void show() {
        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);
        GenericFunction.displayList((ArrayList)computerList);

    }
    public static void show(String id){
//        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);
        Computer computer = null;
        computer = findById(id);
        if(computer != null){
            Menu.showColComputer();
            System.out.println(computer);;
        } else
            System.out.println("not find");

    }

    public static Computer findByName(String name){
        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);

        return computerList.stream().filter(
                computer1 -> computer1.getName().equals(name))
                .findFirst().orElse(null);
    }

    public static void setStatus(String name){
        computerList = GenericFunction.getListFromCSV(GenericFunction.EntityType.COMPUTER);
        Computer computer = findByName(name);
        computerList.remove(computer);
        computer.setStatus("ON");
        computerList.add(computer);
        WriteFile.writeComputer((ArrayList<Computer>) computerList);
    }


}
