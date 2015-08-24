package org.crazydog.serviceI;

import java.util.List;

import org.crazydog.domain.ResumeJobsEntity;

public interface ResumeJobsServiceI {
	 /**
     * 增加工作经验
     *
     * @param entity 教育工作经验实例
     */
    void addResumeJob(ResumeJobsEntity entity);

    /**
     * 修改教育经历
     *
     * @param entity 工作经验实例
     */
    void modifyResumeJob(ResumeJobsEntity entity);

    /**
     * 删除教育经历
     *
     * @param id 工作经验的id
     */
    void deleteResumeJob(int id);

    /**
     * 获取指定的工作经验
     *
     * @param id 工作经验的id
     * @return
     */
    ResumeJobsEntity getResumeJob(int id);

    /**
     * 获取所有的工作经验
     *
     * @return
     */
    List<ResumeJobsEntity> getAllResumeJobs();
}
