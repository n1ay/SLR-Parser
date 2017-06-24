import com.github.n1ay.parser.Symbol;
import org.junit.Assert;
import org.junit.Test;

public class SymbolTest {

    @Test
    public void symbolEqualsTrueTest() {
        Symbol s1 = new Symbol("S\'");
        Symbol s2 = new Symbol("S\'");
        Assert.assertEquals(true, s1.equals(s2));
    }

    @Test
    public void symbolEqualsNullArgumentTest() {
        Symbol s1 = new Symbol("L\'\'");
        Assert.assertEquals(false, s1.equals(null));
    }

    @Test
    public void symbolEqualsFalseArgumentTest() {
        Symbol s1 = new Symbol("A\'");
        Symbol s2 = new Symbol("A");
        Assert.assertEquals(false, s1.equals(s2));
    }

    @Test
    public void symbolEqualsOtherClassArgumentTest() {
        Symbol s1 = new Symbol("B\"");
        Integer testInteger = 3;
        Assert.assertEquals(false, s1.equals(testInteger));
    }
}
