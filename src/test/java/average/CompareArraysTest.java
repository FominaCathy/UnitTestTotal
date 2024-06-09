package average;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тестирование класса CompareAverage.
 */
public class CompareArraysTest extends BaseTest {
    /**
     * предустановки.
     */
    @BeforeAll
    static void init() {
        start(new CompareAverage());
    }

    /**
     * Сравнение средних значений списковю Позитивные сценарии.
     *
     * @param first  список
     * @param second список
     * @param result ожидаемый результат
     */
    @DisplayName("Сравнение средних значений списков")
    @ParameterizedTest(name = "Сравнение: лист {0} и лист {1}, результат = {2}")
    @MethodSource("average.MethodsProvider#paramsCompareArraysTestPositive")
    @Tag("unit")
    final void testPositive(final List<Integer> first,
                            final List<Integer> second,
                            final int result) {
        assertEquals(result, getComparator().compare(first, second));
    }

    /**
     * Проверка выбрасывания исключения.
     *
     * @param first          список
     * @param second         список
     * @param exceptionClass ожидаемое исключение
     * @param msg            ожидаемое сообщение
     */
    @DisplayName("Проверка выбрасывания исключения")
    @ParameterizedTest(name =
            " лист {0} и лист {1}, класс = {2}, сообщение об ошибке: {3}")
    @MethodSource("average.MethodsProvider#paramsCompareArraysTestNegative")
    @Tag("unit")
    final void testThrow(final List<Integer> first,
                         final List<Integer> second,
                         final Class<RuntimeException> exceptionClass,
                         final String msg) {
        Throwable throwable = assertThrows(exceptionClass,
                () -> getComparator().compare(first, second));
        assertEquals(msg, throwable.getMessage());
    }


}
