package rstefanyshyn.infrastructure.primary.conversation;
import org.jilt.Builder;
import rstefanyshyn.infrastructure.primary.message.RestMessage;
import rstefanyshyn.messaging.domain.message.aggregate.Conversation;

import java.util.List;
import java.util.UUID;

@Builder
public record RestConversation(UUID publicId, String name,
                               List<RestUserForConversation> members,
                               List<RestMessage> messages) {

    public static RestConversation from(Conversation conversation) {
        rstefanyshyn.infrastructure.primary.conversation.RestConversationBuilder restConversationBuilder
                = rstefanyshyn.infrastructure.primary.conversation.RestConversationBuilder.restConversation()
                .name(conversation.getConversationName().name())
                .publicId(conversation.getConversationPublicId().value())
                .members(RestUserForConversation.from(conversation.getMembers()));

        if (conversation.getMessages() != null) {
            restConversationBuilder.messages(RestMessage.from(conversation.getMessages()));
        }

        return restConversationBuilder.build();
    }

}