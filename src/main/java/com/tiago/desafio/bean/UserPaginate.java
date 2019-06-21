package com.tiago.desafio.bean;

import com.tiago.desafio.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserPaginate implements Serializable {

    private int page;

    private int perPage;

    private int total;

    private int total_pages;

    private List<User> data = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
