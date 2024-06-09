package average;

import java.util.List;

/**
 * Класс сравнивает 2 списка и возвращает строку с результатом.
 */
public class Service {
    /**
     * компаратор, который используется для сравнения.
     */
    private ComparatorList<Integer> comparator;

    /**
     * конструктор для инициализации класса.
     *
     * @param currentComparator - компаратор
     */
    public Service(final ComparatorList<Integer> currentComparator) {
        this.comparator = currentComparator;
    }

    /**
     * метод сравнивает 2 списка по среднему значению и строку с результатом.
     *
     * @param fist   - первый список
     * @param second - второй список
     * @return - строка с результатом
     */
    public final String compareLists(final List<Integer> fist,
                               final List<Integer> second) {

        int res = comparator.compare(fist, second);

        if (res > 0) {
            return "Первый список имеет большее среднее значение";
        } else if (res < 0) {
            return "Второй список имеет большее среднее значение";
        }

        return "Средние значения равны";
    }
}
