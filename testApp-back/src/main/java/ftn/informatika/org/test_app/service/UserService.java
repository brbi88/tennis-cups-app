package ftn.informatika.org.test_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import ftn.informatika.org.test_app.model.User;
import ftn.informatika.org.test_app.web.dto.UserPasswordChangeDto;



public interface UserService {

    Optional<User> one(Long id);

    List<User> all();

    Page<User> all(int pageNo);

    User save(User user);

    void delete(Long id);

    Optional<User> findbyKorisnickoIme(String username);

	boolean changePassword(Long id, UserPasswordChangeDto userPasswordChangeDto);
}
