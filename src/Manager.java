/** class Manager thừa kế từ class Staff và interface ICalculator. */


public class Manager extends Staff implements ICalculator {
    /**
     * - Khởi tạo biến:
     *    position: lựa chọn chức vụ
     *    positionString : tên chức vụ
     *    responsibilitySalary: lương trách nhiệm ứng với chức vụ
     */

    private final int position;
    private String positionString;
    private double responsibilitySalary;



    /**
     * - Hàm calculateSalary() tính lương
     * - công thức lương: hệ số lương x 5000000 + lương trách nhiệm.
     * - lương trách nhiệm: Business Leader = 8,000,000; project Leader = 5,000,000; Technical Leader = 6,000,000
     */

    public double calculateSalary() {
        switch (position) {
            case 1 -> responsibilitySalary = 8000000;
            case 2 -> responsibilitySalary = 5000000;
            case 3 -> responsibilitySalary = 6000000;
        }
        return coefficientSalary * 5000000 + responsibilitySalary;
    }


    /**Constructor Manager(): lấy DL của người dùng*/

    public Manager(String id, String name, String department, String entryDate, int age, int vacationDate, double coefficientSalary, int position) {
        super(id, name, department, entryDate, age, vacationDate, coefficientSalary);
        this.position = position;
    }

    /**
     * - Hàm displayInfomation(): in thông tin quản lý
     */

    @Override
    void displayInformation() {
        switch (position) {
            case 1 -> positionString = "Business leader";
            case 2 -> positionString = "Project leader";
            case 3 -> positionString = "Technical leader";
        }
        System.out.printf("| %-10s | %-10d | %-10s | %-10s | %-10s   | %-10d   | %-10.1f | %-10s   | %-16s |\n" + "", this.name,
                this.age, this.id, this.department, this.entryDate, this.vacationDate, this.calculateSalary(), " ", this.positionString);

    }
}