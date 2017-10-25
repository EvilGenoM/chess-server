package mobi.mpk.chessServerSpring.service;

import mobi.mpk.chessServerSpring.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

}
