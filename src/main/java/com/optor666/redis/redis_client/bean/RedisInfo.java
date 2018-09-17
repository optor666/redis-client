package com.optor666.redis.redis_client.bean;

/**
 * Created by optor666 on 2018/7/3.
 */
public class RedisInfo {

    private static final String[] units = new String[]{"G", "M", "K", "B"};

    private static final double[] unitValues = new double[]{Math.pow(1024, 3), Math.pow(1024, 2), 1024};

    private String redisVersion;

    private String redisRelease;

    private String redisGitSha1;

    private String redisGitDirty;

    private String archBits;

    private String multiplexingApi;

    private String gccVersion;

    private int processId;

    private int uptimeInSeconds;

    private int uptimeInDays;

    private int lruClock;

    /**
     * Redis 服务器耗费的系统 CPU
     */
    private double usedCpuSys;

    /**
     * Redis 服务器耗费的用户 CPU
     */
    private double usedCpuUser;

    /**
     * 后台进程耗费的系统 CPU
     */
    private double usedCpuSysChildren;

    /**
     * 后台进程耗费的用户 CPU
     */
    private double usedCpuUserChildren;

    private int connectedClients;

    private int connectedSlaves;

    private int clientLongestOutputList;

    private int clientBiggestInputBuf;

    private int blockedClients;

    /**
     * 在理想情况下， used_memory_rss 的值应该只比 used_memory 稍微高一点儿。
     * 当 rss > used ，且两者的值相差较大时，表示存在（内部或外部的）内存碎片。
     * 内存碎片的比率可以通过 mem_fragmentation_ratio 的值看出。
     * 当 used > rss 时，表示 Redis 的部分内存被操作系统换出到交换空间了，在这种情况下，操作可能会产生明显的延迟。
     */

    /**
     * 由 Redis 分配器分配的内存总量，以字节（byte）为单位
     */
    private long usedMemory;

    private String usedMemoryHuman;

    /**
     * 从操作系统的角度，返回 Redis 已分配的内存总量（俗称常驻集大小）。这个值和 top 、 ps 等命令的输出一致。
     */
    private long usedMemoryRss;

    private String usedMemoryRssHuman;

    /**
     * Redis 的内存消耗峰值（以字节为单位）
     */
    private long usedMemoryPeak;

    private String usedMemoryPeakHuman;

    /**
     * used_memory_rss 和 used_memory 之间的比率
     */
    private double memFragmentationRatio;

    private String memAllocator;

    private int loading;

    private int aofEnabled;

    private int pendingAofbufLength;

    private int changesSinceLastSave;

    private int bgsaveInProgress;

    private int lastSaveTime;

    private int lastSaveUsedSecond;

    private int lastSaveSpeed;

    private int bgrewriteaofInProgress;

    private long totalConnectionsReceived;

    private long totalCommandsProcessed;

    private long totalReadRequests;

    private long totalWriteRequests;

    private int totalSlowQueries;

    private int expiredKeys;

    private int evictedKeys;

    private long keyspaceHits;

    private long keyspaceMisses;

    private int pubsubChannels;

    private int pubsubPatterns;

    private int latestForkUsec;

    private int vmEnabled;

    private String role;

    private String upgradeStat;

    private int aofCurrentFileid;

    private int aofCurrentSize;

    private int aofPendingRewrite;

    private int aofBufferLength;

    private int delaySeconds;

    private String masterHost;

    private int masterPort;

    private String masterLinkStatus;

    private int masterLastIoSecondsAgo;

    private int masterSyncInProgress;

    private int masterLastTmSecondsAgo;

    private int dbTotalKeys;

    private int dbTotalExpireds;

    public String getRedisVersion() {
        return redisVersion;
    }

    public void setRedisVersion(String redisVersion) {
        this.redisVersion = redisVersion;
    }

    public String getRedisRelease() {
        return redisRelease;
    }

    public void setRedisRelease(String redisRelease) {
        this.redisRelease = redisRelease;
    }

    public String getRedisGitSha1() {
        return redisGitSha1;
    }

    public void setRedisGitSha1(String redisGitSha1) {
        this.redisGitSha1 = redisGitSha1;
    }

    public String getRedisGitDirty() {
        return redisGitDirty;
    }

    public void setRedisGitDirty(String redisGitDirty) {
        this.redisGitDirty = redisGitDirty;
    }

    public String getArchBits() {
        return archBits;
    }

    public void setArchBits(String archBits) {
        this.archBits = archBits;
    }

    public String getMultiplexingApi() {
        return multiplexingApi;
    }

    public void setMultiplexingApi(String multiplexingApi) {
        this.multiplexingApi = multiplexingApi;
    }

    public String getGccVersion() {
        return gccVersion;
    }

    public void setGccVersion(String gccVersion) {
        this.gccVersion = gccVersion;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getUptimeInSeconds() {
        return uptimeInSeconds;
    }

    public void setUptimeInSeconds(int uptimeInSeconds) {
        this.uptimeInSeconds = uptimeInSeconds;
    }

    public int getUptimeInDays() {
        return uptimeInDays;
    }

    public void setUptimeInDays(int uptimeInDays) {
        this.uptimeInDays = uptimeInDays;
    }

    public int getLruClock() {
        return lruClock;
    }

    public void setLruClock(int lruClock) {
        this.lruClock = lruClock;
    }

    public double getUsedCpuSys() {
        return usedCpuSys;
    }

    public void setUsedCpuSys(double usedCpuSys) {
        this.usedCpuSys = usedCpuSys;
    }

    public double getUsedCpuUser() {
        return usedCpuUser;
    }

    public void setUsedCpuUser(double usedCpuUser) {
        this.usedCpuUser = usedCpuUser;
    }

    public double getUsedCpuSysChildren() {
        return usedCpuSysChildren;
    }

    public void setUsedCpuSysChildren(double usedCpuSysChildren) {
        this.usedCpuSysChildren = usedCpuSysChildren;
    }

    public double getUsedCpuUserChildren() {
        return usedCpuUserChildren;
    }

    public void setUsedCpuUserChildren(double usedCpuUserChildren) {
        this.usedCpuUserChildren = usedCpuUserChildren;
    }

    public int getConnectedClients() {
        return connectedClients;
    }

    public void setConnectedClients(int connectedClients) {
        this.connectedClients = connectedClients;
    }

    public int getConnectedSlaves() {
        return connectedSlaves;
    }

    public void setConnectedSlaves(int connectedSlaves) {
        this.connectedSlaves = connectedSlaves;
    }

    public int getClientLongestOutputList() {
        return clientLongestOutputList;
    }

    public void setClientLongestOutputList(int clientLongestOutputList) {
        this.clientLongestOutputList = clientLongestOutputList;
    }

    public int getClientBiggestInputBuf() {
        return clientBiggestInputBuf;
    }

    public void setClientBiggestInputBuf(int clientBiggestInputBuf) {
        this.clientBiggestInputBuf = clientBiggestInputBuf;
    }

    public int getBlockedClients() {
        return blockedClients;
    }

    public void setBlockedClients(int blockedClients) {
        this.blockedClients = blockedClients;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getUsedMemoryHuman() {
        return usedMemoryHuman;
    }

    public void setUsedMemoryHuman(String usedMemoryHuman) {
        this.usedMemoryHuman = usedMemoryHuman;
    }

    public long getUsedMemoryRss() {
        return usedMemoryRss;
    }

    public void setUsedMemoryRss(long usedMemoryRss) {
        this.usedMemoryRss = usedMemoryRss;
        int i;
        for (i = 0; i < unitValues.length; i++) {
            if (usedMemoryRss > unitValues[i]) {
                this.usedMemoryRssHuman = Math.round(usedMemoryRss / unitValues[i] * 100) / 100d + units[i];
                return;
            }
        }
        this.usedMemoryRssHuman = usedMemoryHuman + units[i];
    }

    public long getUsedMemoryPeak() {
        return usedMemoryPeak;
    }

    public void setUsedMemoryPeak(long usedMemoryPeak) {
        this.usedMemoryPeak = usedMemoryPeak;
    }

    public String getUsedMemoryPeakHuman() {
        return usedMemoryPeakHuman;
    }

    public void setUsedMemoryPeakHuman(String usedMemoryPeakHuman) {
        this.usedMemoryPeakHuman = usedMemoryPeakHuman;
    }

    public double getMemFragmentationRatio() {
        return memFragmentationRatio;
    }

    public void setMemFragmentationRatio(double memFragmentationRatio) {
        this.memFragmentationRatio = memFragmentationRatio;
    }

    public String getMemAllocator() {
        return memAllocator;
    }

    public void setMemAllocator(String memAllocator) {
        this.memAllocator = memAllocator;
    }

    public int getLoading() {
        return loading;
    }

    public void setLoading(int loading) {
        this.loading = loading;
    }

    public int getAofEnabled() {
        return aofEnabled;
    }

    public void setAofEnabled(int aofEnabled) {
        this.aofEnabled = aofEnabled;
    }

    public int getPendingAofbufLength() {
        return pendingAofbufLength;
    }

    public void setPendingAofbufLength(int pendingAofbufLength) {
        this.pendingAofbufLength = pendingAofbufLength;
    }

    public int getChangesSinceLastSave() {
        return changesSinceLastSave;
    }

    public void setChangesSinceLastSave(int changesSinceLastSave) {
        this.changesSinceLastSave = changesSinceLastSave;
    }

    public int getBgsaveInProgress() {
        return bgsaveInProgress;
    }

    public void setBgsaveInProgress(int bgsaveInProgress) {
        this.bgsaveInProgress = bgsaveInProgress;
    }

    public int getLastSaveTime() {
        return lastSaveTime;
    }

    public void setLastSaveTime(int lastSaveTime) {
        this.lastSaveTime = lastSaveTime;
    }

    public int getLastSaveUsedSecond() {
        return lastSaveUsedSecond;
    }

    public void setLastSaveUsedSecond(int lastSaveUsedSecond) {
        this.lastSaveUsedSecond = lastSaveUsedSecond;
    }

    public int getLastSaveSpeed() {
        return lastSaveSpeed;
    }

    public void setLastSaveSpeed(int lastSaveSpeed) {
        this.lastSaveSpeed = lastSaveSpeed;
    }

    public int getBgrewriteaofInProgress() {
        return bgrewriteaofInProgress;
    }

    public void setBgrewriteaofInProgress(int bgrewriteaofInProgress) {
        this.bgrewriteaofInProgress = bgrewriteaofInProgress;
    }

    public long getTotalConnectionsReceived() {
        return totalConnectionsReceived;
    }

    public void setTotalConnectionsReceived(long totalConnectionsReceived) {
        this.totalConnectionsReceived = totalConnectionsReceived;
    }

    public long getTotalCommandsProcessed() {
        return totalCommandsProcessed;
    }

    public void setTotalCommandsProcessed(long totalCommandsProcessed) {
        this.totalCommandsProcessed = totalCommandsProcessed;
    }

    public long getTotalReadRequests() {
        return totalReadRequests;
    }

    public void setTotalReadRequests(long totalReadRequests) {
        this.totalReadRequests = totalReadRequests;
    }

    public long getTotalWriteRequests() {
        return totalWriteRequests;
    }

    public void setTotalWriteRequests(long totalWriteRequests) {
        this.totalWriteRequests = totalWriteRequests;
    }

    public int getTotalSlowQueries() {
        return totalSlowQueries;
    }

    public void setTotalSlowQueries(int totalSlowQueries) {
        this.totalSlowQueries = totalSlowQueries;
    }

    public int getExpiredKeys() {
        return expiredKeys;
    }

    public void setExpiredKeys(int expiredKeys) {
        this.expiredKeys = expiredKeys;
    }

    public int getEvictedKeys() {
        return evictedKeys;
    }

    public void setEvictedKeys(int evictedKeys) {
        this.evictedKeys = evictedKeys;
    }

    public long getKeyspaceHits() {
        return keyspaceHits;
    }

    public void setKeyspaceHits(long keyspaceHits) {
        this.keyspaceHits = keyspaceHits;
    }

    public long getKeyspaceMisses() {
        return keyspaceMisses;
    }

    public void setKeyspaceMisses(long keyspaceMisses) {
        this.keyspaceMisses = keyspaceMisses;
    }

    public int getPubsubChannels() {
        return pubsubChannels;
    }

    public void setPubsubChannels(int pubsubChannels) {
        this.pubsubChannels = pubsubChannels;
    }

    public int getPubsubPatterns() {
        return pubsubPatterns;
    }

    public void setPubsubPatterns(int pubsubPatterns) {
        this.pubsubPatterns = pubsubPatterns;
    }

    public int getLatestForkUsec() {
        return latestForkUsec;
    }

    public void setLatestForkUsec(int latestForkUsec) {
        this.latestForkUsec = latestForkUsec;
    }

    public int getVmEnabled() {
        return vmEnabled;
    }

    public void setVmEnabled(int vmEnabled) {
        this.vmEnabled = vmEnabled;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUpgradeStat() {
        return upgradeStat;
    }

    public void setUpgradeStat(String upgradeStat) {
        this.upgradeStat = upgradeStat;
    }

    public int getAofCurrentFileid() {
        return aofCurrentFileid;
    }

    public void setAofCurrentFileid(int aofCurrentFileid) {
        this.aofCurrentFileid = aofCurrentFileid;
    }

    public int getAofCurrentSize() {
        return aofCurrentSize;
    }

    public void setAofCurrentSize(int aofCurrentSize) {
        this.aofCurrentSize = aofCurrentSize;
    }

    public int getAofPendingRewrite() {
        return aofPendingRewrite;
    }

    public void setAofPendingRewrite(int aofPendingRewrite) {
        this.aofPendingRewrite = aofPendingRewrite;
    }

    public int getAofBufferLength() {
        return aofBufferLength;
    }

    public void setAofBufferLength(int aofBufferLength) {
        this.aofBufferLength = aofBufferLength;
    }

    public int getDelaySeconds() {
        return delaySeconds;
    }

    public void setDelaySeconds(int delaySeconds) {
        this.delaySeconds = delaySeconds;
    }

    public String getMasterHost() {
        return masterHost;
    }

    public void setMasterHost(String masterHost) {
        this.masterHost = masterHost;
    }

    public int getMasterPort() {
        return masterPort;
    }

    public void setMasterPort(int masterPort) {
        this.masterPort = masterPort;
    }

    public String getMasterLinkStatus() {
        return masterLinkStatus;
    }

    public void setMasterLinkStatus(String masterLinkStatus) {
        this.masterLinkStatus = masterLinkStatus;
    }

    public int getMasterLastIoSecondsAgo() {
        return masterLastIoSecondsAgo;
    }

    public void setMasterLastIoSecondsAgo(int masterLastIoSecondsAgo) {
        this.masterLastIoSecondsAgo = masterLastIoSecondsAgo;
    }

    public int getMasterSyncInProgress() {
        return masterSyncInProgress;
    }

    public void setMasterSyncInProgress(int masterSyncInProgress) {
        this.masterSyncInProgress = masterSyncInProgress;
    }

    public int getMasterLastTmSecondsAgo() {
        return masterLastTmSecondsAgo;
    }

    public void setMasterLastTmSecondsAgo(int masterLastTmSecondsAgo) {
        this.masterLastTmSecondsAgo = masterLastTmSecondsAgo;
    }

    public int getDbTotalKeys() {
        return dbTotalKeys;
    }

    public void setDbTotalKeys(int dbTotalKeys) {
        this.dbTotalKeys = dbTotalKeys;
    }

    public int getDbTotalExpireds() {
        return dbTotalExpireds;
    }

    public void setDbTotalExpireds(int dbTotalExpireds) {
        this.dbTotalExpireds = dbTotalExpireds;
    }

    public String getUsedMemoryRssHuman() {
        return usedMemoryRssHuman;
    }


    @Override
    public String toString() {
        return "{usedCpuSys: " + usedCpuSys
                + ", usedCpuUser: " + usedCpuUser
                + ", usedCpuSysChildren: " + usedCpuSysChildren
                + ", usedCpuUserChildren: " + usedCpuUserChildren
                + ", usedMemoryHuman: " + usedMemoryHuman
                + ", usedMemoryRssHuman: " + usedMemoryRssHuman
                + ", usedMemoryPeakHuman: " + usedMemoryPeakHuman
                + ", memFragmentationRatio: " + memFragmentationRatio
                ;
    }
}
