package com.ft.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 夸系统事务运行操作,记录待发布事件
 *
 * @author liuyongtao
 * @create 2018-02-09 15:03
 */
@Entity
@Table(name = "sys_event_publish")
public class SysEventPublish {

    @Id
    private String id;
    //事件状态, 枚举类型. 现在只有两个状态: 待发布(NEW), 已发布(PUBLISHED)
    private String status;
    //发布事件的服务器ip
    private String ip;
    //发布事件的类名和处理方法名
    private String className;
    //事件类型
    private String eventType;
    //事件内容
    private String payload;
    //事件创建时候
    private Date createDate;
    //事件修改时间
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "SysEventPublish{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", ip='" + ip + '\'' +
                ", className='" + className + '\'' +
                ", eventType='" + eventType + '\'' +
                ", payload='" + payload + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
