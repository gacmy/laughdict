package com.gac.laughdict.model.bean;

/**
 * Created by gacmy on 2017/8/3.
 */

public class ImageBean {
    private String content;
    private String hashId;
    private String unixtime;
    private String updatetime;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "TextBean{" +
                "content='" + content + '\'' +
                ", hashId='" + hashId + '\'' +
                ", unixtime='" + unixtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
