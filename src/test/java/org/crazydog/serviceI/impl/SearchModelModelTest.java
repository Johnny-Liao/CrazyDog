package org.crazydog.serviceI.impl;

import org.crazydog.serviceI.impl.searchmodel.SearchModel;
import org.crazydog.serviceI.impl.searchmodel.UnitSearchModel;
import org.junit.Test;

public class SearchModelModelTest {

    //	private SearchModel model;
//    @Autowired
//    private Basedao basedao;
//
//	@Before
//	public void before() {
//		model = new SearchModel("李飞", "高中", "一审");
//	}
//
    @Test
    public void testSearch() {
//        SearchModel searchModel = new ContractSearchModel("JT_01", "张三", "农大", new Timestamp(new Date(1970, 12, 1).getTime()), new Timestamp(new Date(1980, 12, 1).getTime()));
//        SearchModel searchModel1 = new ContractSearchModel(null, null, null, null, null);
//        System.out.println(searchModel1.advanceSearch(searchModel));
//        System.out.println(model.advanceSearch());
//        String hql = model.advanceSearch();
//        List list = basedao.find(hql);
//        Iterator it = list.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        SearchModel searchModel = new UnitSearchModel(null, null);
        SearchModel searchModel2 = new UnitSearchModel("ND", "农大");
        String s = UnitSearchModel.advanceSearch(searchModel);
        System.out.println(s);
        s = searchModel.advanceSearch(searchModel2);
        System.out.println(s);
    }

}
