package com.zhulin.common.file;

public class FileSaveResult {
    private String originFileName;
    private String distFileName;
    private String storePath;

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getDistFileName() {
        return distFileName;
    }

    public void setDistFileName(String distFileName) {
        this.distFileName = distFileName;
    }

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }
}
