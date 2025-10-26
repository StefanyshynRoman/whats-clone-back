package rstefanyshyn.messaging.domain.message.repository;

import rstefanyshyn.messaging.domain.message.aggregate.Conversation;
import rstefanyshyn.messaging.domain.message.aggregate.Message;
import rstefanyshyn.messaging.domain.message.vo.ConversationPublicId;
import rstefanyshyn.messaging.domain.message.vo.MessageSendState;
import rstefanyshyn.messaging.domain.user.aggregate.User;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public interface MessageRepository {

    Message save(Message message, User sender, Conversation conversation);

    int updateMessageSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId, MessageSendState state);

    List<Message> findMessageToUpdateSendState(ConversationPublicId conversationPublicId, UserPublicId userPublicId);

}