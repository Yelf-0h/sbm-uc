package edu.springboot.sbmuc.service.impl;

public class BaseServiceImpl<T> {
    /**
     * [处理页码]
     * ui层传来的pageNum，在daoimpl要转为startIndex或startNum；
     * <p>
     * 但daoimpl已由MyBatis生成，无法处理，故当前方案是在serviceimpl里处理。
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Long dealPageNum(Long pageNum, Long pageSize) {
        return new Long((pageNum - 1) * pageSize);
    }

    /**
     * 【处理页大小】
     * <p>
     * ui层传来的pageNum，在daoimpl要转为endIndex或endNum或原来的pageSize；
     * <p>
     * 但daoimpl已由MyBatis生成，无法处理，故当前方案是在serviceimpl里处理。
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Long dealPageSize(Long pageNum, Long pageSize) {
        return new Long(pageSize);
    }
}
