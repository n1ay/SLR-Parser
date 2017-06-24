import com.github.n1ay.parser.SLR1;
import com.github.n1ay.parser.SLRExampleClass;
import com.github.n1ay.parser.Symbol;
import com.github.n1ay.parser.action.ParsingErrorException;
import org.junit.Assert;
import org.junit.Test;

public class SLRActionReduceTest {

    private void initSLRSituation(SLR1 slr) {
        slr.getStateStack().push(0);
        slr.getStateStack().push(2);
        slr.getStateStack().push(4);
        slr.getStateStack().push(5);
        slr.getStateStack().push(3);

        slr.getSymbolStack().push(slr.getGrammar().getSymbol("a"));
        slr.getSymbolStack().push(slr.getGrammar().getSymbol("("));
        slr.getSymbolStack().push(slr.getGrammar().getSymbol("S"));
        slr.getSymbolStack().push(slr.getGrammar().getSymbol("*"));

        slr.setInput(Symbol.createList(")", "*", "$"));
    }

    private void initSLRSituation2(SLR1 slr) {
        slr.getStateStack().push(0);
        slr.getStateStack().push(1);
        slr.getStateStack().push(3);

        slr.getSymbolStack().push(slr.getGrammar().getSymbol("S"));
        slr.getSymbolStack().push(slr.getGrammar().getSymbol("*"));

        slr.setInput(Symbol.createList("$"));
    }

    @Test
    public void NewSymbolOnAStackAfterReduceTest() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation(slr);

        slr.getParsingTable().get(slr.getStateStack().peek(), slr.getInput().get(0)).action(slr);
        Assert.assertEquals(true, new Symbol("S").equals(slr.getSymbolStack().peek()));
    }

    @Test
    public void NewStateAfterReduceTest() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation(slr);

        slr.getParsingTable().get(slr.getStateStack().peek(), slr.getInput().get(0)).action(slr);
        Assert.assertEquals(slr.getParsingTable().get(4, slr.getGrammar().getSymbol("S")).getArg(),
                (int)slr.getStateStack().peek());
    }

    @Test
    public void NewProductionOnAListTest() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation(slr);
        int size = slr.getProductionList().size();

        slr.getParsingTable().get(slr.getStateStack().peek(), slr.getInput().get(0)).action(slr);
        Assert.assertEquals(true, slr.getProductionList().size() > size);
    }

    @Test
    public void NewSymbolOnAStackAfterReduceTest2() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation2(slr);

        slr.getParsingTable().get(slr.getStateStack().peek(), slr.getInput().get(0)).action(slr);
        Assert.assertEquals(true, new Symbol("S").equals(slr.getSymbolStack().peek()));
    }

    @Test
    public void NewStateAfterReduceTest2() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation2(slr);

        slr.getParsingTable().get(slr.getStateStack().peek(), slr.getInput().get(0)).action(slr);
        Assert.assertEquals(slr.getParsingTable().get(0, slr.getGrammar().getSymbol("S")).getArg(),
                (int)slr.getStateStack().peek());
    }

    @Test
    public void NewProductionOnAListTest2() throws ParsingErrorException {
        SLR1 slr = SLRExampleClass.getSLR();
        initSLRSituation2(slr);
        int size = slr.getProductionList().size();

        slr.getParsingTable().get(slr.getStateStack().peek(), slr.getInput().get(0)).action(slr);
        Assert.assertEquals(true, slr.getProductionList().size() > size);
    }
}
