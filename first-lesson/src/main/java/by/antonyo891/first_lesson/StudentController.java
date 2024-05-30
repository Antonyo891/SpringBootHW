package by.antonyo891.first_lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentRepository studentRepository;
    @Autowired
    public StudentController (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@PathVariable Long id){
        return studentRepository.getStudent(id);
    }
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudents(Long id){
        return studentRepository.getAll();
    }
    @RequestMapping(path = "/students/",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudentsByName(@RequestParam(required = false) String name){
        return studentRepository.getStudents(name);
    }
    @RequestMapping(path = "/group/{number}",method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudentsFromGroup(@PathVariable("number") String groupNumber){
        return studentRepository.getGroupList(groupNumber);
    }
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public Student addStudent(@RequestBody Student student){
        studentRepository.addStudent(student);
        return student;
    }

    @RequestMapping(path = "/student/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String addStudent(@PathVariable Long id){
        Student removeStudent = studentRepository.getStudent(id);
        studentRepository.deleteStudent(id);
        return removeStudent.toString() + " was deleted.";
    }
}
