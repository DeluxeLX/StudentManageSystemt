package com.itlzh.controller;

import com.itlzh.pojo.SysLog;
import com.itlzh.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LopAop {

    @Autowired
    HttpServletRequest request;

    @Autowired
    ISysLogService sysLogService;

    private Date visitTime;  // 访问时间
    private Class clazz;     // 访问的类
    private Method method;   // 访问的方法

    // 主要获取访问时间、访问的类、访问的方法
    @Before("execution(* com.itlzh.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException {
        System.out.println("进入到前置通知...");
        visitTime = new Date();
        clazz = jp.getTarget().getClass();
        String methodName = jp.getSignature().getName();
        System.out.println(methodName);
        Object[] args = jp.getArgs();

        if (args==null || args.length==0) {
            method = clazz.getMethod(methodName);
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i=0; i< args.length; i++) {
                classArgs[i] = args[i].getClass();
                System.out.println(classArgs[i]);
            }
            //clazz.getMethod(methodName, classArgs);
        }
    }

    // 主要获取日志中其它信息，时长、ip、url...
    @After("execution(* com.itlzh.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        System.out.println("进入到后置通知...");
        long time = new Date().getTime() - visitTime.getTime();
        String url = "";

        if (clazz!=null && method!=null && clazz!=LopAop.class) {
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    String ip = request.getRemoteAddr();

                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]" + clazz.getName() + "[方法名]" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    sysLogService.save(sysLog);
                }
            }
        }
    }

}
