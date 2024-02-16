public class Teacher {
    String name;
    String telNo;
    String branch;

    Teacher(String name, String branch, String telNo){
        this.name = name;
        this.branch = branch;
        this.telNo = telNo;
    }

    void print(){
        System.out.println("Name: " + this.name);
        System.out.println("Branch: " + this.branch);
        System.out.println("Tel: " + this.telNo);
    }
}
