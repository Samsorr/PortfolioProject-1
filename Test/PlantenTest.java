import org.junit.Test;

import static org.junit.Assert.*;

public class PlantenTest {



    @Test
    public void checkSoortTest1(){
        Planten plant1 = new Coco("Henk", "Coco", 4, 7);
        Planten plant3 = new Kentiaplam("Mila", "Kentiapalm", 8, 3);
        assertTrue(plant1.getSoort().equals("Coco"));
        assertTrue(plant3.getSoort().equals("Kentiapalm"));
    }


    @Test(expected = IllegalArgumentException.class)
        public void checkSoortTest2() {
            Planten plant2 = new Alocasia("John", "Alocasia", 7, 2);
        }


    @Test(expected = IllegalArgumentException.class)
    public void checkWaterTest1() {
        Planten plant4 = new Coco("John", "Coco", 0, 8);
        Planten plant5 = new Alocasia("John", "Alocasia", 2, 9);
    }


    @Test
    public void checkWaterTest2(){
        Planten plant6 = new Coco("Henk", "Coco", 3, 5);
        assertTrue(plant6.waterCheck(plant6.getWaterbehoefte()));
    }




}