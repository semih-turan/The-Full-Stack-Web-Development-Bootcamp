/**
 * @author Semih Turan
 * @since february 2024
 */
//import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Course math = new Course("Math", "MATH101", "MATH");
        Course physics = new Course("Physics", "PHYS101", "PHYS");
        Course chemistry = new Course("Chemistry", "CHEM101", "CHEM");

        Teacher teacherOne = new Teacher("Kürs Sıtkı", "90550000000", "+9005325323232");
        Teacher teacherTwo = new Teacher("Paşa Nuri", "90550000001", "+9005325323233");
        Teacher teacherThree = new Teacher("Kemal Hoca", "90550000002", "+9005325323234");

        math.addTeacher(teacherOne);
        physics.addTeacher(teacherTwo);
        chemistry.addTeacher(teacherThree);

        Student studentOne = new Student("İnek Şaban", 4, "140144015", math, physics, chemistry);
        studentOne.math.oralScore = 50;
        studentOne.physics.oralScore = 30;
        studentOne.chemistry.oralScore =50;
        studentOne.addBulkExamNote(50,20,40);
        studentOne.isPass();

        Student studentTwo = new Student("Güdük Necmi", 4, "2211133", math, physics, chemistry );
        studentTwo.math.oralScore = 50;
        studentTwo.physics.oralScore = 30;
        studentTwo.chemistry.oralScore =50;
        studentTwo.addBulkExamNote(100,50,40);
        studentTwo.isPass();

        Student studentThree = new Student("Hayta İsmail", 4, "221121312", math, physics, chemistry );
        studentThree.math.oralScore = 80;
        studentThree.physics.oralScore = 90;
        studentThree.chemistry.oralScore =74;
        studentThree.addBulkExamNote(50,20,40);
        studentThree.isPass();

    }
}