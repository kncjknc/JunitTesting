package ApiTesting.ForJunit;
import static org.junit.Assert.assertNull;
import ApiTesting.ForJunit.entity.Student;
import ApiTesting.ForJunit.repository.StudentRepo;
import ApiTesting.ForJunit.service.StudentService;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ForJunitApplicationTests {

	@InjectMocks
	StudentService studentService;

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	StudentRepo studentRepo;

	Logger logger = Logger.getLogger(ForJunitApplicationTests.class.getName());

	@Test
	void contextLoads() {
	}

	@Test
	void checkObjectsEquals(){

		assertEquals(1,1);
		assertNull(null);
		logger.info("Start Objects Equals Method");
		String student = restTemplate.getForObject("/getStud/4", String.class);
		String student2 = restTemplate.getForObject("/getStud/4",String.class);
		assertEquals(student,student2);
		logger.info("Completed Ofter Checking the the two Objects is equal");

	}

	@Test
	void postMapping(){
		logger.info("Start PostMapping");
		Student stud = new Student(9,"varatha","chennai");
		logger.info("Created One Object");
		logger.info("Calling the restTemplate postEntityMethod");
		ResponseEntity<Student> student = restTemplate.postForEntity("/add/Student",stud,Student.class);
		assertNotNull(student.getBody());
		logger.info("Completed Post Mapping Test Method");
	}

	@Test
	void deleteMapping(){
		logger.info("Started DeleteMapping Test Method");
		restTemplate.delete("/deleteId/1");
		logger.info("Completed Delete Mapping with delete particular user");
	}

	@Test
	void testFor(){

		StudentService studentService1 = new StudentService(studentRepo);
		Student student = studentService1.getStud(2);
		System.out.println(student.getName());
		StudentService ss = new StudentService();

	}

}
