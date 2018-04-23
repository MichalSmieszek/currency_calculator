package com.project.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.objects.NativeMath.round;


@RestController
public class SalaryController {
    Salary salary= new Salary();
    // Wyliczone wartości pensji wystawiamy jako restowe api.

    @GetMapping(path = "/polish")
    public String polishSalary (@RequestParam(value = "money") double money) {
        return("{salary: " +salary.polishMoney(money)+ "}");
    }
    @GetMapping(path = "/british")
    public String britishSalary (@RequestParam(value = "money") double money) {
        return("{salary: "+salary.britishMoney(money)+"}");
    }
    @GetMapping(path = "/german")
    public String germanSalary (@RequestParam(value = "money") double money) {
        return("{salary: "+salary.germanMoney(money)+"}");
    }

}