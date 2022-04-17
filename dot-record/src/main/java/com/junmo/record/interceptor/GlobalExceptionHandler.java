package com.junmo.record.interceptor;

import com.google.common.collect.Lists;
import com.junmo.common.result.ApiResult;
import com.junmo.common.result.CodeEnum;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: sucf
 * @date: 2022/4/4 15:59
 * @description: 全局处理异常拦截
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param request
     * @param ex
     * @return
     * @Valid封装返回值
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ApiResult<?> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        log.error("@Valid-Exception uri:{},ex:{}", request.getRequestURI(), ex);
        List<String> result = Lists.newArrayList();
        BindingResult bindingResult = ex.getBindingResult();
        for (ObjectError objectError : bindingResult.getAllErrors()) {
            result.add(objectError.getDefaultMessage());
        }
        return ApiResult.buildFailResult(CodeEnum.PARAMETER_ERROR.getCode(), result.toString());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ApiResult<?> handleBusinessException(HttpServletRequest request, BusinessException ex) {
        log.error("handleBusinessException uri:{},ex: ", request.getRequestURI(), ex);
        return ApiResult.buildFailResult(ex.getCode(), ex.getMessage());
    }

    /**
     * sql相关异常处理
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(SqlException.class)
    @ResponseBody
    public Result<?> handleSqlException(HttpServletRequest request, SqlException ex) {
        ex.printStackTrace();
        log.error("handleSqlException uri:{},ex: ", request.getRequestURI(), ex);
        return Result.buildFailResult(ex.getCode(), ex.getMessage());
    }

    /**
     * 无法预知的异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Result<?> handleException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        log.error("handleException uri:{},ex: ", request.getRequestURI(), ex);
        return Result.buildFailResult(CodeEnum.SYSTEM_ERROR.getCode(), "抱歉，系统有点小问题，请稍后再试");
    }


}
