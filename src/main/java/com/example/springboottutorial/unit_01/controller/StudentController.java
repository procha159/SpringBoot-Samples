package com.example.springboottutorial.unit_01.controller;

import com.example.springboottutorial.unit_01.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {

        Student student = new Student(
                1,
                "Adam",
                "Foster");

        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "ramesh").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Adam", "Foster"));
        students.add(new Student(2, "Bert", "Gilbert"));
        students.add(new Student(3, "Carson", "Mason"));

        return ResponseEntity.ok().body(students);
    }

    //{id}/{first-name}/{last-name} - URI template variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok().body(student);
    }

    // Request Param - Id, firstName, lastName
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);

        return ResponseEntity.ok(student);
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println("Creating student " + student.getFirstName() + " " + student.getLastName() + " " + student.getId());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println("Updating student " + student.getFirstName() + " " + student.getLastName());
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println("Deleting student " + studentId);
        return ResponseEntity.ok("Deleted student " + studentId);
    }
}
