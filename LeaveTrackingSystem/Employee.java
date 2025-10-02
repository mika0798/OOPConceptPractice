public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int leaveDays = 20;

    public Employee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public void subtractLeave(int leaveDays, LeaveRequest leaveRequest) {
        if (leaveDays < 0) {
            System.out.println("Invalid leave days!");
        } else if (leaveDays > this.leaveDays) {
            System.out.println("Leave days exceeded current balance");
        } else {
            if (leaveRequest.getStatus().equals("Approved")) {
                this.leaveDays -= leaveDays;
                System.out.println("Leave request approved, you are allowed to take " + leaveDays + " days off");
            } else {
                System.out.println("Leave request has not been approved");
            }
        }
    }

    @Override
    public String toString() {
        return "\nemployeeId: " + employeeId + "\nname: " + name + "\ndepartment: " + department + "\nemail: " + email +
                "\nleaveDays: " + leaveDays;
    }
}
