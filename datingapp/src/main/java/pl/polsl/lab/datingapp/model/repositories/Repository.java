package pl.polsl.lab.datingapp.model.repositories;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic abstract class which holds list of T objects
 * @version 0.0.2
 * @author Tomasz Knura
 */
public abstract class Repository<T> {
    /** list of T objects */
    private List<T> list;

    /**
     * Non argument constructor
     */
    public Repository() {
        list = new ArrayList<>();
    }
    
    /**
     * Method which add item to repository list
     * @param t object which will be added to repository
     * @return boolean value which indicates is operation succeeded
     */
    public boolean addItem(T t) {
        return list.add(t);
    }

    /**
     * Method which remove item from repository list
     * @param index index of item which will be removed from repository
     * @return removed object or null if not found
     */
    public T removeItem(int index) {
        return list.remove(index);
    }

    /**
     * Method which find item in repository list by index
     * @param index index of a t item to find
     * @return T object if found null if not
     */
    public T findByIndex(int index) {
        return list.get(index);
    }

    /**
     * List getter
     * @return list of objects in repository
     */
    public List<T> getList() {
        return list;
    }

    /**
     * List setter
     * @param list list to set in repository
     */
    public void setList(List<T> list) {
        this.list = list;
    }
}
