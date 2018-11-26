package it.chen.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionSlover implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException)e;
        }else {
            ex = new SysException("系统正在维护...");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",ex.getMessage());
        mv.setViewName("message");
        return mv;
    }
}
