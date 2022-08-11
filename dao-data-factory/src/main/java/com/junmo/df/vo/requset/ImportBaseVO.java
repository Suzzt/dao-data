package com.junmo.df.vo.requset;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @author: sucf
 * @date: 2022/8/11 11:58
 * @description:
 */
@Data
public class ImportBaseVO {
    /**
     * 资源类型
     */
    @NotNull(message = "resourceType不能为空")
    private String resourceType;
}
