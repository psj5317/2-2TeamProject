package myClass;

/**
 * 사용자 객체에 대한 클래스
 *
 * @author (2023320029 정지후, 2023320010 박성준, 2023320012 강성하)
 * @version (2026/10/12)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * User 클래스의 객체 생성자
     */
    public User(int stID, String name)
    {
        this.stID = stID;
        this.name = name;
    }

    /**
     * 사용자의 ID를 반환하는 메소드
     *
     * @param  없음
     * @return    ID를 문자열로 반환
     */
    public String getID()
    {
        return String.valueOf(stID);
    }

    /**
     * toString메소드 오버라이딩
     *
     * @param  없음
     * @return    출력 형식에 맞게 오버라이딩
     */
    public String toString()
    {
        return "[" + stID + "] " + name;
    }

}