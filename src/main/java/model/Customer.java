package model;

public class Customer {
    private String name;
    private  String id;
    private String phone;
    private String email;


    public Customer() {
    }

    public Customer(String name, String id, String phone, String email) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toString(int d) {
        return "Customer{" +
                "customerName='" + name + '\'' +
                ", customerId=" + id +
                ", customerPhone='" + phone + '\'' +
                ", getCustomerEmail='" + email + '\'' +
                '}';
    }
    @Override
    public String toString(){
        return  name + "\t\t" +
                id + "\t\t" +
                phone + "\t\t" +
                email + "\t\t";
    }
}
