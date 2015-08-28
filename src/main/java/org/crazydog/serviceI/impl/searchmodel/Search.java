package org.crazydog.serviceI.impl.searchmodel;

/**
 * Created by never on 2015/8/28.
 */
public abstract class Search<T> {
    protected StringBuffer buffer = new StringBuffer();

    public abstract String advanceSearch(T model);

    public boolean checkNull(Object obj) {
        if (obj != null)
            return true;
        else return false;
    }

}