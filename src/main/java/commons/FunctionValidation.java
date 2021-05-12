package commons;

import handleexception.EmailException;
import handleexception.PhoneNumberException;
import model.BookingComputer;
import model.Computer;
import model.Customer;

public class FunctionValidation {
    private static String patten = "";

    public static boolean isValidNumber(String str){
        patten = "^\\d{1,4}$";
        return str.matches(patten);
    }
    public static String getValidNumber(String strDisplay, String errMess) {
        System.out.println(strDisplay);
        String result = ScannerUntil.scanner.nextLine();
        if(!isValidNumber(result)){
            System.err.println(errMess);
            result = getValidNumber(strDisplay,errMess);
        }
        return result;
    }

    //status

    public static boolean isValidStatus(String str) {
        patten = "^(ON|OFF)$";
        return str.matches(patten);
    }

    public static String getValidStatus(String strDisplay, String errMess){
        System.out.println(strDisplay);
        String result = ScannerUntil.scanner.nextLine();
        if(!isValidStatus(result)){
            System.err.println(errMess);
           result = getValidStatus(strDisplay,errMess);
        }
        return result;
    }

    // name
    public static boolean isValidName(String str) {
        patten = "[A-Z][a-zA-Z][^#&<>\"~;$^%{}?]{1,20}$";
        return str.matches(patten);
    }
    public static String getValidName(String strDisplay, String errMess){
        System.out.println(strDisplay);
        String result = ScannerUntil.scanner.nextLine();
        if(!isValidName(result)){
            System.err.println(errMess);
            result = getValidName(strDisplay,errMess);
        }
        return result;
    }

    // ID

    public static <E> boolean isValidId(E object,String str) {
        if(object instanceof Customer){
            patten = "^KH-\\d{4}$";
        }
        else if(object instanceof Computer) {
            patten = "^MC-\\d{4}$";
        }
        return str.matches(patten);
    }

    public static <E> String getValiId(E object, String strDisplay, String errmess) {
        System.out.println(strDisplay);
        String result = ScannerUntil.scanner.nextLine();
        if(!isValidId(object,result)){
            System.err.println(errmess);
            result = getValiId(object,strDisplay,errmess);
        }
        return result;
    }




    // customer
    // email
    public static boolean isValidEmail(String str) {
        patten = "^[a-z0-9._-]+@[a-z0-9._-]+\\.[a-z]{2,3}";
        return str.matches(patten);
    }

    public static String getValidEmail(String strDisplay, String errMess) {
        String result =null;
        System.out.println(strDisplay);
        try{
            result = ScannerUntil.scanner.nextLine();
            if(!isValidEmail(result)) {
                throw new EmailException(errMess);
            }
        } catch (EmailException e){
            System.err.println(errMess);
            result = getValidEmail(strDisplay,errMess);
        }
        return result;
    }

    // phone

    public static boolean isValidPhone(String str) {
        patten = "^\\d{9,12}$";
        return str.matches(patten);
    }
    public static String getValidPhone(String strDisplay,String errmess) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result =ScannerUntil.scanner.nextLine();
            if(!isValidPhone(result)){
                throw new PhoneNumberException(errmess);
            }
        }catch (PhoneNumberException e){
            System.err.println(errmess);
            result = getValidPhone(strDisplay,errmess);
        }
        return result;
    }



}
