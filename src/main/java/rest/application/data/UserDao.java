


package rest.application.data;



import java.util.List;
import rest.application.model.User;

public interface UserDao {
    public User findById(Long id);

    public User findByEmail(String email);

    public List<User> findAllOrderedByLogin();

    public void register(User user);
}
