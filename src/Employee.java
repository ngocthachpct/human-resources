/**
 * class Employee thừa kế từ class Staff và interface ICalculator.
 * Trong này chúng ta sẽ khai báo thêm 1 biến riêng của nhân viên là overtimeHour là giờ làm thêm.
 **/
public class Employee extends Staff implements ICalculator {

    private final int overtimeHours;


    /** Constructor Employee(): lấy DL của người dùng**/

    public Employee(String id, String name, String department, String entryDate, int age, int vacationDate, double coefficientSalary, int overtimeHours) {
        super(id, name, department, entryDate, age, vacationDate, coefficientSalary);
        this.overtimeHours = overtimeHours;
    }

    /**
     * - Hàm calculateSalary(), return kết quả dạng double.
     * - công thức lương: hệ số lương x 3000000 + số giờ làm thêm x 200000
     */
    public double calculateSalary() {
        return (coefficientSalary * 3000000) + (overtimeHours * 200000);
    }

    /**Hàm displayInfomation(): in thông tin quản lý**/

    @Override
    void displayInformation() {

        System.out.printf("| %-10s | %-10d | %-10s | %-10s | %-10s   | %-10d   | %-10.1f | %-10d   | %-16s |\n", this.name,
                this.age, this.id, this.department, this.entryDate, this.vacationDate, this.calculateSalary(), this.overtimeHours, " ");
    }


}