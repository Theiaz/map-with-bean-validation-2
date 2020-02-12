package payroll;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
// end::hateoas-imports[]

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;


@Validated
@RestController
class EmployeeController {

    int counter = 0;
    Map<Integer, Employee> employeeMap = new HashMap<>();

    @GetMapping("/employees")
    Resources<Resource<Employee>> all() {

        List<Resource<Employee>> employees = employeeMap.values().stream()
                .map(employee -> new Resource<>(employee))
                .collect(Collectors.toList());

        return new Resources<>(employees);
    }


    @PostMapping("/employees")
    List<Employee> newEmployee(@RequestBody @Valid Employee newEmployee) {

        employeeMap.put(counter++, newEmployee);

        return new ArrayList<>(employeeMap.values());
    }


    @PostMapping("/employees/bulk")
    List<Employee> newEmployee(@RequestBody Map<String, @Valid
            Employee> newEmployees) {

        newEmployees.values().forEach(newEmployee -> employeeMap.put(counter++, newEmployee));

        return new ArrayList<>(employeeMap.values());
    }
}
