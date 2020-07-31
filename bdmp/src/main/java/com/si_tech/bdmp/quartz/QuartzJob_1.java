package com.si_tech.bdmp.quartz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.activation.DataSource;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.si_tech.bdmp.service.HostInfoService;
import com.si_tech.bdmp.ssh.MachineStats;
import com.si_tech.bdmp.ssh.SSHException;
import com.si_tech.bdmp.ssh.SSHUtil;


public class QuartzJob_1 extends QuartzJobBean{
	JobExecutionContext jobExecutionContext;
	private Logger logger = LoggerFactory.getLogger(QuartzJob_1.class);
	@Autowired
	HostInfoService hostinfoservice;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		String localtime=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String ip = "47.96.143.152";
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