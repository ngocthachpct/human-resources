//class Department, khai báo các biến là tên bộ phận, số người trong bộ phận và mã bộ phận

public class Department {


    private final String departmentName;
    private int departmentEmployeesNumber;
    private final int departmentID;

    //Constructor Department(): lấy input của người dùng gồm tên và ID bộ phận


    public Department(String name, int id, int quantily) {
        departmentName = name;
        departmentID = id;
        departmentEmployeesNumber = quantily;
    }


    //Hàm toString(): In thông tin bộ phận: tên, mã, số nhân viên

    public String toString() {
        return (String.format("| %-40s | %-40d | %-40d |", this.departmentName, this.departmentID, this.departmentEmployeesNumber));
    }

    //Hàm getDepartmentName(): trả về tên bộ phận

    public String getDepartmentName() {
        return departmentName;
    }

    // Hàm increaseEmployeesNumber(): tăng số nhân viên

    public void increaseEmployeesNumber() {
        departmentEmployeesNumber++;
    }

}