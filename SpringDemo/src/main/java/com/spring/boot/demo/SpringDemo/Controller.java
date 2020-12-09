package com.spring.boot.demo.SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @GetMapping("/hello-world")
    public String test(){
        return "Hello World!";
    }

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExamsRepository examsRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody Account account){
        String result = "";
        HttpStatus httpStatus = null;
        if(userService.checkLogin(account)){
            result = jwtTokenProvider.generateToken(account.getUsername());
            httpStatus = HttpStatus.OK;
        }
        else{
            result = "Wrong username or password";
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<String>(result, httpStatus);
    }

    @GetMapping("all-accounts")
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    @GetMapping("/all-students")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/all-questions")
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    @PostMapping("/all-questions")
    public ResponseEntity<Object> createNewQuestion(@RequestBody Question newQuestion){
        Optional<Question> questionEntity = questionRepository.findById(newQuestion.getId());
        if(questionEntity.isPresent()){
           throw new NotFoundException("");
        }
        questionRepository.save(newQuestion);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id={id}").buildAndExpand(newQuestion.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/all-exams")
    public List<Exams> getAllExams(){
        return examsRepository.findAll();
    }

    @GetMapping("/all-questions/id={id}")
    public Question getQuestionById(@PathVariable int id){
        Optional<Question> question = questionRepository.findById(id);
        if(!question.isPresent()){
            throw new NotFoundException("Can not find question with id: " + id);
        }
        return question.get();
    }

//    @PostMapping("/all-questions/id={id}/answers")
//    public ResponseEntity<Object> createNewAnswer(@RequestBody Answer newAnswer, @PathVariable String id){
//        Optional<Answer> answerEntity = answerRepository.findById();
//        if(answerEntity.isPresent()){
//            throw new NotFoundException("");
//        }
//        Question questionEntity = questionRepository.findById(id).get();
//        newAnswer.setQuestion(questionEntity);
//        answerRepository.save(newAnswer);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id={id}").buildAndExpand(newAnswer.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }

    @GetMapping("/all-employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/all-employees/id={id}")
    public Employee getEmployeeById(@PathVariable String id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new NotFoundException("Can not find employee with id: " + id);
        }
        return employee.get();
    }

    @GetMapping("/all-lecturers")
    public List<Lecturer> getAllLecturers(){
        return lecturerRepository.findAll();
    }

    @GetMapping("/all-lecturers/id={id}")
    public Lecturer getLecturerById(@PathVariable String id){
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        if(!lecturer.isPresent()){
            throw new NotFoundException("Can not find Lecturer with id: " + id);
        }
        return lecturer.get();
    }

    @GetMapping("/all-managers")
    public List<Manager> getAllManager(){
        return managerRepository.findAll();
    }

    @GetMapping("/all-managers/id={id}")
    public Manager getManagerById(@PathVariable String id){
        Optional<Manager> manager = managerRepository.findById(id);
        if(!manager.isPresent()){
            throw new NotFoundException("Can not found manager with id: " + id);
        }
        return manager.get();
    }

    @GetMapping("/all-subjects")
    public List<Subject> getAllSubject(){
        return subjectRepository.findAll();
    }
}
