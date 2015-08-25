package org.crazydog.daoI;

import org.crazydog.domain.ResumeFamilyEntity;

import java.util.List;

/**
 * 对简历里包含的家庭成员信息进行操作
 */
public interface ResumeFamilyDaoI {
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
