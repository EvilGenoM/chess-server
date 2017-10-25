package mobi.mpk.chessServerSpring.service;

import mobi.mpk.chessServerSpring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

}
