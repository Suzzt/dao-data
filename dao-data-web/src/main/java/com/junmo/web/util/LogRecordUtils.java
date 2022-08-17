package com.junmo.web.util;

import cn.hutool.core.util.StrUtil;
import com.junmo.common.record.SimpleDotLog;
import com.junmo.common.result.CodeEnum;
import com.junmo.web.interceptor.exception.ParamException;

/**
 * @author: sucf
 * @date: 2022/8/14 23:23
 * @description:
 */
public class LogRecordUtils {
    public static SimpleDotLog conversion(String dotLog, String separator) {
        //分解dotLog日志信息
        String[] data = dotLog.split(separator);
        if (data.length < 5) {
            //不可能小于5个数
            throw new ParamException(CodeEnum.PARAM_SEPARATOR_LENGTH_SHORT);
        }
        SimpleDotLog dotLogDTO = new SimpleDotLog();
        dotLogDTO.setEvent(StrUtil.trim(data[0]));
        dotLogDTO.setAffiliateId(data[1]);
        dotLogDTO.setUserId(data[2]);
        dotLogDTO.setPlatform(data[3]);
        dotLogDTO.setVersion(data[4]);
        return dotLogDTO;
    }

}
