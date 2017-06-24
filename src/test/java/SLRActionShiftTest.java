import com.github.n1ay.parser.SLR1;
import com.github.n1ay.parser.SLRExampleClass;
import com.github.n1ay.parser.Symbol;
import com.github.n1ay.parser.action.ParsingErrorException;
import org.junit.Assert;
import org.junit.Test;

public class SLRActionShiftTest {

    private void initSLRSituation(SLR1 slr) {
        slr.getStateStack().push(0);
        slr.setInput(Symbol.createList("a", "(", "a", "*", ")", "*", "$"));
    }

    @Test
    public void NewSymbolOnAStackAfterShiftTest() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation(slr);

        slr.getParsingTable().get(0, slr.getInput().get(0)).action(slr);
        Assert.assertEquals(true, slr.getSymbolStack().peek().equals(new Symbol("a")));
    }

    @Test
    public void NewStateOnAStackAfterShiftTest() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation(slr);

        slr.getParsingTable().get(0, slr.getInput().get(0)).action(slr);
        Assert.assertEquals(slr.getParsingTable().get(0, slr.getGrammar().getSymbol("a")).getArg(),
                (int)slr.getStateStack().peek());
    }

    @Test
    public void RemoveSymbolFromInputAfterShiftTest() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation(slr);

        slr.getParsingTable().get(0, slr.getInput().get(0)).action(slr);
        Assert.assertEquals(true, new Symbol("(").equals(slr.getInput().get(0)));
    }
}
