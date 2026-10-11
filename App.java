import DataBase.LibDB;
import myClass.*;
/**
 * App 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class App
{
    public static void main(String[] args){
        
        LibraryManagementSystem lms = new LibraryManagementSystem();
        
        LibDB<User> userDB = lms.setUserDB("c:\\Temp\\UserData2025.txt");
        
        lms.printDB(userDB);
        
        LibDB<Book> bookDB = lms.setBookDB("c:\\Temp\\BookData2025.txt");
        
        lms.printDB(bookDB);
        
        lms.borrowBook("2025320001", "B02");
        lms.borrowBook("2024320002", "B03");
        lms.borrowBook("2023320003", "B04");
        
        lms.printLoanList();
    }
}