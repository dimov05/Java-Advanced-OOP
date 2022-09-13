package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BubbleTest {
    @Test
    public void testSortingMethodWork(){
        int[] array = {5,2,123,23,53,25};
        Bubble.sort(array);
        int[] sortedArray = {2,5,23,25,53,123};
        for(int i = 0; i<array.length;i++){
            assertEquals(array[i],sortedArray[i],0);
        }
    }
}
