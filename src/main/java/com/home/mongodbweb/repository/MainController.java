package com.home.mongodbweb.repository;

import com.home.mongodbweb.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Александр on 11.11.2018.
 */
@Controller
public class MainController {

    private static final String[] NAMES = {"Tom", "Jerry", "Donald"};

    @Autowired
    private EmployeeRepository employeeRepository;

    @ResponseBody
    @RequestMapping("/")
    public String home(){
        String html = "";
        html+="<ul>";
        html+="<li><a href='/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/showAllEmployee'>Show All Employee</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllEmployee'>Delete All Employee</a></li>";
        html += "<li><a href='/showImage'>Show image</a></li>";
        html += "<li><a href='/createString'>Input image</a></li>";
        html += "<li><a href='/showImageFromInternet'>Show image from internet</a></li>";
        html += "</ul>";
        return html;
    }


    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert(){
        Employee employee = new Employee();
        long id = (long) Math.random();
        String fullName = "alexandr";
        employee.setId(id);
        employee.setEmpNo("E" + id);
        employee.setFullName(fullName);
        employee.setHireDate(new Date());
        this.employeeRepository.insert(employee);

        return "inserted:"+employee;
    }
    int s=0;
    @ResponseBody
    @RequestMapping("/showImage")
    public String showImage() {
        s = s + 1;
        if (s < 10) {
            return
                    "  </p><img src='images/GATC_C6_EP1_0" + s + ".jpg 'height='90%'></p><li><a href='/showPreviousImage'>Back  </a><a href='/showImage'>Next</a></li>";
        }
        else
            return "<p><img src='images/GATC_C6_EP1_" + s + ".jpg 'height='90%'></p><li><a href='/showPreviousImage'>Back  </a><a href='/showImage'>Next</a></li>";
    }
    @ResponseBody
    @RequestMapping("/showPreviousImage")
    public String showPreviousImage() {
        s = s - 1;
        if (s < 10) {
            return "<p><img src='images/GATC_C6_EP1_0" + s + ".jpg 'height='90%'></p><li><a href='/showPreviousImage'>Back  </a></li><li><a href='/showImage'>Next</a></li>";
        }
        else
            return "<p><img src='images/GATC_C6_EP1_" + s + ".jpg 'height='90%'></p><li><a href='/showPreviousImage'>Back  </a><a href='/showImage'>Next</a></li>";
    }

    @ResponseBody
    @RequestMapping("/showImageFromInternet")
    public  String showImageFromInternet(){
        return  "<img src='https://pre00.deviantart.net/f22f/th/pre/f/2017/135/d/2/gatc_chapter_6_episode_3___sneak_peak_06_by_unseenharbinger-db9bi0l.png'height='90%'>" +
                "<li><a href='/'>Back to main menu</a><a href='/showImage'>Next</a></li>";
    }


    @ResponseBody
    @RequestMapping("/showAllEmployee")
    public String showAllEmployee() {

        List<Employee> employees = this.employeeRepository.findAll();

        String html = "";
        for (Employee emp : employees) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/deleteAllEmployee")
    public String deledeAll(){
        employeeRepository.deleteAll();
        return home();
    }


}
