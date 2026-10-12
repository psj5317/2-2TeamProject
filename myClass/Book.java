package myClass;

/**
 * 책 객체에 대한 클래스
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book extends DB_Element
{
    private String author;
    private String bookID;
    private String publisher;
    private String title;
    private int year;

    /**
     * Book 클래스의 객체 생성자
     */
    public Book(String bookID, String title, String author, String publisher, int year)
    {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    /**
     * 책의 ID를 반환하는 메소드
     *
     * @param   없음
     * @return    책의 ID
     */
    public String getID()
    {
        return bookID;
    }

    /**
     * toString메소드 오버라이딩
     *
     * @param  없음
     * @return    출력 형식에 맞게 오버라이딩
     */
    public String toString()
    {
        return "(" + bookID + ") " + title + ", " + author + ", " + publisher + ", " + year; 
    }

}