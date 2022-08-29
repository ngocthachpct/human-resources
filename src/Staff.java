/**
 * Class abstract Staff chứa các thông tin cơ bản của nhân viên: id, tên, bộ phận, ngày vào làm, tuổi, số ngày nghỉ, hệ số lương
 * hàm abstract displayInformation là hàm chung : in thông tin nhân viên
 **/

abstract class Staff {
    protected String id, name, department, entryDate;
    protected int age, vacationDate;
    protected double coefficientSalary;

    abstract void displayInformation();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getDepartment() {
        return department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Staff(String id, String name, String department, String entryDate, int age, int vacationDate, double coefficientSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.entryDate = entryDate;
        this.age = age;
        this.vacationDate = vacationDate;
        this.coefficientSalary = coefficientSalary;
    }
}