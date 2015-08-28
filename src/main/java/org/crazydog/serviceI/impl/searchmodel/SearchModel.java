package org.crazydog.serviceI.impl.searchmodel;

/**
 * Created by never on 2015/8/28.
 */
public abstract class SearchModel {
    protected StringBuffer buffer = new StringBuffer();

    public abstract StringBuffer advanceSearch();

    private SearchModel cache;

    public String process(SearchModel model) {
        //如果和上次生成的hql语句一样，则不用在构建一次
        if (model.equals(cache))
            return buffer.toString();
        if (cache == null && model != null)
            cache = model;
        //否则清空上次的内容
        buffer.delete(0, buffer.length());
        StringBuffer hql = advanceSearch();
        if (hql == null)
            return null;
        return buffer.substring(0, buffer.length() - 3);
    }

    public static String advanceSearch(SearchModel searchModel) {
        return searchModel.process(searchModel);
    }
}