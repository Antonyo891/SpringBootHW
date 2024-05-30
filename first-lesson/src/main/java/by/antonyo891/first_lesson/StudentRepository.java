package by.antonyo891.first_lesson;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class StudentRepository {
    private List<Student> studentList;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("Anton","106427"));
        studentList.add(new Student("Dmitry","106427"));
        studentList.add(new Student("Daria","106427"));
        studentList.add(new Student("Maksim","106427"));
        studentList.add(new Student("Anna","106427"));
        studentList.add(new Student("Julia","106417"));
        studentList.add(new Student("Dmitry","106417"));
        studentList.add(new Student("Mihail","106417"));
        studentList.add(new Student("Evgenia","106417"));
        studentList.add(new Student("Viktor","106417"));
    }
    public List<Student> getAll(){
        return List.copyOf(studentList);
    }
    public Student getStudent(Long id){
        return studentList.stream()
                .filter(s-> Objects.equals(s.getId(), id))
                .findFirst().orElse(null);
    }
    public  List<Student> getStudents(String name){
        return studentList.stream()
                .filter(s->Objects.equals(s.getName(),name))
                .toList();
    }
    public  List<Student> getGroupList(String groupNumber){
        return studentList.stream()
                .filter(s->Objects.equals(s.getGroupNumber(),groupNumber))
                .toList();
    }

    public void deleteStudent(Long studentId){
        Student studentForRemove = getStudent(studentId);
        if(studentForRemove!=null) studentList.remove(studentForRemove);
    }
    public void addStudent(String name,String groupNumber){
        studentList.add(new Student(name,groupNumber));
    }
    public void addStudent(Student student){
        studentList.add(student);
    }


}
