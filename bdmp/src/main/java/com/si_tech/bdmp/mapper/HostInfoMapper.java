package com.si_tech.bdmp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.si_tech.bdmp.entity.Hosts;
import com.si_tech.bdmp.ssh.MachineStats;

@Mapper
public interface HostInfoMapper {
     
	@Insert("insert into hostinfo values (null,#{ip},#{time},#{cpuUsage},#{load},#{traffic},#{memoryUsageRatio},#{memoryFree},#{memoryTotal},#{diskUsage}) ")
	void insertHostInfo(MachineStats machineStats);
	
    @Select("select * from hostlist")
	List<Hosts> getAllHost();
	
    @Select("select * from hostinfo where ip= #{ip}")
    List<MachineStats> getSingleHost(String ip);
    
	@Delete("delete h from hostinfo h WHERE h.id not in (select a.id from(select id from hostinfo ORDER BY id desc limit 500) a)")
	void deleteLimit();
	
}
