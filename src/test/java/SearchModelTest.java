import org.crazydog.serviceI.impl.SearchModel;
import org.junit.Before;
import org.junit.Test;

public class SearchModelTest {

	private SearchModel model;

	@Before
	public void before() {
		model = new SearchModel("李飞", "高中", "一审");
	}

	@Test
	public void testSearch() {
		System.out.println(model.advanceSearch());
	}
}
