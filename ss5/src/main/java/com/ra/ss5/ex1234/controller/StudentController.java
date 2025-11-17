package com.ra.ss5.ex1234.controller;

import com.ra.ss5.ex1234.model.Student;
import com.ra.ss5.ex1234.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Hiển thị danh sách sinh viên với chức năng tìm kiếm và sắp xếp
    @GetMapping
    public String listStudents(@RequestParam(required = false, name = "search") String search,
                               @RequestParam(required = false , name = "sort" , defaultValue = "ASC") String sort,
                               Model model) {
        List<Student> students = studentService.getStudents(search, sort);
        model.addAttribute("students", students);
        model.addAttribute("search", search);
        model.addAttribute("sort", sort);
        return "studentList"; // Trả về view hiển thị danh sách sinh viên
    }

    // Hiển thị form thêm sinh viên
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent"; // Trả về view để thêm sinh viên
    }

    // Xử lý thêm sinh viên
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student , RedirectAttributes redirectAttributes) {
        boolean rs = studentService.addStudent(student);
        if (rs){
            redirectAttributes.addFlashAttribute("message", "Student added successfully");
        }else {
            redirectAttributes.addFlashAttribute("message", "Email already exists");
        }
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên
    }

    // Hiển thị form chỉnh sửa sinh viên
    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent"; // Trả về view để sửa sinh viên
    }

    // Xử lý cập nhật sinh viên
    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student , RedirectAttributes redirectAttributes) {
        student.setId(id);
        boolean rs = studentService.updateStudent( student);
        if (rs){
            redirectAttributes.addFlashAttribute("message", "Update added successfully");
        }else {
            redirectAttributes.addFlashAttribute("message", "Email already exists");
        }
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên

    }

    // Xóa sinh viên
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students"; // Chuyển hướng về danh sách sinh viên
    }
}
