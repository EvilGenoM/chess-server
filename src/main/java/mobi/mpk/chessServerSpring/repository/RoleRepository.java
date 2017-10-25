package mobi.mpk.chessServerSpring.repository;

import mobi.mpk.chessServerSpring.model.Role;
import mobi.mpk.chessServerSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
