package telran.people;

import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private int id;
    private String name;
    private int birthYear;
    private String department;
    private int salary;
	private Object position;

    public Employee(int id, String name, int birthYear, String department, int salary) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(birthYear, employee.birthYear) &&
                Objects.equals(position, employee.position) &&
                salary == employee.salary;
    }

    @Override
    public int compareTo(Employee empl) {
        return Integer.compare(this.id, empl.id);
    }
}