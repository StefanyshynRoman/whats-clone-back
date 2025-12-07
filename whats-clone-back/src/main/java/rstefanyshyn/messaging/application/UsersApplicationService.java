package rstefanyshyn.messaging.application;

import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rstefanyshyn.messaging.domain.user.aggregate.User;
import rstefanyshyn.messaging.domain.user.repository.UserRepository;
import rstefanyshyn.messaging.domain.user.service.UserPresence;
import rstefanyshyn.messaging.domain.user.service.UserReader;
import rstefanyshyn.messaging.domain.user.service.UserSynchronizer;
import rstefanyshyn.messaging.domain.user.vo.UserEmail;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;
import rstefanyshyn.shared.authentication.application.AuthenticatedUser;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UsersApplicationService {

    private final UserSynchronizer userSynchronizer;
    private final UserReader userReader;
    private final UserPresence userPresence;

    public UsersApplicationService(UserRepository userRepository) {
        this.userSynchronizer = new UserSynchronizer(userRepository);
        this.userReader = new UserReader(userRepository);
        this.userPresence = new UserPresence(userRepository, userReader);
    }

    @Transactional
    public User getAuthenticatedUserWithSync(Jwt oauth2User, boolean forceResync) {
        userSynchronizer.syncWithIdp(oauth2User, forceResync);
        return userReader.getByEmail(new UserEmail(AuthenticatedUser.username().get()))
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    public User getAuthenticatedUser() {
        return userReader.getByEmail(new UserEmail(AuthenticatedUser.username().get()))
                .orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<User> search(Pageable pageable, String query) {
        return userReader.search(pageable, query).stream().toList();
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserByEmail(UserEmail userEmail) {
        return userReader.getByEmail(userEmail);
    }

    @Transactional
    public void updatePresence(UserPublicId userPublicId) {
        userPresence.updatePresence(userPublicId);
    }

    @Transactional(readOnly = true)
    public Optional<Instant> getLastSeen(UserPublicId userPublicId) {
        return userPresence.getLastSeenByPublicId(userPublicId);
    }
}