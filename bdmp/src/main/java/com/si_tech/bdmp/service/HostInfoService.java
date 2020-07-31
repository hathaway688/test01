package com.si_tech.bdmp.service;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.si_tech.bdmp.entity.Hosts;
import com.si_tech.bdmp.ssh.MachineStats;

public interface HostInfoService {
	public List<Hosts> getAllHost();
	public List<MachineStats> getSingleHost(String ip);
    public void insertHostInfo(MachineStats machineStats);
    public void deleteLimit();
    public void update(MachineStats machineStats);
}
