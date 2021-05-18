import static org.junit.Assert.*;

public class UserTest {

    User samsor = new User("sam", "samsor13@icloud.com", "lol");
    User julia = new User("juliadejong123456", "samsor13@icloud.com", "lol");


    @org.junit.Test
    public void constructorTest(){
        assertEquals(samsor, samsor);           //Testen of het juiste object wordt aangemaakt.
    }

    @org.junit.Test
    public void gebruikersnaamLengthTest(){
        assertEquals("juliadejong1234", julia.getGebruikersnaam());           //Testen of het gemaakte object een gebruikersnaam heeft met 15 karakters of minder.
    }



}