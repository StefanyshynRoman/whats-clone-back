package rstefanyshyn.messaging.domain.message.service;

import rstefanyshyn.infrastructure.secondary.message.ConversationViewedForNotification;
import rstefanyshyn.messaging.domain.message.aggregate.Message;
import rstefanyshyn.messaging.domain.message.vo.ConversationPublicId;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;
import rstefanyshyn.shared.service.State;

import java.util.List;

public interface MessageChangeNotifier {

    State<Void, String> send(Message message, List<UserPublicId> userToNotify);

    State<Void, String> delete(ConversationPublicId conversationPublicId, List<UserPublicId> userToNotify);

    State<Void, String> view(ConversationViewedForNotification conversationViewedForNotification, List<UserPublicId> usersToNotify);
}