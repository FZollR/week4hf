package clasokinftest;

import classokinf.StaticBank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StaticBankTest {

    private  StaticBank staticBank;
    @BeforeEach
    public void setup()
    {
       staticBank = new StaticBank();
    }
    @Test
    public void testConvertShouldReturnOneWhenTheCurrenciesAreTheSame()
    {
        //given

        //when
        BigDecimal result = staticBank.convert(Currency.getInstance("HUF"), Currency.getInstance("HUF"));
        BigDecimal result2 = staticBank.convert(Currency.getInstance("HUF"), Currency.getInstance("HUF"));

        //then
        assertEquals(BigDecimal.ONE, result);
    }
    @Test
    public void testConvertShouldThrowExceptionWhenConvertionIsNotGood() {
        // given in setup

        // when
        BigDecimal result = staticBank.convert(Currency.getInstance("HUF"), Currency.getInstance("USD"));

        // then
        assertEquals(BigDecimal.valueOf(1.0 / 249.3), result);
    }

    @Test
    public void testConvertShouldThrowShouldThrowExceptionWhenCurrencyIsUnknown()
    {
        //given in setup

        //when - then
        assertThrows(RuntimeException.class, () ->
        {staticBank.convert(Currency.getInstance("HUF"), Currency.getInstance("EUR"));
        });


    }
}
