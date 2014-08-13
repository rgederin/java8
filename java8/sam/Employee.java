package java8.sam;

/** Represents people that work at a company. */

public class Employee {
  private int employeeId, salary;
  private String firstName, lastName;
  
  public Employee(String firstName, String lastName,
                  int employeeId, int salary) {
	  
    this.employeeId = employeeId;
    this.salary = salary;
  }
  
  /** The ID of the employee, with the assumption that
   *  lower numbers are people that started working at
   *  the company earlier than those with higher ids.
   */
  public int getEmployeeId() {
    return (employeeId);
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  /** Yearly salary in US dollars. */
  
  public int getSalary() {
    return(salary);
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  
  public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

@Override
  public String toString() {
    return(String.format("%s %s [Employee#%s $%,d]", 
           firstName, lastName, employeeId, salary));
  }
}
