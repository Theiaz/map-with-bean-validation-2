package payroll;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class Employee {

    @NotBlank
    public final String name;
    @Valid
    public final EmployeeRole role;

    @JsonCreator
    public Employee(@JsonProperty("name") String name,
        @JsonProperty("role") EmployeeRole role) {

        this.name = name;
        this.role = role;
    }

    public static class EmployeeRole {

        @NotBlank
        public String rolename;

        @Min(0)
        public int rating;

        @JsonCreator
        public EmployeeRole(@JsonProperty("rolename") String rolename,
            @JsonProperty("rating") int rating) {

            this.rolename = rolename;
            this.rating = rating;
        }
    }
}
