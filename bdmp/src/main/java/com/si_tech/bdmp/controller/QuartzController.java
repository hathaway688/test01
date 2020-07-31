package com.si_tech.bdmp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.si_tech.bdmp.service.HostInfoService;
import com.si_tech.bdmp.ssh.MachineStats;
import com.si_tech.bdmp.ssh.SSHException;
import com.si_tech.bdmp.ssh.SSHUtil;

public class QuartzController extends QuartzJobBean{
	JobExecutionContext jobExecutionContext;
	@Autowired
	HostInfoService hostinfoservice;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//System.out.println("    Hi! :"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) );
		//JobKey key = jobExecutionContext.getJobDetail().getKey();
	    //JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
	    //String strData = dataMap.getString("strData");
	    //int intData = dataMap.getInt("intData");
	    //System.out.println("key : " + key);
	    //System.out.println("strData : " + strData);
	    //System.out.println("intData : " + intData);
		String localtime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		MachineStats machinestats;
		String ip = "192.168.31.130";
        int port = 22;
        String userName = "e3base";
        String password = "e3base";
        MachineStats machineStats;
		try {
			machineStats = SSHUtil.getMachineInfo(ip, port, userName, password);
			machineStats.setDiskUsage(machineStats.getDiskUsageMap().get("/"));
            machineStats.setTime(localtime);
            System.out.println(machineStats.toString());
            hostinfoservice.insertHostInfo(machineStats);
		} catch (SSHException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

 
}
