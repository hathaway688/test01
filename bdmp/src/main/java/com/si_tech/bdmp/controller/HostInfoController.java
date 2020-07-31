package com.si_tech.bdmp.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.si_tech.bdmp.service.HostInfoService;
import com.si_tech.bdmp.ssh.MachineStats;

@Controller
@RequestMapping("/host")
public class HostInfoController {
    @Autowired
	HostInfoService hostinfoservice;
    
	@RequestMapping("/hostinfo")
	public String toHostInfo(Model model,HttpSession session,String ip) {
		model.addAttribute("hostinfo",hostinfoservice.getSingleHost(ip));
		session.setAttribute("hostip", ip);
		return "host_cluster/HostInfo";
	}
    
    @RequestMapping("toupdate")
    public String toupdate(Model model,HttpSession session,String ip) {
    	return "host_cluster/UpdateHostInfo";
    }
    
    @RequestMapping("update")
    public void update(HttpServletRequest request,Model model,HttpSession session,String ip) {
    	MachineStats machinestatus = null;
    	machinestatus.setIp(request.getParameter("ip"));
        machinestatus.setTime(request.getParameter("time"));
        machinestatus.setCpuUsage(request.getParameter("cpuUsage"));
        machinestatus.setLoad(request.getParameter("load"));
        machinestatus.setTraffic(request.getParameter("traffic"));
        machinestatus.setMemoryUsageRatio(request.getParameter("memoryUsageRatio"));
        machinestatus.setMemoryFree(request.getParameter("memoryFree"));
        machinestatus.setMemoryTotal(request.getParameter("memoryTotal"));
        machinestatus.setDiskUsage(request.getParameter("diskUsage"));
    	hostinfoservice.update(machinestatus);
    	
    }

}
