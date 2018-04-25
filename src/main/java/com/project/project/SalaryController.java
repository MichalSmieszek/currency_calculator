package com.project.project;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.objects.NativeMath.round;

@RestController
public class SalaryController {
    Salary salary= new Salary();
    // Wyliczone wartości pensji wystawiamy jako restowe api.

    @CrossOrigin
    @GetMapping(path = "/polish")
    public String polishSalary (@RequestParam(value = "money") double dailyPLN) {
    return("{salary: "+ salary.polishMoney(dailyPLN)+"}");
    }
    @GetMapping(path = "/british")
    public String britishSalary (@RequestParam(value = "money") double dailyGBP) {
        return("{salary: "+salary.britishMoney(dailyGBP)+"}");
    }
    @GetMapping(path = "/german")
    public String germanSalary (@RequestParam(value = "money") double dailyEUR) {
        return("{salary: "+salary.germanMoney(dailyEUR)+"}");
    }

}