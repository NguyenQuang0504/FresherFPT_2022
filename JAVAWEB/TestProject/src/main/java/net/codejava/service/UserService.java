package net.codejava.service;

import net.codejava.model.User;
import net.codejava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.update(user.getId(), user.getUserName(), user.getPassword());
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(int id){
        return userRepository.getById(id);
    }

    public List<User> search(String keyword) {
        return userRepository.search(keyword);
    }

    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
