public class Course {
    Teacher courseTeacher;
    String name;
    String code;
    String prefix;
    int score;
    int oralScore;

    Course(String name, String code, String prefix){
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        int score = 0;
        int oralScore = 0;
    }

    public void addTeacher(Teacher newTeacher) {
        if (this.prefix.equals(newTeacher.branch)) {
            this.courseTeacher = newTeacher;
            System.out.println("Successfully");
        } else {
            System.out.println("Academician " + newTeacher.name + " teacher cannot teach this course.");
        }
    }

    public void printTeacher() {
        if (courseTeacher != null) {
            System.out.println(this.name + " Academician of the course: " + courseTeacher.name);
        } else {
            System.out.println(this.name + " No Academician has been assigned to the course.");
        }
    }
}
