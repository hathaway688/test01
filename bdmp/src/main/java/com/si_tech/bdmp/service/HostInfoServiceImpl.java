package com.si_tech.bdmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si_tech.bdmp.entity.Hosts;
import com.si_tech.bdmp.mapper.HostInfoMapper;
import com.si_tech.bdmp.ssh.MachineStats;

@Service
public class HostInfoServiceImpl implements HostInfoService{
	@Autowired
	HostInfoMapper hostinfomapper;
	
	@Override
	public void insertHostInfo(MachineStats machineStats) {
		hostinfomapper.insertHostInfo(machineStats);
	}

	@Override
	public List<Hosts> getAllHost() {
	   return hostinfomapper.getAllHost();
	}
    
	@Override
	public List<MachineStats> getSingleHost(String ip) {	
		return hostinfomapper.getSingleHost(ip);
	}
	
	@Override
	public void deleteLimit() {
		hostinfomapper.deleteLimit();
	}

	@Override
	public void update(MachineStats machineStats) {
        
		
	}
}
