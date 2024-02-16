public class Student {
    String name,studentIdNo;
    int classes;
    Course math;
    Course physics;
    Course chemistry;
    double average;
    boolean isPass;

    Student(String name, int classes, String studentIdNo, Course math,Course physics,Course chemistry) {
        this.name = name;
        this.classes = classes;
        this.studentIdNo = studentIdNo;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calcAverage();
        this.isPass = false;
    }

    public void addBulkExamNote(int math, int physics, int chemistry) {

        if (math>= 0 && math <= 100) {
            this.math.score = math;
        }

        if (physics >= 0 && physics <= 100) {
            this.physics.score = physics;
        }

        if (chemistry >= 0 && chemistry <= 100) {
            this.chemistry.score = chemistry;
        }
    }

    public void isPass() {
        if (this.math.score == 0 || this.physics.score == 0 || this.chemistry.score == 0) {
            System.out.println("Notes not entered completely.");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Average : " + this.average);
            if (this.isPass) {
                System.out.println("Pass the class. ");
            } else {
                System.out.println("Failed the class.");
            }
        }
    }

    public void calcAverage() {
        double mathAverage = (this.math.score*0.8+this.math.oralScore*0.2);
        double chemistryAverage = (this.chemistry.score*0.8+this.chemistry.oralScore*0.2);
        double physicsAverage = (this.physics.score*0.8+this.physics.oralScore*0.2);

        this.average = ( mathAverage  + chemistryAverage + physicsAverage) / 3.0;
    }

    public boolean isCheckPass() {
        calcAverage();
        return this.average > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Student : " + this.name);
        System.out.println("Math Score : " + this.math.score);
        System.out.println("Physics Score : " + this.physics.score);
        System.out.println("Chemistry Score : " + this.chemistry.score);
    }
}
