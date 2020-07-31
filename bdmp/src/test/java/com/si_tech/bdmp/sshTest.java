package com.si_tech.bdmp;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.activation.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.si_tech.bdmp.ssh.MachineStats;
import com.si_tech.bdmp.ssh.SSHException;
import com.si_tech.bdmp.ssh.SSHUtil;
import com.si_tech.bdmp.SpringBootBdmpApplication;
import com.si_tech.bdmp.service.HostInfoService;

@SpringBootTest
public class sshTest {
	@Autowired
	DataSource dataSource;
	private Logger logger = LoggerFactory.getLogger(sshTest.class);	
    
	@Autowired
	HostInfoService hostinfoservice;
	@Autowired
    MachineStats machineStats;
    
	@Test
    public void testMachineStats() throws SSHException {
        String ip = "192.168.31.130";
        int port = 22;
        String userName = "e3base";
        String password = "e3base";
        MachineStats machineStats = SSHUtil.getMachineInfo(ip, port, userName, password);
        logger.info("ip {} machineStats: {}", machineStats);
    }
	
	@Test
    public void testCpu() {
        String redhat = "Cpu(s):  1.1%us,  0.5%sy,  0.0%ni, 98.4%id,  0.0%wa,  0.0%hi,  0.1%si,  0.0%st";
        String centos7 = "%Cpu(s):  0.11 us,  0.0 sy,  0.0 ni, 99.9 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st";
        String centos6 = "Cpu(s):  4.7%us, 16.0%sy,  0.0%ni, 67.0%id, 12.1%wa,  0.1%hi,  0.1%si,  0.0%st";
        
        assertTrue(SSHUtil.getUsCpu(redhat) == 1.1);
        assertTrue(SSHUtil.getUsCpu(centos7) == 0.11);
        assertTrue(SSHUtil.getUsCpu(centos6) == 4.7);
    }
	
	@Test
    public void testMymethod() {
        String ip = "192.168.31.130";
        int port = 22;
        String username = "e3base";
        String password = "e3base";
        String str = "";
        String command = "free";
    	try {
			 str =SSHUtil.execute(ip, port, username, password, command) ;
			 System.out.println("str========="+str);
		} catch (SSHException e) {
			e.printStackTrace();
		}
    }
	
//	@Test	
//	public void testScp() {
//    	 String ip = "192.168.31.130";
//         int port = 22;
//         String username = "e3base";
//         String password = "e3base";
//         String localPath = "C:\\Users\\Administrator\\Desktop\\scpTest.zip";
//         String remoteDir = "/data/resources/"; 
//    	 try {
//			SSHUtil.scpFileToRemote(ip, port, username, password, localPath, remoteDir);
//		} catch (SSHException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
	   
     @Test
     public void insertTest() throws SSHException{
    	 String ip = "192.168.31.130";
         int port = 22;
         String userName = "e3base";
         String password = "e3base";
    	 machineStats = SSHUtil.getMachineInfo(ip, port, userName, password);
		 machineStats.setDiskUsage(machineStats.getDiskUsageMap().get("/"));
         machineStats.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) );
         System.out.println(machineStats.toString());
         hostinfoservice.insertHostInfo(machineStats);
     }
	
     @Test
     public void gethost() {
     	System.out.println(hostinfoservice.getAllHost().get(0).getId()	);
     }
	
}
