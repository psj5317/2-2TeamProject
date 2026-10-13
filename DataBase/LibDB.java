package DataBase;
import myClass.DB_Element;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Book객체와 User객체를 저장할 수 있는 제네릭 클래스
 *
 * @author (2023320029 정지후, 2023320010 박성준, 2023320012 강성하)
 * @version (2026/09/30)
 */
public class LibDB<T>
{
    private ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     */
    public LibDB()
    {
        db = new ArrayList<T>();
    }

    /**
     * 컬렉션에 객체를 추가하는 메소드
     *
     * @param  item Book이나 User객체
     * @return    없음
     */
    public void addElement(T item)
    {
        db.add(item);
    }

    /**
     * id를 넣었을때 책 ID면 책 객체를 찾고, 사용자 ID면 사용자 객체를 반환하는 메소드
     *
     * @param  id 책 또는 사용자의 id
     * @return    찾는 아이디가 있다면 아이디와 일치하는 객체 반환, 없다면 null
     */
    public T findElement(String id)
    {
        Iterator it = db.iterator();
        while(it.hasNext()){
            DB_Element item = (DB_Element) it.next();
            if(item.getID().equals(id)){
                return (T) item;
            }
        }
        return null;
    }

    /**
     *  현재 들어가있는 객체를 모두 출력하는 메소드
     *  
     *  @param  없음
     *  @return     없음
     */
    public void printAllElement(){
        for(T item:db){
            System.out.println(item);
        }
    }

}