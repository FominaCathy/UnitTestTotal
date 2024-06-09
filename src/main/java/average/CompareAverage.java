package average;

import java.util.List;

/**
 * Класс содержит методы сравнения списков.
 */
public class CompareAverage implements ComparatorList<Integer> {

    /**
     * метод сравнивает списки по среднему значению и возвращает:
     * -1, если первый список меньше второго,
     * 1, если первый список больше второго
     * 0, если списки равны.
     *
     * @param list  список.
     * @param other список.
     * @return код результата.
     */
    public final int compare(final List<Integer> list,
                             final List<Integer> other) {
        double res = average(list) - average(other);
        if (res < 0) {
            return -1;
        }
        if (res > 0) {
            return 1;
        }
        return 0;

    }

    /**
     * вспомогательный метод. вычисляет среднее значение списка.
     *
     * @param list непустой список целых значений
     * @return среднее  значение элементов списка
     */
    private double average(final List<Integer> list) {
        if ((list == null)) {
            throw new NullPointerException(
                    "Ошибка расчета среднего для значения null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException(
                    "Ошибка расчета среднего для пустого списка");
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

}
