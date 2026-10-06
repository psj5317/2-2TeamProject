package DataBase;
import myClass.DB_Element;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * LibDB 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibDB<T>
{
    ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     */
    public LibDB()
    {
        db = new ArrayList<T>();
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void addElement(T item)
    {
        db.add(item);
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public T findelement(String id)
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
    
    public void printAllElement(){
        for(T item:db){
            System.out.println(item);
        }
    }

}