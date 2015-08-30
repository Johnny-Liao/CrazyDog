package org.crazydog.serviceI.impl.searchmodel;

/**
 * 使用模板设计模式完成hql语句生成。
 * 提供缓存功能
 * Created by never on 2015/8/28.
 */
public abstract class SearchModel {
    protected StringBuffer buffer = new StringBuffer();

    /**
     * 不要直接使用这个方法，这个方法是给子类实现的钩子方法
     *
     * @return
     */
    protected abstract StringBuffer advanceSearch();

    /**
     * 缓存对象，用来缓存上一次查询
     */
    private static SearchModel cache = null;

    /**
     * 因为每个advanceSearch()方法返回的语句最后都会多一个'and'字符串，所以在这里统一处理
     *
     * @return
     */
    public String process() {
        StringBuffer hql = advanceSearch();
        if (hql == null)
            return null;
        return buffer.substring(0, buffer.length() - 3);
    }

    public static String advanceSearch(SearchModel searchModel) {

        //不能传递空值进来
        if (searchModel == null)
            return null;

        //如果searchModel和上次查询的对象equals，则直接使用上一次生成的
        if (cache != null && !"".equals(cache.buffer) && searchModel.equals(cache))
            return cache.buffer.toString();

        String hql = searchModel.process();

        //将缓存设为最近的一次查询
        if (hql != null && !"".equals(hql)) {
            cache = searchModel;
            return hql;
        }
        return null;
    }
}