public interface IConjunto<T> extends Iterable<T>, Cloneable{
    boolean add(T t);
    Conjunto<T> addAll(Conjunto<T> t);
    int size();
    T get(int idx);
    boolean contains(Object o);
    boolean isEmpty();
}
