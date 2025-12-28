package rstefanyshyn.messaging.domain.message.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rstefanyshyn.messaging.domain.message.aggregate.Conversation;
import rstefanyshyn.messaging.domain.message.repository.ConversationRepository;
import rstefanyshyn.messaging.domain.message.vo.ConversationPublicId;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;

import java.util.Optional;

public class ConversationReader {

    private final ConversationRepository conversationRepository;

    public ConversationReader(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Page<Conversation> getAllByUserPublicID(UserPublicId userPublicId, Pageable pageable) {
        return conversationRepository.getConversationByUserPublicId(userPublicId, pageable);
    }

    public Optional<Conversation> getOneByPublicId(ConversationPublicId conversationPublicId) {
        return conversationRepository.getOneByPublicId(conversationPublicId);
    }

    public Optional<Conversation> getOneByPublicIdAndUserId(ConversationPublicId conversationPublicId, UserPublicId userPublicId) {
        return conversationRepository.getConversationByUsersPublicIdAndPublicId(userPublicId, conversationPublicId);
    }
}