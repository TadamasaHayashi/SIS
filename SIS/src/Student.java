public class Student {
    String firstName;
    String lastName;
    String per1;
    String per2;
    String per3;
    String per1Grade;
    String per2Grade;
    String per3Grade;


    public Student(String firstName, String lastName, String per1, String per1Grade, String per2, String per2Grade, String per3, String per3Grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.per1 = per1;
        this.per2 = per2;
        this.per3 = per3;
        this.per1Grade = per1Grade;
        this.per2Grade = per2Grade;
        this.per3Grade = per3Grade;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPer1() {
        return this.per1;
    }

    public void setPer1(String per1) {
        this.per1 = per1;
    }

    public String getPer2() {
        return this.per2;
    }

    public void setPer2(String per2) {
        this.per2 = per2;
    }

    public String getPer3() {
        return this.per3;
    }

    public void setPer3(String per3) {
        this.per3 = per3;
    }

    public String getPer1Grade() {
        return this.per1Grade;
    }

    public void setPer1Grade(String per1Grade) {
        this.per1Grade = per1Grade;
    }

    public String getPer2Grade() {
        return this.per2Grade;
    }

    public void setPer2Grade(String per2Grade) {
        this.per2Grade = per2Grade;
    }

    public String getPer3Grade() {
        return this.per3Grade;
    }

    public void setPer3Grade(String per3Grade) {
        this.per3Grade = per3Grade;
    }
}
