import java.util.*;
import DataBase.LibDB;
import myClass.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.HashMap;

/**
 * 도서 관리 시스템 객체를 생성하고, 도서를 대출하며 BookDB, UserDB에 읽어온 파일을 저장한다.
 * 또, loanDB에 대출 정보를 저장하고, DB들을 출력하는 클래스
 * 
 * 
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem{ 
    LibDB<Book> bookDB;  
    HashMap<User,Book> loanDB;  
    LibDB<User> userDB;   

    /**
     *  
     *  LibraryManagementSystem의 객체 생성자
     */
    public LibraryManagementSystem(){
        this.bookDB = new LibDB<Book>();
        this.userDB = new LibDB<User>();
        this.loanDB = new HashMap<User,Book>();
    }

    /**
     * userID와 bookID를 이용하여 loanDB에 저장하는 메소드
     *
     * @param  userID 사용자의 ID, bookID 책의 아이디
     * @return    없음
     */
    public void borrowBook(String userID,String bookID) 
    {
        loanDB.put(userDB.findElement(userID),bookDB.findElement(bookID));
    } 

    /**
     *  bookDB와 userDB를 출력하는 메소드
     *
     * @param  bookDB 또는 userDB
     * @return    없음
     */
    public void printDB(LibDB db)
    {
        db.printAllElement();
    } 

    /**
     * 대출 정보를 출력하는 메소드
     *
     * @param  없응
     * @return    없음
     */
    public void printLoanList() 
    {
        Set<User> keySet = loanDB.keySet();
        for(User user : keySet){
            System.out.println(user + " ===> " + loanDB.get(user));
        }
    } 

    /**
     * 외부에 존재하는 책 파일을 bookDB에 저장하는 메소드
     *
     * @param  bookFile book정보가 있는 파일 경로
     * @return   bookDB book정보들을 저장한 DB
     */
    public LibDB<Book> setBookDB(String bookFile)
    {   
        try{
            File file = new File(bookFile);
            FileReader fin = new FileReader(file);
            Scanner sc = new Scanner(fin);

            while(sc.hasNextLine()){
                String info = sc.nextLine();;
                StringTokenizer stz = new StringTokenizer(info,"/");
                String bookID = stz.nextToken();
                String title = stz.nextToken();
                String author = stz.nextToken();
                String publisher = stz.nextToken();
                int year = Integer.parseInt(stz.nextToken());

                Book book = new Book(bookID,title,author,publisher,year);

                bookDB.addElement(book);
            }
            fin.close();
            sc.close();

        }catch(IOException e){
            System.out.println("파일을 읽어올 수 없습니다.");
        }
        return bookDB;
    } 

    /**
     * 외부에 존재하는 사용자 파일을 userDB에 저장하는 메소드
     *
     * @param  userFile user정보가 있는 파일 경로
     * @return    userDB user 정보들을 저장한 DB
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try{
            File file = new File(userFile);
            FileReader fin = new FileReader(file);
            Scanner sc = new Scanner(fin);

            while(sc.hasNextLine()){
                String info = sc.nextLine();
                StringTokenizer stz = new StringTokenizer(info,"/");

                int stID = Integer.parseInt(stz.nextToken());
                String name = stz.nextToken();
                User user = new User(stID, name);

                userDB.addElement(user);
            }
            fin.close();
            sc.close();
        }catch(IOException e){
            System.out.println("파일을 읽어올 수 없습니다.");
        }
        return userDB;
    }
}

