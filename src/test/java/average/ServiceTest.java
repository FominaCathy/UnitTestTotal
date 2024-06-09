package average;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Тесты класса Service. Класс CompareAverage замокирован.
 */
public class ServiceTest extends BaseTest {
    /**
     * первый список.
     */
    private static List<Integer> first;
    /**
     * второй список.
     */
    private static List<Integer> second;

    /**
     * инициализация сервиса.
     */
    @BeforeAll
    static void init() {
        start(mock(CompareAverage.class));

        first = new ArrayList<>();
        second = new ArrayList<>();
    }

    /**
     * Проверка возвращаемого сообщения на результат сравнения.
     *
     * @param result   код ответа от CompareAverage.
     * @param responce ожидаемое строковое сообщение.
     */
    @ParameterizedTest(name = "{index} - код ={0}, ответ = {1}")
    @DisplayName("Проверка возвращаемого сообщения на результат сравнения")
    @MethodSource("average.MethodsProvider#paramsServiceTest")
    @Tag("unit")
    final void test(final int result, final String responce) {
        when(getComparator().compare(anyList(), anyList())).thenReturn(result);
        assertEquals(getService().compareLists(first, second), responce);
    }
}
