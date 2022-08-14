package com.junmo.df.controller;

import com.junmo.df.vo.requset.ImportVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        log.trace("trace");
        log.debug("ddebug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        return null;
    }

}
