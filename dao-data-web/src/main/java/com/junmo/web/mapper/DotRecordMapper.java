package com.junmo.web.mapper;

import com.junmo.web.entity.DotRecord;

public interface DotRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DotRecord record);

    int insertSelective(DotRecord record);

    DotRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DotRecord record);

    int updateByPrimaryKey(DotRecord record);
}