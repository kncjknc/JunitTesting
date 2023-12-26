package ApiTesting.ForJunit.service;

import ApiTesting.ForJunit.entity.Student;
import ApiTesting.ForJunit.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStud(Student student) {
       return  studentRepo.save(student);
    }

    @Autowired
   public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
   }

    public StudentService(){}

    public Student getStud(int id) {

      Student stud = studentRepo.findById(id).orElse(null);
      //String name = stud.getName();
      return stud;
    }

    public String deleteStud(int id){
        studentRepo.deleteById(id);
        return "deleted Particular User";
    }

}
