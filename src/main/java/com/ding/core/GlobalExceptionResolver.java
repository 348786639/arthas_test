package com.ding.core;

import com.ding.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice(basePackages = {"com.ding"})
public class GlobalExceptionResolver {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);
	
	
	 /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(BusinessRuntimeException.class)
    @ResponseBody
    public Result handleOpdRuntimeException(BusinessRuntimeException e) {
        // 不打印异常堆栈信息
		Result<?> result = new Result<>();
		result.setCode(e.getCode());
		result.setSuccess(false);
		result.setMsg(e.getMessage());
		return result;
    }

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object handleOpdRuntimeException(Exception e, HandlerMethod method) {
		// 不打印异常堆栈信息
		log.error("",e);
		if(Result.class.getName().equals(method.getMethod().getReturnType().getName())){
			Result<?> result = new Result<>();
			result.setSuccess(false);
			result.setMsg("系统错误，请联系管理员");
			return result;
		}else{
			ModelAndView mv = new ModelAndView();
			mv.setViewName("500");
			return mv;
		}
	}
}
