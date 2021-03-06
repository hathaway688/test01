package com.si_tech.bdmp.ssh;

import java.util.Date;
import java.util.Map;

/**
 * 
 * <p>Title: MachineStats</p>
 * <p>Description: 主机指标</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: 思特奇 </p>
 * @author heweia
 * @version 1.0
 * @createtime 2019-4-9 上午9:12:11
 *
 */
public class MachineStats {
    private long id;

    private long hostId;

    private String ip;

    private String cpuUsage;

    private String load;

    private String traffic;

    private String memoryUsageRatio;

    private String memoryFree;

    private int memoryAllocated;

    private String memoryTotal;

    //private MachineInfo info;

    //private MachineMemInfo machineMemInfo;

    private Map<String/**挂载点*/, String/**使用百分比*/> diskUsageMap;

    private String diskUsage;
    /**
     * 创建时间
     */
    //private Date createTime;

    /**
     * 修改时间
     */
    //private Date modifyTime;

    private String time;
    
     
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMemoryUsageRatio() {
        return memoryUsageRatio;
    }

    /**
     * 这里将会返回 30%
     */
    public String getCpuUsage() {
        return cpuUsage;
    }

    /**
     * 按这样的格式赋值 30%
     */
    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public void setMemoryUsageRatio(String memoryUsageRatio) {
        this.memoryUsageRatio = memoryUsageRatio;
    }

    public Map<String, String> getDiskUsageMap() {
        return diskUsageMap;
    }

    public void setDiskUsageMap(Map<String, String> diskUsageMap) {
        this.diskUsageMap = diskUsageMap;
    }

    public String getMemoryTotal() {
        return memoryTotal;
    }

    public String getMemoryFree() {
        return memoryFree;
    }

    public void setMemoryFree(String memoryFree) {
        this.memoryFree = memoryFree;
    }

    public void setMemoryTotal(String memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

/*    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }*/

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public int getMemoryAllocated() {
        return memoryAllocated;
    }

    public void setMemoryAllocated(int memoryAllocated) {
        this.memoryAllocated = memoryAllocated;
    }

/*    public MachineInfo getInfo() {
        return info;
    }

    public void setInfo(MachineInfo info) {
        this.info = info;
    }

    public MachineMemInfo getMachineMemInfo() {
        return machineMemInfo;
    }

    public void setMachineMemInfo(MachineMemInfo machineMemInfo) {
        this.machineMemInfo = machineMemInfo;
    }*/
    
    public String getDiskUsage() {
		return diskUsage;
	}

	public void setDiskUsage(String diskUsage) {
		this.diskUsage = diskUsage;
	}



	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "MachineStats [id=" + id + ", hostId=" + hostId + ", ip=" + ip + ", cpuUsage=" + cpuUsage + ", load="
				+ load + ", traffic=" + traffic + ", memoryUsageRatio=" + memoryUsageRatio + ", memoryFree="
				+ memoryFree + ", memoryAllocated=" + memoryAllocated + ", memoryTotal=" + memoryTotal
				+ ", diskUsageMap=" + diskUsageMap + ", diskUsage=" + diskUsage + ", time=" + time + "]";
	}




}
