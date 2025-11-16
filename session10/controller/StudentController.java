package com.ra.session10.controller;

import com.ra.session10.model.Student;
import com.ra.session10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/studentController")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Hiển thị danh sách sinh viên
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Student> listStudents = studentService.findAll();
        model.addAttribute("listStudents", listStudents);
        return "studentList";
    }

    // xóa
    @GetMapping("delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId, RedirectAttributes redirectAttributes) {
        String result = studentService.delete(studentId);
        redirectAttributes.addFlashAttribute("message", result);
        return "redirect:/studentController/findAll";
    }

    @GetMapping("/initAdd")
    public String initAddStudent(Model model) {
        Student student = new Student();
        student.setIsStudying(true); // mặc định “Đang học” được chọn
        model.addAttribute("student", student);
        return "addStudent";
    }

//    @Transactional
    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            return "addStudent";
        }

        boolean rs = studentService.create(student);
        if (rs) {
            redirectAttributes.addFlashAttribute("message", "Thêm sinh viên thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm sinh viên thất bại!");
        }
        return "redirect:/studentController/findAll";
    }

    @GetMapping("/formEdit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/edit")
    public String editStudent( @Valid @ModelAttribute("student")
    Student student, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            return "editStudent";
        }

        Boolean rs = studentService.update(student);
        if (rs) {
            redirectAttributes.addFlashAttribute("massage", "Sửa sinh viên thành công!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Sửa sinh viên bị lỗi!");
        }
        return "redirect:/studentController/findAll";
    }


}
