package com.qzk.vo;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


public class ResultVO<T> {
    private PageInfo<T> pageInfo;//页面的数据需要的是分页数据
    private T obj;//页面的数据需要的单个对象
    private List<T> list;//页面的数据需要的集合
    private Integer code = 200;//状态码  200
    private String msg = "ok";//返回给用户的消息

    public ResultVO() {
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(PageInfo<T> pageInfo,List<T> list) {
        this.pageInfo = pageInfo;
        this.list = list;
    }

    public ResultVO(T obj) {
        this.obj = obj;
    }

    public ResultVO(List<T> list) {
        this.list = list;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
