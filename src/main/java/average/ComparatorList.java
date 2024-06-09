package average;

import java.util.List;

/**
 * интерфейс для компаратора сравнения списков.
 *
 * @param <T> тип значений в списках
 */
public interface ComparatorList<T> {
    /**
     * метод сравнения.
     *
     * @param first  список.
     * @param second список.
     * @return код результата.
     */
    int compare(List<T> first, List<T> second);
}
