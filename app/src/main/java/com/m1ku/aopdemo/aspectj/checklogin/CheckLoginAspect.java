package com.m1ku.aopdemo.aspectj.checklogin;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class CheckLoginAspect {
    /**
     * 找到切点
     */
    @Pointcut("execution(@com.m1ku.aopdemo.aspectj.checklogin.CheckLogin * *(. .))")
    public void checkLoginPoint(){
    }

    /**
     * 处理切面
     * @param joinPoint
     * @throws Throwable
     */
    @Around("checkLoginPoint()")
    public void handleLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        CheckLogin checkLogin = signature.getMethod().getAnnotation(CheckLogin.class);
        if (checkLogin!=null){
            if (DataManager.getInstance().isLogin()){
                joinPoint.proceed();
            }else {
                Toast.makeText(getContext(joinPoint.getThis()),"请先登录",Toast.LENGTH_LONG).show();
            }
        }
        Log.e("m1ku","进入切点");
    }

    public Context getContext(Object object){
        if (object instanceof Activity){
            return (Context) object;
        }else if (object instanceof Fragment){
            return ((Fragment) object).getActivity();
        } else if (object instanceof View){
            return ((View) object).getContext();
        }else {
            return null;
        }
    }
}
