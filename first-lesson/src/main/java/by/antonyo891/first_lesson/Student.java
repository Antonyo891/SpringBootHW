package by.antonyo891.first_lesson;


public class Student {
    private static Long studentId=1L;
    private final Long id;
    private String name;
    private String groupNumber;

    public Student(String name, String groupNumber) {
        this.id = studentId++;
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                '}';
    }
}
