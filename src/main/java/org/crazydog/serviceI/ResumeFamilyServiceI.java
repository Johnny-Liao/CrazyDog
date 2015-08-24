package org.crazydog.serviceI;

import java.util.List;

import org.crazydog.domain.ResumeFamilyEntity;

public interface ResumeFamilyServiceI {
	/**
     * 添加家庭成员
     *
     * @param entity 家庭成员实体
     */
    void addResumeFamily(ResumeFamilyEntity entity);

    /**
     * 修改家庭成员
     *
     * @param entity 家庭成员实例
     */
    void modifyResumeFamily(ResumeFamilyEntity entity);

    /**
     * 删除家庭成员
     *
     * @param id 家庭成员的id
     */
    void deleteResumeFamily(int id);

    /**
     * 获取指定的家庭成员
     *
     * @param id 家庭成员的id
     * @return
     */
    ResumeFamilyEntity getResumeFamily(int id);

    /**
     * 获取所有的家庭成员
     *
     * @return
     */
    List<ResumeFamilyEntity> getAllResumeFamilys();
}
