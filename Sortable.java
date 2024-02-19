import java.util.List;

public interface Sortable<E extends Comparable<E>> {
    List<E> sort(List<E> variable);
}
