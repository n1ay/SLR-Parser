import com.github.n1ay.parser.Hashmatrix;
import org.junit.Test;
import org.junit.Assert;

import java.util.Hashtable;

public class HashmatrixGetPutTest {

    @Test
    public void putValueIntoHashmatrix() {
        Hashmatrix<Integer, Integer, Integer> matrix = new Hashmatrix<>(3, 3);
        matrix.put(1, 2, 3);
        Assert.assertEquals(3, (int)matrix.get(1, 2));
    }

    @Test
    public void putTwoValuesContinuouslyIntoHashmatrix() {
        Hashmatrix<Integer, Integer, Integer> matrix = new Hashmatrix<>(3, 3);
        matrix.put(1, 2, 3);
        matrix.put(1, 1, 7);
        Assert.assertEquals(3, (int)matrix.get(1, 2));
        Assert.assertEquals(7, (int)matrix.get(1, 1));
    }

    @Test(expected = NullPointerException.class)
    public void getFromEmptyHashmatrix() {
        Hashmatrix<Integer, Integer, Integer> matrix = new Hashmatrix<>(1,1);
        matrix.get(0,0);
    }

    @Test
    public void getValueFromHashmatrix() {
        Hashmatrix<Integer, Integer, Integer> matrix = new Hashmatrix<>(3, 3);
        Hashtable<Integer, Integer> table = new Hashtable<>(3);
        table.put(0, 16);
        matrix.matrix.put(1, table);
        Assert.assertEquals(16, (int)matrix.get(1, 0));
    }

}
