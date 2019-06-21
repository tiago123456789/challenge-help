package com.tiago.desafio.bo;

import com.tiago.desafio.bean.ResourcePaginate;
import com.tiago.desafio.bean.UserPaginate;
import com.tiago.desafio.model.User;
import com.tiago.desafio.repository.UserRepository;
import com.tiago.desafio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserBO {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public void registerDatasDatabase(int page) {
        List<User> usersPageMentioned = this.userRepository.findByPage(page);
        boolean existsRegisterUsers = usersPageMentioned != null && usersPageMentioned.size() > 0;
        if (!existsRegisterUsers) {
            UserPaginate paginateUser = this.userService.find(page);
            paginateUser.getData().forEach(user -> {
                user.setPage(page);
                this.userRepository.save(user);
            });
        }
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
