import DataBase.LibDB;
import myClass.*;
/**
 * 도서 관리 시스템 객체를 생성하여 대출을 수행하는 클래스
 *
 * @author (2023320029 정지후, 2023320010 박성준, 2023320012 강성하)
 * @version (2026/10/12)
 */
public class App
{
    public static void main(String[] args){
        // 1
        LibraryManagementSystem lms = new LibraryManagementSystem();

        // 2
        LibDB<User> userDB = lms.setUserDB("c:\\Temp\\UserData2025.txt");

        // 3
        System.out.println("----- 이용자 목록 출력 -----");
        lms.printDB(userDB);

        // 4
        LibDB<Book> bookDB = lms.setBookDB("c:\\Temp\\BookData2025.txt");

        // 5
        System.out.println("\n----- 책 목록 출력 -----");
        lms.printDB(bookDB);

        // 6
        lms.borrowBook("2025320001", "B02");
        lms.borrowBook("2024320002", "B03");
        lms.borrowBook("2023320003", "B04");

        // 7
        System.out.println("\n----- 대출 현황 -----");
        lms.printLoanList();
        System.out.println("--------------------");
    }
}