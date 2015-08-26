package org.crazydog.serviceI.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crazydog.daoI.Basedao;
import org.crazydog.daoI.impl.DepartmentdaoImpl;
import org.crazydog.domain.HireEntity;
import org.crazydog.domain.ResumeEntity;
import org.crazydog.serviceI.BaseService;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements BaseService<ResumeEntity> {

	@Autowired
	@Qualifier("resumedaoImpl")
	private Basedao resumedao;

	@Autowired
	@Qualifier("hireDaoImpl")
	private Basedao hiredao;

	/**
	 * 增加一份简历
	 *
	 * @param t
	 *            简历的实例对象
	 * @return
	 */
	public void addEntity(ResumeEntity t) {
		resumedao.addEntity(t);
	}

	/**
	 * 修改一份简历
	 *
	 * @param t
	 *            简历的实例对象
	 * @return
	 */
	public void modifyEntity(ResumeEntity t) {
		resumedao.modifyEntity(t);
	}

	/**
	 * 获取所有的简历
	 *
	 * @return 一个所有简历的list对象
	 * 
	 */
	public List<ResumeEntity> getAllEntities() {
		return resumedao.getAllEntities();
	}

	/**
	 * 删除一份简历
	 *
	 * @param t
	 *            简历的实例对象
	 * @return
	 */
	public void deleteEntity(ResumeEntity t) {
		resumedao.deleteEntity(t);
	}

	/**
	 * 获取一份简历
	 *
	 * @param id
	 *            简历的id
	 * @return load方法加载的一个简历对象
	 */
	public ResumeEntity loadEntity(int id) {
		return (ResumeEntity) resumedao.loadEntity(id);
	}

	/**
	 * 获取一份简历
	 *
	 * @param id
	 *            简历的id
	 * @return get方法加载的一个简历对象
	 */
	public ResumeEntity getEntity(int id) {
		return (ResumeEntity) resumedao.getEntity(id);
	}

	/**
	 * 通过姓名,学历,录取状体查询简历,所以，返回一个list对象 调用的是父类的find实现方法
	 * 
	 * @param hql
	 *            根据获取到的查询条件生成的hql语句
	 * @return 符合条件的list对象
	 */
	public List<ResumeEntity> queryEntity(String hql) {
		return (List<ResumeEntity>) resumedao.find(hql);
	}

	/**
	 * 通过姓名,学历,录取状体查询简历,增加分页的查询功能 调用的是父类的find实现方法
	 * 
	 * @param hql
	 *            根据获取到的查询条件生成的hql语句
	 * @return 符合条件的list对象
	 */
	public List<ResumeEntity> queryEntity(String hql,
			Map<String, Object> params, int page, int rows) {
		return (List<ResumeEntity>) resumedao.find(hql, params, page, rows);
	}

	/**
	 * 通过resume的id获取录取信息
	 *
	 * @return id 查询的resume的id
	 */
	public HireEntity getEntitybyreumeid(int resume_id) {
		String hql = "from HireEntity hire where hire.resumeId='" + resume_id
				+ "'";
		return (HireEntity) hiredao.find(hql).get(0);
	}

	/**
	 * 批量录取
	 * 
	 * @param id
	 *            保存的是选择界面所有被选择的复选框的value，值是相应的简历对象的id
	 * @return 符合条件的list对象
	 */
	public void batchHire(int[] id) {
		for (int i : id) {
			HireEntity hire = new HireEntity();
			hire.setId(i);
			hire.setState("录取");
			hiredao.modifyEntity(hire);
		}
	}

	/**
	 * 取消录取
	 * 
	 * @param id
	 *            被取消的id
	 * @param name
	 *            操作人的姓名
	 * 
	 */
	public void cancelHire(int id, String name) {
		HireEntity hire = (HireEntity) hiredao.getEntity(id);
		hire.setState("通过");
		String s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date());
		hire.setOperateTime(Timestamp.valueOf(s));
		hire.setOperator(name);
		hiredao.modifyEntity(hire);
	}
}
