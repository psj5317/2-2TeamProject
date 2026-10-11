package myClass;


/**
 * Book클래스와 User클래스를 서브클래스로 하는 추상 클래스
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public abstract class DB_Element
{
    /**
     * ID를 반환하는 추상 메소드
     *
     * @param  없음
     * @return    없음
     */
    public abstract String getID();
}