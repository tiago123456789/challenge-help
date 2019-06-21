package com.tiago.desafio.bo;

import com.tiago.desafio.bean.ResourcePaginate;
import com.tiago.desafio.model.Resource;
import com.tiago.desafio.repository.ResourceRepository;
import com.tiago.desafio.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceBO {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceService resourceService;

    public void registerDatasDatabase(int page) {
        List<Resource> resourcesPageMentioned = this.resourceRepository.findByPage(page);
        boolean existsRegisterResource = resourcesPageMentioned != null && resourcesPageMentioned.size() > 0;
        if (!existsRegisterResource) {
            ResourcePaginate paginateResource = this.resourceService.find(page);
            paginateResource.getData().forEach(resource -> {
                resource.setPage(page);
                this.resourceRepository.save(resource);
            });
        }
    }

    public List<Resource> findAll() {
        return this.resourceRepository.findAll();
    }
}
