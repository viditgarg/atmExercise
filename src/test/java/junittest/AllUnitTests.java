package junittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestAccount.class,
    TestCard.class,
    ATMTest.class
})
public class AllUnitTests {	
}
