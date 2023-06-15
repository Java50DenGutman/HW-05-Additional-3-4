package telran.people.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.*;
import telran.people.*;

public class CompanyTest {
	private Company company;

	@BeforeEach
	public void setUp() {
		Employee[] employees = new Employee[] { new Employee(1, "John", 1980, "IT", 5000),
				new Employee(2, "Alice", 1990, "HR", 4000), new Employee(3, "Bob", 1985, "IT", 6000),
				new Employee(4, "Charlie", 1982, "Sales", 7000), new Employee(5, "David", 1995, "IT", 5500),
				new Employee(6, "Eva", 1987, "HR", 4500) };
		company = new Company(employees);
	}

	@Test
	public void testGetAllEmployees() {
		Employee[] expected = new Employee[] { new Employee(1, "John", 1980, "IT", 5000),
				new Employee(2, "Alice", 1990, "HR", 4000), new Employee(3, "Bob", 1985, "IT", 6000),
				new Employee(4, "Charlie", 1982, "Sales", 7000), new Employee(5, "David", 1995, "IT", 5500),
				new Employee(6, "Eva", 1987, "HR", 4500) };
		Arrays.sort(expected, Comparator.comparing(Employee::getId));
		Employee[] actual = company.getAllEmployees();
		Arrays.sort(actual, Comparator.comparing(Employee::getId));
		Assertions.assertArrayEquals(expected, actual);
	}

	@Test
	void testGetEmployeesByAge() {
		Employee[] employees = { new Employee(1, "Alice", 1985, "HR", 4000), new Employee(2, "Bob", 1992, "IT", 6000),
				new Employee(3, "John", 1990, "Sales", 5000), new Employee(4, "Jane", 1988, "HR", 4500),
				new Employee(5, "Mike", 1995, "Sales", 5500) };
		Company company = new Company(employees);

		Employee[] expected = { new Employee(5, "Mike", 1995, "Sales", 5500), new Employee(2, "Bob", 1992, "IT", 6000),
				new Employee(3, "John", 1990, "Sales", 5000) };

		Employee[] result = company.getEmployeesByAge(1990, 1995);

		Assertions.assertArrayEquals(expected, result);
	}

	@Test
	public void testGetEmployeesBySalary() {
		Employee[] expected = new Employee[] { new Employee(2, "Alice", 1990, "HR", 4000),
				new Employee(6, "Eva", 1987, "HR", 4500), new Employee(1, "John", 1980, "IT", 5000),
				new Employee(5, "David", 1995, "IT", 5500), new Employee(3, "Bob", 1985, "IT", 6000) };
		Assertions.assertArrayEquals(expected, company.getEmployeesBySalary(4000, 6000));
	}

	@Test
	public void testGetEmployeesByDepartment() {
		Employee[] expected = new Employee[] { new Employee(2, "Alice", 1990, "HR", 4000),
				new Employee(6, "Eva", 1987, "HR", 4500) };
		Assertions.assertArrayEquals(expected, company.getEmployeesByDepartment("HR"));
	}

	@Test
	public void testAddEmployee() {
		Employee newEmployee = new Employee(7, "Frank", 1995, "Finance", 8000);
		Assertions.assertTrue(company.addEmployee(newEmployee));
		Assertions.assertEquals(newEmployee, company.getEmployee(7));
	}

	@Test
	public void testAddDuplicateEmployee() {
		Employee existingEmployee = new Employee(1, "John", 1980, "IT", 5000);
		Assertions.assertFalse(company.addEmployee(existingEmployee));
	}

	@Test
	void testRemoveEmployeesIf() {
		Employee[] employees = { new Employee(1, "John", 1980, "IT", 5000), new Employee(2, "Alice", 1990, "HR", 4000),
				new Employee(3, "Bob", 1985, "IT", 6000), new Employee(4, "Charlie", 1982, "Sales", 7000),
				new Employee(5, "David", 1995, "IT", 5500), new Employee(6, "Eva", 1987, "HR", 4500) };
		Company company = new Company(employees);

		assertTrue(company.removeEmployeesIf(e -> e.getSalary() < 5000));
		assertEquals(4, company.getAllEmployees().length);
		assertFalse(Arrays.stream(company.getAllEmployees()).anyMatch(e -> e.getSalary() < 5000));

		assertTrue(company.removeEmployeesIf(e -> e.getSalary() >= 6000));
		assertEquals(2, company.getAllEmployees().length);
		assertFalse(Arrays.stream(company.getAllEmployees()).anyMatch(e -> e.getSalary() >= 6000));

		assertTrue(company.removeEmployeesIf(e -> e.getBirthYear() < 1985));
		assertEquals(1, company.getAllEmployees().length);
		assertFalse(Arrays.stream(company.getAllEmployees()).anyMatch(e -> e.getBirthYear() < 1985));

	}

	@Test
	public void testGetEmployee() {
		Assertions.assertEquals(new Employee(1, "John", 1980, "IT", 5000), company.getEmployee(1));
		Assertions.assertNull(company.getEmployee(7));
	}
}