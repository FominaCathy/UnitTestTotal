package average;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Интеграционные тесты.
 */
public class IntegrationTest extends BaseTest {
    /**
     * предустановки.
     */
    @BeforeAll
    static void init() {
        start(new CompareAverage());
    }

    /**
     * Проверка результата сравнения списков по среднему значению.
     *
     * @param first  список
     * @param second список
     * @param result ожидаемый результат
     */
    @DisplayName("Проверка результата сравнения списков по среднему значению")
    @ParameterizedTest(name = "сравнение {0} и {1} - результат - {2}")
    @MethodSource("average.MethodsProvider#paramIntegrationPositiveTest")
    @Tag("itegration")
    final void positiveTest(final List<Integer> first,
                            final List<Integer> second,
                            final String result) {
        assertEquals(result, getService().compareLists(first, second));
    }
}
