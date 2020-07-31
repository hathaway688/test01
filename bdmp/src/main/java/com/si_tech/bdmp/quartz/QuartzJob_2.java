package com.si_tech.bdmp.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.si_tech.bdmp.service.HostInfoService;

public class QuartzJob_2 extends QuartzJobBean{
	@Autowired
	HostInfoService hostinfoservice;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
	    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
	    String dataTime = dataMap.getString("dataTime");
	    System.out.println("dataTime : " + dataTime);
		hostinfoservice.deleteLimit();
		System.out.println("数据清除成功");
	}

}
