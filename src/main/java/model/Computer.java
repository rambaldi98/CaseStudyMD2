package model;


public class Computer {

    private String name;

    private String id;

    private String status = "false";

    public Computer() {
    }

    public Computer(String name, String id, String status) {
        this.name = name;
        this.id = id;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String toString(int d) {
        return "Computer{" +
                "computerName='" + name + '\'' +
                ", computerId=" + id +
                ", computerStatus=" + status +
                '}';
    }
    @Override
    public String toString(){
        return name +"\t\t"+
                id + "\t\t"+
                status;
    }

}
