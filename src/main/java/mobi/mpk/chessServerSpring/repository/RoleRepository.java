package mobi.mpk.chessServerSpring.repository;

import mobi.mpk.chessServerSpring.model.Role;
import mobi.mpk.chessServerSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
