import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

interface Approvable {
    void approve(Employee approverName);
    void deny(Employee approverName, String reason);
}

public class LeaveRequest implements Approvable {
    private int requestID;
    private Employee employee;
    private String startDate;
    private String endDate;
    private String reason;
    private String status; //"Pending", "Approved", "Denied"

    public LeaveRequest(int requestID, Employee employee, String startDate, String endDate, String reason) {
        this.requestID = requestID;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = "Pending";
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean processRequest() {
        System.out.println("Processing generic request...");
        return true;
    }

    public int getDuration() {
        String[] startDateArr = startDate.split("/");
        String[] endDateArr = endDate.split("/");

        LocalDate startDate = LocalDate.of(Integer.parseInt(startDateArr[2]), Integer.parseInt(startDateArr[1]),
                Integer.parseInt(startDateArr[0]));
        LocalDate endDate = LocalDate.of(Integer.parseInt(endDateArr[2]),Integer.parseInt(endDateArr[1]),
                Integer.parseInt(endDateArr[0]));

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay();

        Duration duration = Duration.between(startDateTime, endDateTime);
        return (int) duration.toDays();
    }

    @Override
    public void approve(Employee approverName) {
        setStatus("Approved");
        System.out.println("Request has been approved by " + approverName.getName());
    }

    @Override
    public void deny(Employee approverName, String reason) {
        setStatus("Denied");
        System.out.println("Request has been denied by " + approverName.getName() + "\nReason: " + reason);
    }
}

class SickLeaveRequest extends LeaveRequest {
    private boolean medicalCertificateProvided;

    public SickLeaveRequest(int requestID, Employee employee,String startDate, String endDate, boolean medicalCertificateProvided) {
        super(requestID, employee,startDate, endDate,"Sick Leave");
        this.medicalCertificateProvided = medicalCertificateProvided;
    }

    public boolean isMedicalCertificateProvided() {
        return medicalCertificateProvided;
    }

    @Override
    public boolean processRequest() {
        if(!medicalCertificateProvided && getDuration() > 2 ) {
            System.out.println("Sick leave longer than 2 days requires medical evidence");
        }
        System.out.println("Processing leave request...");
        return true;
    }



}
