package org.crazydog.daoI;

import java.util.List;

import org.crazydog.domain.HireEntity;
import org.crazydog.domain.ResumeEntity;

public interface HireDaoI {
	/**
     * 增加录取信息
     *
     * @param entity 录取信息实例
     */
    void addHire(HireEntity entity);

    /**
     * 修改简历
     *
     * @param entity 录取信息实例
     */
    void modifyHire(HireEntity entity);

    /**
     * 删除录取信息
     *
     * @param id 录取信息的id
     */
    void deleteHire(int id);

    /**
     * 获取指定的录取信息
     *
     * @param id 录取信息的id
     * @return
     */
    HireEntity getHire(int id);

    /**
     * 获取所有的录取信息
     *
     * @return
     */
    List<HireEntity> getAllHires();

}
