import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {

    public static final Scanner input = new Scanner(System.in);
    public static final ArrayList<Staff> staffArr = new ArrayList<>();
    public static final ArrayList<Department> departmentArr = new ArrayList<>();



    /**Hàm backMenu(): quay trở lại menu khi ngời dùng nhập vào 0 */

    public static void backMenu() {
        int i = 0;
        //noinspection LoopConditionNotUpdatedInsideLoop
        do {
            int close = input.nextInt();
            if (close == 0)
                break;
        } while (i == 0);
    }

    /**Hàm Menu() dùng để hiển thị chức năng, và chọn chức năng chạy từ input người dùng */

    public static int Menu() {

        int choice;

        do {
            System.out.print("""
                    \t\t\t\t\t           PHAN MEM QUAN LY NHAN VIEN
                    \t\t\t\t ==========================================================
                    \t\t\t\t | Xin vui long chon chuc nang:                           |
                    \t\t\t\t | 1. Hien thi danh sach nhan vien hien co trong cong ty  |
                    \t\t\t\t | 2. Hien thi cac bo phan trong cong ty                  |
                    \t\t\t\t | 3. Hien thi cac nhan vien theo tung bo phan            |
                    \t\t\t\t | 4. Them nhan vien moi vao cong ty                      |
                    \t\t\t\t | 5. Tim kiem thong tin nhan vien                        |
                    \t\t\t\t | 6. Hien thi bang luong nhan vien                       |
                    \t\t\t\t | 7. Hien thi bang luong cua nhan vien tang dan          |
                    \t\t\t\t | 8. Thoat                                               |
                    \t\t\t\t ==========================================================
                    \t\t\t\t Xin vui long nhap lua chon cua ban [1-8]:\s""");
            choice = input.nextInt();
            if (!(choice > 0 && choice < 9)) {


                System.out.println("\n\nLua chon ban nhap khong hop le, xin vui long nhap lai!");
            }
        } while (!(choice > 0 && choice < 9));
        return choice;
    }

    /**chức năng 1 của menu
     Hàm showEmployee():  duyệt mảng staffArr để hiển thị thông tin toàn bộ nhân viên thông qua hàm displayInformation().
     */

    public static void showEmployee() {
        System.out.printf(
                """
                        ==================================================================================================================================
                        | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-16s |
                        """,
                "Ten", "Tuoi", "ID", "Bo phan", "Ngay vao lam", "So ngay nghi", "Luong", "Gio lam them", "Chuc vu");
        for (Staff staff : staffArr) {
            staff.displayInformation();
        }
        System.out
                .print("""
                        ==================================================================================================================================""");
        System.out.println("\n\nNhan 0 va Enter de quay lai menu.");

        backMenu();
    }

    /** chức năng 2 của menu
     *Hàm showDepartment(): liệt kê toàn bộ các tên bộ phận bằng cách dùng loop duyệt qua mảng
     *và in tên bộ phận bằng cách in kết quả được trả về thông qua hàm getDepartmentName trong Department class.
     */

    public static void showDepartment() {
        System.out
                .print("""
                        ==================================================================================================================================
                        """);
        System.out.printf("| %-40s | %-40s | %-40s |\n", "Ten bo phan", "ID bo phan", "So nhan vien");
        for (Department department : departmentArr) {
            System.out.println(department);
        }

        System.out
                .print("""
                        ==================================================================================================================================
                        """);
        System.out.println("Nhan 0 va Enter de quay lai menu.");

        backMenu();
    }

    /** chức năng 3 của menu
     * - Hàm showDepartmentEmployee():  hiển thị toàn bộ thông tin nhân
     * viên được xếp theo nhóm các bộ phận sau đó dùng vòng lặp for để duyệt mảng bộ
     * phận, tiếp theo check xem thử tên bộ phận đã có ở mảng departmentArr có trùng
     * với thuộc tính tên bộ phận của nhân viên (staff.department) không.
     */

    public static void showDepartmentEmployee() {
        for (Department department : departmentArr) {
            System.out
                    .print("""
                            ==================================================================================================================================
                            """);
            System.out.printf("| %-40s | %-40s | %-40s |\n", "Ten bo phan", "ID bo phan", "So nhan vien");
            System.out.println(department);
            System.out
                    .print("""
                            ==================================================================================================================================
                            """);

            for (Staff staff : staffArr) {
                if (department.getDepartmentName().equals(staff.getDepartment())) {
                    staff.displayInformation();
                }
            }
        }
        System.out
                .print("""
                        ==================================================================================================================================
                        """);

        System.out.println("Nhan 0 va Enter de quay lai menu.");

        backMenu();
    }

    /** chức năng 4 của menu:
     * - Hàm addNewPerson(): đơn giản là in Menu gọi hàm thêm nhân viên( addEmployee() ) hoặc thêm quản lý( addManager() ).
     */

    public static void addNewPerson() {
        int choice;
        do {
            System.out.println("""
                    Xin vui long chon loai nhan vien:
                    \t1. Nhan vien thong thuong
                    \t2. Nhan vien cap quan ly""");
            choice = input.nextInt();
            if (!(choice == 1) && !(choice == 2)) {
                System.out.println("Lua chon ban nhap khong hop le, xin vui long nhap lai\n");
            } else if (choice == 1) {
                addEmployee();
            } else {
                addManager();
            }

        } while (!(choice == 1) && !(choice == 2));
        System.out.println("Nhan 0 va Enter de quay lai menu.");

        backMenu();
    }

    /**
     * - Hàm addManager(): thêm quản lý mới, là 1 phần của hàm addNewPerson, dùng để
     * thêm nhân viên ở cấp quản lý. Đầu tiên khởi tạo giá trị thuộc tính cơ bản của
     * nhân viên, sau đó yêu cầu người dùng nhập vào, rồi check trong mảng xem bộ
     * phận của quản lý đã có hay chưa, nếu rồi thì tăng số người lên, nếu chưa thì
     * tạo bộ phận mới. Cuối cùng khai báo 1 object Manager và truyền dữ liệu vào,
     * rồi thêm object vào mảng, đồng thời thêm 1 bộ phận mới vào mảng, nếu có.
     */

    public static void addManager() {
        String id, name, department, entryDate;
        int age, vacationDate, departmentID;
        double coefficientSalary;

        System.out.println("Xin vui long nhap thong tin quan ly moi: ");
        System.out.print("Ten quan ly: ");
        name = input.next();
        System.out.print("Tuoi quan ly: ");
        age = input.nextInt();
        System.out.print("Ma quan ly: ");
        id = input.next();
        int position;
        System.out.print("""
                Chuc danh cua quan ly:
                \t1. Business leader
                \t2. Project leader
                \t3. Technical leader
                """);
        position = input.nextInt();

        System.out.print("Bo phan lam viec: ");
        department = input.next();
        boolean checkDepartmentIncrease = false;

        // Check xem tên bộ phận vừa rồi có trùng với phần tử nào trong mảng không
        for (Department value : departmentArr) {
            if (value.getDepartmentName().equals(department)) {
                // Nếu trùng thì tăng người trong bộ phận và checkDepartmentIncrease = true
                value.increaseEmployeesNumber();
                checkDepartmentIncrease = true;
                break;
            }
        }

        if (!checkDepartmentIncrease) {
            // Nếu checkDepartmentIncrease = false thì yêu cầu nhập mã bộ phận và tạo bộ phận mới
            System.out.print("Xin vui long nhap ma bo phan: ");
            departmentID = input.nextInt();
            int departmentEmployeesNumber = 1;
            Department departmentObj = new Department(department, departmentID, departmentEmployeesNumber);
            departmentArr.add(departmentObj);
        }

        System.out.print("Xin vui long nhap he so luong: ");
        coefficientSalary = input.nextDouble();

        System.out.print("Ngay vao lam viec [dd/mm/yyyy]: ");
        entryDate = input.next();
        System.out.print("So ngay nghi: ");
        vacationDate = input.nextInt();

        Manager manager = new Manager(id, name, department, entryDate, age, vacationDate, coefficientSalary, position);

        staffArr.add(manager);

    }

    /**
     * - Hàm addEmployee(): thêm nhân viên mới, là hàm con của hàm addNewPerson, dùng
     * để thêm nhân viên thông thường. Đầu tiên khởi tạo giá trị thuộc tính cơ bản
     * của nhân viên, sau đó yêu cầu người dùng nhập vào, rồi check trong mảng xem
     * bộ phận của nhân viên đã có hay chưa, nếu rồi thì tăng số người lên, nếu chưa
     * thì tạo bộ phận mới. Cuối cùng khai báo 1 object Employee và truyền dữ liệu
     * vào, rồi thêm object vào mảng, đồng thời thêm 1 bộ phận mới vào mảng, nếu có.
     */

    public static void addEmployee() {
        String id, name, department, entryDate;
        int age, vacationDate, departmentID, overtimeHours;

        double coefficientSalary;

        System.out.println("Xin vui long nhap thong tin nhan vien moi: ");
        System.out.print("Ten nhan vien: ");
        name = input.next();
        System.out.print("Tuoi nhan vien: ");
        age = input.nextInt();
        System.out.print("Ma nhan vien: ");
        id = input.next();
        System.out.print("Bo phan lam viec: ");
        department = input.next();
        boolean checkDepartmentIncrease = false;

        // Check xem tên bộ phận vừa rồi có trùng với phần tử nào trong mảng không
        for (Department value : departmentArr) {
            if (value.getDepartmentName().equals(department)) {
                // Nếu trùng thì tăng người trong bộ phận và checkDepartmentIncrease = true
                value.increaseEmployeesNumber();
                checkDepartmentIncrease = true;
                break;
            }
        }

        if (!checkDepartmentIncrease) {
            // Nếu checkDepartmentIncrease = false thì yêu cầu nhập mã bộ phận và tạo bộ
            // phận mới
            System.out.print("Xin vui long nhap ma bo phan: ");
            departmentID = input.nextInt();
            int departmentEmployeesNumber = 1;
            Department departmentObj = new Department(department, departmentID, departmentEmployeesNumber);
            departmentArr.add(departmentObj);

        }

        System.out.print("Xin vui long nhap he so luong: ");
        coefficientSalary = input.nextDouble();

        System.out.print("Xin vui long nhap so gio lam them: ");
        overtimeHours = input.nextInt();

        System.out.print("Ngay vao lam viec [dd/mm/yyyy]: ");
        entryDate = input.next();
        System.out.print("So ngay nghi: ");
        vacationDate = input.nextInt();

        Employee employee = new Employee(id, name, department, entryDate, age, vacationDate, coefficientSalary,
                overtimeHours);

        staffArr.add(employee);

    }

    /**
     * - Hàm findEmployee(): tìm thông tin nhân viên qua tên/ID từ input người dùng,
     * sau khi người dùng chọn xong sử dụng switch case để tìm. Nếu tìm theo tên thì
     * sẽ thu tên nhân viên vào 1 biến tạm, sau đó check xem biến đó có khớp với tên
     * nào trong mảng không. Nếu trùng thì in thông tin bằng hàm displayInformation().
     * Còn nếu tìm theo id thì cũng thu ID vào 1 biến tạm khác, sau đó so sánh với các \
     * phần tử trong mảng, nếu trùng thì in ra thông tin bằng hàm displayInformation().
     */

    public static void findEmployee() {
        System.out.println("Ban muon tim nhan vien theo ID hay ten?\n ID: 1\n Ten: 2");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {

            // Tìm nhân viên theo ID
            case 1 -> {
                System.out.print("Xin vui long nhap ID nhan vien: ");
                String staffID = input.nextLine();

                boolean staffEqual = false;
                System.out.printf(
                        """
                                ==================================================================================================================================
                                | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-16s |
                                """,
                        "Ten", "Tuoi", "ID", "Bo phan", "Ngay vao lam", "So ngay nghi", "Luong", "Gio lam them", "Chuc vu");
                for (Staff staff : staffArr) {
                    if (staff.getId().contains(staffID)) {
                        staff.displayInformation();
                        staffEqual = true;
                    }
                }

                if (!staffEqual) {
                    System.out.printf("| %-130s |", "Khong tim thay nhan vien");
                }

                System.out.print("""
                            ==================================================================================================================================
                            """);
            }
            // Tìm nhân viên theo tên
            case 2 -> {
                System.out.print("Xin vui long nhap ten nhan vien: ");
                String staffName = input.nextLine();

                boolean staffEqual = false;
                System.out.printf(
                        """
                                ==================================================================================================================================
                                | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-16s |
                                """,
                        "Ten", "Tuoi", "ID", "Bo phan", "Ngay vao lam", "So ngay nghi", "Luong", "Gio lam them", "Chuc vu");

                for (Staff staff : staffArr) {
                    if (staff.getName().contains(staffName)) {
                        staff.displayInformation();
                        staffEqual = true;
                    }
                }

                if (!staffEqual) {
                    System.out.printf("| %-130s |", "Khong tim thay nhan vien");
                }
                System.out
                        .print("""
                            ==================================================================================================================================
                            """);
            }

        }
        System.out.println("Nhan 0 va Enter de quay lai menu.");

        backMenu();
    }


    /**
     * - Hàm showDecreaseSalary(): chức năng 6, hiển thị toàn bộ thông tin và bảng
     * lương nhân viên theo thứ tự giảm dần (tiêu chí nâng cao) bằng cách sắp xếp
     * mảng bằng list.sort, sau đó dùng vòng lặp for để duyệt mảng
     */

    public static void showDecreaseSalary() {
        // tìm hiểu thêm về lambda expression
        // tham số đầu vào là 1 comparator
        staffArr.sort((staff1,
                       staff2) -> (int) (((ICalculator) staff2).calculateSalary() - ((ICalculator) staff1).calculateSalary()));
        System.out.printf(
                """
                        ==================================================================================================================================
                        | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-16s |
                        """,
                "Ten", "Tuoi", "ID", "Bo phan", "Ngay vao lam", "So ngay nghi", "Luong", "Gio lam them", "Chuc vu");

        for (Staff staff : staffArr) {
            staff.displayInformation();
        }
        System.out
                .print("""
                        ==================================================================================================================================""");

        System.out.println("\n\nNhan 0 va Enter de quay lai menu.");

        backMenu();
    }

    /**
     * - Hàm showIncreaseSalary(): chức năng 7, hiển thị toàn bộ thông tin và bảng
     * lương nhân viên theo thứ tự tăng dần (tiêu chí nâng cao) bằng cách sắp xếp
     * mảng bằng list.sort, sau đó dùng vòng lặp for để duyệt mảng
     */
    public static void showIncreaseSalary() {
        staffArr.sort((staff1,
                       staff2) -> (int) (((ICalculator) staff1).calculateSalary() - ((ICalculator) staff2).calculateSalary()));
        System.out.printf(
                """
                        ==================================================================================================================================
                        | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-16s |
                        """,
                "Ten", "Tuoi", "ID", "Bo phan", "Ngay vao lam", "So ngay nghi", "Luong", "Gio lam them", "Chuc vu");


        for (Staff staff : staffArr) {
            staff.displayInformation();
        }
        System.out
                .print("""
                        ==================================================================================================================================""");

        System.out.println("\n\nNhan 0 va Enter de quay lai menu.");

        backMenu();
    }

    /**
     * - Hàm main: đơn giản là gọi Menu chọn chức năng, sau đó dùng switch case để
     * tuỳ chức năng gọi hàm cho đúng, nếu không hợp lệ (ngoài giới hạn 1-8) thì mời
     * người dùng nhập lại do dùng hàm do-while
     */

    public static void main(String[] args) {
        int choice;
        do {

            choice = Menu();
            switch (choice) {
                case 1 -> showEmployee();
                case 2 -> showDepartment();
                case 3 -> showDepartmentEmployee();
                case 4 -> addNewPerson();
                case 5 -> findEmployee();
                case 6 -> showDecreaseSalary();
                case 7 -> showIncreaseSalary();
                case 8 -> {
                }
                default -> System.out.println("Lua chon ban nhap khong hop le, xin vui long nhap lai!");
            }
        } while (choice != 8);
    }
}
