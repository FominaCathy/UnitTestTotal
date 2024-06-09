package average;

/**
 * Базовый класс с общими переменными.
 */
public abstract class BaseTest {
    /**
     * Компаратор.
     */
    private static ComparatorList<Integer> comparator;
    /**
     * Экземпляр сервиса.
     */
    private static Service service;

    /**
     * установка начальных данных.
     *
     * @param currentComparator - компаратор.
     */
    public static void start(
            final ComparatorList<Integer> currentComparator) {
        comparator = currentComparator;
        service = new Service(currentComparator);
    }

    /**
     * геттер для сомпаратора.
     *
     * @return компаратор.
     */
    public static ComparatorList<Integer> getComparator() {
        return comparator;
    }

    /**
     * геттер для сервиса.
     *
     * @return сервис.
     */
    public static Service getService() {
        return service;
    }
}
