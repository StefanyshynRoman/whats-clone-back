package rstefanyshyn.messaging.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rstefanyshyn.messaging.domain.message.aggregate.Message;
import rstefanyshyn.messaging.domain.message.aggregate.MessageSendNew;
import rstefanyshyn.messaging.domain.message.repository.ConversationRepository;
import rstefanyshyn.messaging.domain.message.repository.MessageRepository;
import rstefanyshyn.messaging.domain.message.service.ConversationReader;
import rstefanyshyn.messaging.domain.message.service.MessageChangeNotifier;
import rstefanyshyn.messaging.domain.message.service.MessageCreator;
import rstefanyshyn.messaging.domain.user.aggregate.User;
import rstefanyshyn.messaging.domain.user.repository.UserRepository;
import rstefanyshyn.messaging.domain.user.service.UserReader;
import rstefanyshyn.messaging.domain.user.vo.UserEmail;
import rstefanyshyn.shared.authentication.application.AuthenticatedUser;
import rstefanyshyn.shared.service.State;

import java.util.Optional;

@Service
public class MessageApplicationService {

    private final MessageCreator messageCreator;
    private final UserReader userReader;

    public MessageApplicationService(MessageRepository messageRepository, UserRepository userRepository,
                                     ConversationRepository conversationRepository, MessageChangeNotifier messageChangeNotifier) {
        ConversationReader conversationReader = new ConversationReader(conversationRepository);
        this.messageCreator = new MessageCreator(messageRepository, messageChangeNotifier, conversationReader);
        this.userReader = new UserReader(userRepository);
    }

    @Transactional
    public State<Message, String> send(MessageSendNew messageSendNew) {
        State<Message, String> creationState;
        Optional<User> connectedUser = this.userReader.getByEmail(new UserEmail(AuthenticatedUser.username().username()));
        if(connectedUser.isPresent()) {
            creationState = this.messageCreator.create(messageSendNew, connectedUser.get());
        } else {
            creationState = State.<Message, String>builder()
                    .forError(String.format("Error retrieving user information inside the DB : %s", AuthenticatedUser.username().username()));
        }
        return creationState;
    }
}