package com.nt.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.ApplicationScopedBean;
import com.nt.dto.ProtoTypeBean;
import com.nt.dto.RequestScopedBean;
import com.nt.dto.SessionScopedBean;
import com.nt.dto.SingleTonBean;

@RestController
@RequestMapping("/api/scope")
public class BeanScopeController {


  @Autowired
  private SingleTonBean singleTonBean;

  @Autowired
  private ProtoTypeBean protoTypeBean;

  @Autowired
  private RequestScopedBean requestScopedBean;

  @Autowired
  private SessionScopedBean sessionScopedbean;

  @Autowired
  private ApplicationScopedBean applicationScopedBean;


  @RequestMapping(value = "/singleton", method = RequestMethod.GET)
  public String singleTonScope() {
    return "From Single Bean " + singleTonBean.getCount();
  }

  @RequestMapping(value = "/prototype", method = RequestMethod.GET)
  public String protoTypeBean() {
    int firstCount = protoTypeBean.getCount();
    int secondCount = protoTypeBean.getCount();
    return "First Count : " + firstCount + "Second Count : " + secondCount;
  }

  @RequestMapping(value = "/request", method = RequestMethod.GET)
  public String requestScope(HttpServletRequest httpServletRequest) {
    return "From Request Scope " + requestScopedBean.getCount() + "Hash Code " + httpServletRequest.hashCode();
  }

  @RequestMapping(value = "/session", method = RequestMethod.GET)
  public String sessionScope(HttpServletRequest httpServletRequest) {
    return "From Session Scope " + sessionScopedbean.getCount() + "Hash Code " + httpServletRequest.hashCode();
  }

  @RequestMapping(value = "/application", method = RequestMethod.GET)
  public String applicationScopedBean() {
    return "From Application Scope : " + applicationScopedBean.getCount();
  }


}
