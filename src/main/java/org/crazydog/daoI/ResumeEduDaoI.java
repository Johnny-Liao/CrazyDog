package org.crazydog.daoI;

import java.util.List;

import org.crazydog.domain.ResumeEduEntity;
import org.crazydog.domain.ResumeEntity;

public interface ResumeEduDaoI {
	    /**
	     * 增加教育经历
	     *
	     * @param entity 教育经历实例
	     */
	    void addResumeEdu(ResumeEduEntity entity);

	    /**
	     * 修改教育经历
	     *
	     * @param entity 教育经历实例
	     */
	    void modifyResumeEdu(ResumeEduEntity entity);

	    /**
	     * 删除教育经历
	     *
	     * @param id 教育经历的id
	     */
	    void deleteResumeEdu(int id);

	    /**
	     * 获取指定的教育经历
	     *
	     * @param id 教育经历的id
	     * @return
	     */
	    ResumeEduEntity getResumeEdu(int id);

	    /**
	     * 获取所有的教育经历
	     *
	     * @return
	     */
	    List<ResumeEduEntity> getAllResumeEdus();

}
