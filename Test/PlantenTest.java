import org.junit.Test;

import static org.junit.Assert.*;

public class PlantenTest {



    @Test(expected = IllegalArgumentException.class)
    public void pairwiseTest1() {
        Planten plant1 = new Coco("Henk", "Coco", 0);
    }

    @Test
    public void pairwiseTest2(){
        Planten plant2 = new Coco("Mila", "Coco", 7);
        assertTrue(plant2.getSoort().equals("Coco"));
    }

    @Test
    public void pairwiseTest3(){
        Planten plant3 = new Kentiaplam("Ria", "Kentiapalm", 6,5);
        assertTrue(plant3.getSoort().equals("Kentiapalm"));
    }

    @Test(expected = IllegalArgumentException.class)
        public void pairwiseTest4() {
        Planten plant4 = new Kentiaplam("John", "Kentiapalm", 2, 2);
        }

    @Test(expected = IllegalArgumentException.class)
    public void pairwiseTest5() {
        Planten plant5 = new Alocasia("Heo", "Alocasia", 1, 4);
    }

    @Test
    public void pairwiseTest6(){
        Planten plant6 = new Alocasia("Ria", "Alocasia", 6,5);
        assertTrue(plant6.getSoort().equals("Alocasia"));
    }




        /*
    @Test(expected = IllegalArgumentException.class)
    public void checkWaterTest1() {
        Planten plant4 = new Coco("John", "Coco", 0);
        Planten plant5 = new Alocasia("John", "Alocasia", 2, 9);
    }


    @Test
    public void checkWaterTest2(){
        Planten plant6 = new Coco("Henk", "Coco", 7);
        assertTrue(plant6.waterCheck(plant6.getWaterbehoefte()));
    }

*/


}