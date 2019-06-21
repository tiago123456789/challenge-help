package com.tiago.desafio.services;

import com.tiago.desafio.bean.ResourcePaginate;
import com.tiago.desafio.model.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class ResourceService extends AbstractReqresService<ResourcePaginate> {

    public ResourcePaginate find(int page) {
        return this.request("unknown?page=" + page, HttpMethod.GET, ResourcePaginate.class);
    }
}
