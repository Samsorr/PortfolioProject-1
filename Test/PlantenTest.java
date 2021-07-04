import org.junit.Test;

import static org.junit.Assert.*;

public class PlantenTest {



    @Test(expected = IllegalArgumentException.class)
    public void pairwiseTest1(){
        Planten plant1 = new Coco("Ria", "Coco", 0,4);
    }

    @Test
    public void pairwiseTest2() {
        Planten plant2 = new Coco("Ria", "Coco", 7,6);
        assertTrue(plant2.getSoort().equals("Coco") && plant2.getWaterbehoefte() == 7 &&  plant2.getPhWaarde() == 6 );
    }

    @Test
    public void pairwiseTest3(){
        Planten plant3 = new Kentiaplam("Ria", "Kentiapalm", 6,6,12);
        assertTrue(plant3.getSoort().equals("Kentiapalm") && plant3.getWaterbehoefte() == 6 &&  plant3.getPhWaarde() == 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pairwiseTest4(){
        Planten plant3 = new Kentiaplam("Ria", "Kentiapalm", 2,8,15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pairwiseTest5(){
        Planten plant4 = new Alocasia("John", "Alocasia", 1, 9,3);
    }

    @Test
    public void pairwiseTest6(){
        Planten plant6 = new Alocasia("Ria", "Alocasia", 3,5,12);
        assertTrue(plant6.getSoort().equals("Alocasia") && plant6.getWaterbehoefte() == 3 &&  plant6.getPhWaarde() == 6);
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