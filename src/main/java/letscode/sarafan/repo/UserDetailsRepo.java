package letscode.sarafan.repo;

import letscode.sarafan.domain.Message;
import letscode.sarafan.domain.User;
import letscode.sarafan.domain.UserSubscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<User, String> {
    /**
     * два поля, которые мы хотим жадно подгружать - "subscriptions", "subscribers"
     * @param aLong
     * @return
     */
    @EntityGraph(attributePaths = {"subscriptions", "subscribers"})
    Optional<User> findById(String aLong);

}
