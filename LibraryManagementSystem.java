import java.util.*;
import DataBase.LibDB;
import myClass.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem{ 
    LibDB<Book> bookDB;  
    HashMap<User,Book> loanDB;  
    LibDB<User> userDB;   
    
    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibraryManagementSystem(){
        
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void borrowBook(String userID,String bookID) 
    {
        
    } 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void printDB(LibDB db)
    {
        db.printAllElement();
    } 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void printLoanList() 
    {
        Set<User> keySet = loanDB.keySet();
        for(User user : keySet){
            System.out.println(user + " ===> " + loanDB.get(user));
        }
    } 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<Book> setBookDB(String bookFile)
    {   
        LibDB<User> userDB = new LibDB<User>();
    
        
            try{
                FileReader fin = new FileReader(bookFile);
                Scanner sc = new Scanner(fin);
                while(true){
                    
                    sc = new Scanner(fin = new FileReader(bookFile));
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
                
        }catch(IOException e){
                System.out.println("파일을 읽어올 수 없습니다.");
        }
        return bookDB;
    } 

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<User> setUserDB(String userFile)
    {
        LibDB<User> userDB = new LibDB<User>();
        Scanner sc = null;
        try{
            FileReader fin = new FileReader(userFile);
            sc = new Scanner(fin);
            
            while(true){
                String info = sc.nextLine();
                StringTokenizer stz = new StringTokenizer(info,"/");
                    
                int stID = Integer.parseInt(stz.nextToken());
                String name = stz.nextToken();
                User user = new User(stID, name);
                
                userDB.addElement(user);
            }
        }catch(IOException e){
                System.out.println("파일을 읽어올 수 없습니다.");
        }finally{
            if(sc != null){
                sc.close();
            }
        }
        return userDB;
    }
}


