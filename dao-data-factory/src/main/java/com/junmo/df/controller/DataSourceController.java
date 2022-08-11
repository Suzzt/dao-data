package com.junmo.df.controller;

import com.junmo.df.vo.requset.ImportVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: sucf
 * @date: 2022/8/4 15:50
 * @description: 数据源
 */
@RestController
@Slf4j
@RequestMapping(value = "data-source")
public class DataSourceController {
    @PostMapping("import")
    public String dataImport(@Valid @RequestBody ImportVO importVO) {
        return null;
    }

}
