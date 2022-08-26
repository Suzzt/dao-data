package com.junmo.web.mapper;

import com.junmo.web.entity.DotRecord;
import com.junmo.web.entity.DotRecordQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DotRecordMapper {
    int insertSelective(DotRecord record);

    DotRecord getBy(DotRecordQuery query);

    List<DotRecord> selectBy(DotRecordQuery query);

    Integer countBy(DotRecordQuery query);

    Integer updateById(DotRecord record);

    Integer deleteById(@Param("id") Long id);

    int batchInsert(@Param("dotRecordList") List<DotRecord> list);
}