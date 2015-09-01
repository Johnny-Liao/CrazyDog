package org.crazydog.serviceI.impl.searchmodel;

/**
 * 使用模板设计模式完成hql语句生成。
 * 提供缓存功能
 * <p>
 * 使用方式为:
 * 先实例化相应的searchModel
 * SearchModel.advanceSearch(#searchModel);
 * <p>
 * 还有equals方法在这里很重要，实现的时候务必判断每个属性是否为空
 * <p>
 * 不推荐直接调用advanceSearch方法。因为这个方法只是处理的一个中间环节
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
        //hql主要用来标识方法处理之后的状态，hql是buffer的一个缩影
        StringBuffer hql = advanceSearch();
        if (hql == null)
            return null;
        buffer.delete(hql.length() - 3, hql.length());
        return buffer.toString();
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