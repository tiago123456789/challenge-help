package com.tiago.desafio.services;

import com.tiago.desafio.bean.UserPaginate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class UserService extends AbstractReqresService<UserPaginate> {

    public UserPaginate find(int page) {
        return this.request("users?page=" + page, HttpMethod.GET, UserPaginate.class);
    }
}
