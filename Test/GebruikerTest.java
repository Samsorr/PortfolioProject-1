import static org.junit.Assert.*;

public class GebruikerTest {

    Gebruiker samsor = new Gebruiker("sam", "samsor13@icloud.com");
    Gebruiker julia = new Gebruiker("juliadejong123456", "samsor13@icloud.com");


    @org.junit.Test
    public void gebruikersnaamLengthTest(){
        assertEquals("juliadejong1234", julia.getName());  //Testen of het gemaakte object een gebruikersnaam heeft met 15 karakters of minder.
        assertTrue(julia.getName().length() == 15);

    }


    @org.junit.Test
    public void constructorTest(){
        assertEquals(samsor, samsor);           //Testen of het juiste object wordt aangemaakt.
        assertFalse(samsor.getName().equals(julia)); //Testen of 2 objecten verschillen.
    }



}