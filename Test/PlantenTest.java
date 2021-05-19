import org.junit.Test;

import static org.junit.Assert.*;

public class PlantenTest {



    @Test
    public void checkSoortTest1(){
        Planten plant1 = new Planten("Henk", "Coco", 4);
        Planten plant3 = new Planten("Mila", "Kentiapalm", 8);
        assertTrue(plant1.soortCheck("Coco"));
        assertTrue(plant3.soortCheck("Kentiapalm"));
    }


    @Test(expected = IllegalArgumentException.class)
        public void checkSoortTest2() {
            Planten plant2 = new Planten("John", "Fleurila", 7);
        }


    @Test(expected = IllegalArgumentException.class)
    public void checkWaterTest1() {
        Planten plant4 = new Planten("John", "Coco", 0);
        Planten plant5 = new Planten("John", "Fleurila", 2);
    }


    @Test
    public void checkWaterTest2(){
        Planten plant6 = new Planten("Henk", "Coco", 3);
        assertTrue(plant6.waterCheck(plant6.getWaterbehoefte()));
    }




}