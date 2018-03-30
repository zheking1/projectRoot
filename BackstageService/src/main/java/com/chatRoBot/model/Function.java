package com.chatRoBot.model;

import java.util.Date;

/**
 * Created by Asus on 2018/3/20.
 */
public class Function {
    private String functionId;
    private String funCoding;
    private String funName;
    private String funType;
    private String funForUser;
    private String funDate;
    private String funUrl;
    private Date funState;
    private String attribute1;
    private String attribute2;
    private String attribute3;
    private String attribute4;
    private String attribute5;
    private Date creationDate;
    private String lastUpdateBy;
    private Date lastUpdateDate;
    private String lastUpdateId;
    private int version;

    public Function(String functionId, String funCoding, String funName, String funType, String funForUser, String funDate, String funUrl, Date funState, String attribute1, String attribute2, String attribute3, String attribute4, String attribute5, Date creationDate, String lastUpdateBy, Date lastUpdateDate, String lastUpdateId, int version) {
        this.functionId = functionId;
        this.funCoding = funCoding;
        this.funName = funName;
        this.funType = funType;
        this.funForUser = funForUser;
        this.funDate = funDate;
        this.funUrl = funUrl;
        this.funState = funState;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
        this.attribute5 = attribute5;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.lastUpdateId = lastUpdateId;
        this.version = version;
    }

    public Function() {
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getFunCoding() {
        return funCoding;
    }

    public void setFunCoding(String funCoding) {
        this.funCoding = funCoding;
    }

    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    public String getFunType() {
        return funType;
    }

    public void setFunType(String funType) {
        this.funType = funType;
    }

    public String getFunForUser() {
        return funForUser;
    }

    public void setFunForUser(String funForUser) {
        this.funForUser = funForUser;
    }

    public String getFunDate() {
        return funDate;
    }

    public void setFunDate(String funDate) {
        this.funDate = funDate;
    }

    public String getFunUrl() {
        return funUrl;
    }

    public void setFunUrl(String funUrl) {
        this.funUrl = funUrl;
    }

    public Date getFunState() {
        return funState;
    }

    public void setFunState(Date funState) {
        this.funState = funState;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
