import java.util.Scanner;
public class Main {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
StudentOperations operations =
new StudentOperations();
while (true) {
System.out.println(
"===== STUDENT MANAGEMENT SYSTEM ====="
);
System.out.println("1. Add Student");
System.out.println("2. View Students");
System.out.println("3. Exit");
int choice = scanner.nextInt();
scanner.nextLine();
if (choice == 1) {
System.out.print(
"Enter Student Name: "
);
String name = scanner.nextLine();
System.out.print(
"Enter Department: "
);
String department =
scanner.nextLine();
System.out.print(
"Enter Email: "
);
String email =
scanner.nextLine();
operations.addStudent(
name,
department,
email
);
}
else if (choice == 2) {
operations.viewStudents();
}
else {
System.out.println(
"Application Closed"
);
break;
}
}
}
}