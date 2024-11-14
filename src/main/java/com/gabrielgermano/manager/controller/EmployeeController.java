package com.gabrielgermano.manager.controller;

import com.gabrielgermano.manager.dto.EmployeeDTO;
import com.gabrielgermano.manager.exception.ErrorResponse;
import com.gabrielgermano.manager.model.Employee;
import com.gabrielgermano.manager.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @Operation(summary = "Get all employees", description = "Retrieves all current employee in the application")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employees Found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Employee.class)))
            })
    })
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a employee by id", description = "Retrieves the details of an employee based on the provided id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Employee.class))
            }),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @ExampleObject(value = "{\"timestamp\": \"2024-11-13T22:42:59.639+00:00\"," +
                                " \"status\": 404, \"error\": \"Not Found\"," +
                                " \"message\": \"Employee with id 1 not found\"," +
                                " \"path\": \"/employee/{id}\"}"))
            })
    })
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }


    @PostMapping
    @Operation(summary = "Creates a new Employee", description = "Creates a new employee on the server with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee successfully created", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Employee.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict: An employee with the provided email address already exists", content =  {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = @ExampleObject(value = "{\"timestamp\": \"2024-11-13T22:42:59.639+00:00\"," +
                        " \"status\": 409, \"error\": \"Conflict\"," +
                        " \"message\": \"An employee with email employee@example.com already exists\"," +
                        " \"path\": \"/employee/{id}\"}"))
            })
    })
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes an Employee", description = "Deletes an employee on the server based on the provided id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Employee successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = "{\"timestamp\": \"2024-11-13T22:42:59.639+00:00\"," +
                                    " \"status\": 404, \"error\": \"Not Found\"," +
                                    " \"message\": \"Employee with id 1 not found\"," +
                                    " \"path\": \"/employee/{id}\"}"))
            })
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates an existing Employee", description = "Updates the details of an existing employee identified by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Employee.class))
            }),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = "{\"timestamp\": \"2024-11-13T22:42:59.639+00:00\"," +
                                    " \"status\": 404, \"error\": \"Not Found\"," +
                                    " \"message\": \"Employee with id 1 not found\"," +
                                    " \"path\": \"/employee/{id}\"}"))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict: An employee with the provided email address already exists", content =  {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = "{\"timestamp\": \"2024-11-13T22:42:59.639+00:00\"," +
                                    " \"status\": 409, \"error\": \"Conflict\"," +
                                    " \"message\": \"An employee with email employee@example.com already exists\"," +
                                    " \"path\": \"/employee/{id}\"}"))
            })
    })
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }


}
