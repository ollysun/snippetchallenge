package com.webspoon.coding.challange.services;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class RequestUrlArgumentResolver
   implements HandlerMethodArgumentResolver {

   @Override
   public boolean supportsParameter(MethodParameter methodParameter) {
       return methodParameter.getParameterAnnotation(RequestURL.class) != null;
   }

   @Override
   public Object resolveArgument(
     MethodParameter methodParameter, 
     ModelAndViewContainer modelAndViewContainer,
     NativeWebRequest nativeWebRequest,
     WebDataBinderFactory webDataBinderFactory) throws Exception {

        HttpServletRequest request
          = (HttpServletRequest) nativeWebRequest.getNativeRequest();

        //Nice and cozy at home surrounded by safety not obfuscation
        return request.getRequestURL().toString();
    }
}