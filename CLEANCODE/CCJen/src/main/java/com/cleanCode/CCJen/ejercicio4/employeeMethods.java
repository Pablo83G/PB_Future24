package com.cleanCode.CCJen.ejercicio4;

public class employeeMethods {
    public void employeeMethod(Employee employee) {
    // Some actions
        double monthlySalary = getMonthlySalary(employee);
    // Continue processing
    }
    public double getMonthlySalary(Employee employee) {//No es necesario pasar el salario anual y las recompensas  previamente, si con el objeto empleado podemos obtenerlas
        return (employee.getYearlySalary() + employee.getAwards())/12;
    }
}
