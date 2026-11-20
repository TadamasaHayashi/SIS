public class Student {
    String firstName;
    String lastName;
    Class[] classes;
    double gpa;

    public Student(String firstName, String lastName, String per1, String per1Grade, String per2, String per2Grade, String per3, String per3Grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classes = new Class[] {new Class(per1, per1Grade), new Class(per2, per2Grade), new Class(per3, per3Grade)};
        this.gpa = calcGPA(per1Grade, per2Grade, per3Grade);
    }

    public Student(String firstName, String lastName, Class[] classes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classes = classes;
        this.gpa = calcGPA(classes[0].getGrade(), classes[1].getGrade(), classes[2].getGrade());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void editFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void editLastName(String lastName) {
        this.lastName = lastName;
    }

    public double calcGPA(String per1, String per2, String per3) {
        // To-Do calc gpa from the 3 grade Strings (A+, A, A-, etc)
        return 0.0;
    }
}
