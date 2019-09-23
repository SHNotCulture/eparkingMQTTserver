package com.mqttserver.entity;

/**
 * @Author lishuhan
 * @Date Create in 15:022018-5-4
 * @Modified By:
 */
public class ActionRsp<T> {
    private String code;//0 访问成功
    private Object result;
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
