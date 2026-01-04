package rstefanyshyn.infrastructure.primary.conversation;

import org.jilt.Builder;
import rstefanyshyn.messaging.domain.message.aggregate.ConversationToCreate;
import rstefanyshyn.messaging.domain.message.aggregate.ConversationToCreateBuilder;
import rstefanyshyn.messaging.domain.message.vo.ConversationName;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
public record RestConversationToCreate(Set<UUID> members, String name) {

    public static ConversationToCreate toDomain(RestConversationToCreate restConversationToCreate) {
        rstefanyshyn.infrastructure.primary.conversation.RestConversationToCreateBuilder restConversationToCreateBuilder
                = rstefanyshyn.infrastructure.primary.conversation.RestConversationToCreateBuilder.restConversationToCreate();

        Set<UserPublicId> userUUIDs = restConversationToCreate.members
                .stream()
                .map(UserPublicId::new)
                .collect(Collectors.toSet());

        return ConversationToCreateBuilder.conversationToCreate()
                .name(new ConversationName(restConversationToCreate.name()))
                .members(userUUIDs)
                .build();
    }
}