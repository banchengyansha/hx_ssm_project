package cn.itcast.aop;

import cn.itcast.domain.OperateLog;
import cn.itcast.domain.User;
import cn.itcast.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class OperateLogAdvice {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogService operateLogService;

    //拦截controller 的方法, 并且方法中加有 @Log注解的方法
    @Around("execution(* cn.itcast.controller.*.*(..)) && @annotation(logAnno)")
    public Object around(ProceedingJoinPoint pjp , Log logAnno){

        log.info(" AOP 开始记录日志 ...");

        //记录日志的代码 , 需要捕获异常 , 记录日志出现问题, 不能影响正常的业务执行;
        OperateLog operateLog = null;
        try {
            operateLog = new OperateLog();
            operateLog.setOperateclass(pjp.getClass().getName());
            operateLog.setOperatemethod(pjp.getSignature().getName());
            operateLog.setOperatetime(new Date());

            Object user = request.getSession().getAttribute("loginUser");
            if(user != null){
                User u = (User) user;
                operateLog.setOperateuser(u.getId());
            }

            Object[] args = pjp.getArgs();
            operateLog.setParamvalue(Arrays.asList(args).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }



        Object value = null;
        try {

            long starttime = System.currentTimeMillis();
            value = pjp.proceed(); //放行
            long endtime = System.currentTimeMillis();
            operateLog.setOperatecost((endtime-starttime));

            operateLog.setReturnclass(value.getClass().getName());
            operateLog.setReturnvalue(value.toString());

        } catch (Throwable throwable) {
            throwable.printStackTrace();

            operateLog.setReturnclass(throwable.getClass().getName());
            operateLog.setReturnvalue(throwable.getMessage());
        }

        operateLogService.insert(operateLog); //记录日志到数据库

        log.info(" AOP 记录日志结束 ...");

        return value;
    }

}
