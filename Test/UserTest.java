import static org.junit.Assert.*;

public class UserTest {


    @org.junit.Test
    public void constructorTest(){
        User samsor = new User("sam", "samsor13@icloud.com", "lol");
        assertEquals(samsor, samsor);
    }

}