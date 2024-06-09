package average;

import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Класс с методами- поставщиками данных для тестов.
 */
public abstract class MethodsProvider {
    /**
     * лист с меньшим средним значением.
     */
    private static final List<Integer> SMOLL_LIST = Arrays.asList(2, 2);
    /**
     * лист с большим значением.
     */
    private static final List<Integer> BIG_LIST = Arrays.asList(4, 2, 3);
    /**
     * лист с большим значением.
     */
    private static final List<Integer> OTHER_BIG_LIST = Arrays.asList(4, 2);

    /**
     * поставщик аргументов для проверки возвращаемых сообщений классом Service.
     *
     * @return данные для тестов
     */
    static Stream<Arguments> paramsServiceTest() {
        return Stream.of(
                Arguments.of(-1,
                        "Второй список имеет большее среднее значение"),
                Arguments.of(0, "Средние значения равны"),
                Arguments.of(1, "Первый список имеет большее среднее значение")
        );
    }

    /**
     * поставщик параметров.
     * для проверки позитивных тестов сравнения средего знначения листов.
     * для класса average.CompareArraysTest
     *
     * @return данные для тестов.
     */
    static Stream<Arguments> paramsCompareArraysTestPositive() {
        return Stream.of(
                Arguments.of(BIG_LIST, OTHER_BIG_LIST, 0),
                Arguments.of(BIG_LIST, SMOLL_LIST, 1),
                Arguments.of(SMOLL_LIST, BIG_LIST, -1));
    }

    /**
     * поставщик аргументов.
     * для проверки негативных тестов сравнения средего значения листов
     * для класса average.CompareArraysTest
     *
     * @return данные для тестов.
     */
    static Stream<Arguments> paramsCompareArraysTestNegative() {
        return Stream.of(
                Arguments.of(List.of(), SMOLL_LIST,
                        IllegalArgumentException.class,
                        "Ошибка расчета среднего для пустого списка"),
                Arguments.of(SMOLL_LIST, null,
                        NullPointerException.class,
                        "Ошибка расчета среднего для значения null"));
    }
    /**
     * поставщик аргументов.
     * для проверки позитивных тестов сравнения средего значения листов
     * для класса average.Service
     *
     * @return данные для тестов.
     */
    static Stream<Arguments> paramIntegrationPositiveTest() {
        return Stream.of(
                Arguments.of(BIG_LIST, OTHER_BIG_LIST,
                        "Средние значения равны"),
                Arguments.of(BIG_LIST, SMOLL_LIST,
                        "Первый список имеет большее среднее значение"),
                Arguments.of(SMOLL_LIST, BIG_LIST,
                        "Второй список имеет большее среднее значение"));
    }
}
