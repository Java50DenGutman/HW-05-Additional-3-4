package telran.people;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class Company {

	private Employee[] employees;

	public Company(Employee[] employees) {
		this.employees = employees;
	}

	public Employee[] getAllEmployees() {
		Employee[] copy = Arrays.copyOf(employees, employees.length);
		Arrays.sort(copy);
		return copy;
	}

	public Employee[] getEmployeesByAge(int yearFrom, int yearTo) {
		Employee[] filtered = Arrays.stream(employees)
				.filter(e -> e.getBirthYear() >= yearFrom && e.getBirthYear() <= yearTo)
				.sorted((e1, e2) -> Integer.compare(e2.getBirthYear(), e1.getBirthYear())).toArray(Employee[]::new);
		return filtered;
	}

	public Employee[] getEmployeesBySalary(int salaryFrom, int salaryTo) {
		return Arrays.stream(employees)
				.filter(employee -> employee.getSalary() >= salaryFrom && employee.getSalary() <= salaryTo)
				.sorted(Comparator.comparingInt(Employee::getSalary)).toArray(Employee[]::new);
	}

	public Employee[] getEmployeesByDepartment(String department) {
		Employee[] filtered = Arrays.stream(employees).filter(e -> e.getDepartment().equals(department)).sorted()
				.toArray(Employee[]::new);
		return filtered;
	}

	public boolean addEmployee(Employee empl) {
		if (Arrays.stream(employees).anyMatch(e -> e.equals(empl))) {
			return false;
		}
		employees = Arrays.copyOf(employees, employees.length + 1);
		employees[employees.length - 1] = empl;
		return true;
	}

	public boolean removeEmployeesIf(Predicate<Employee> predicate) {
		Employee[] filtered = Arrays.stream(employees).filter(predicate.negate()).toArray(Employee[]::new);
		if (filtered.length == employees.length) {
			return false;
		}
		employees = filtered;
		return true;
	}

	public Employee getEmployee(int id) {
		for (Employee empl : employees) {
			if (empl.getId() == id) {
				return empl;
			}
		}
		return null;
	}
}