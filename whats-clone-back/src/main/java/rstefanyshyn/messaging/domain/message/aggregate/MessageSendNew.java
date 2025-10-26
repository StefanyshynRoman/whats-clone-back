package rstefanyshyn.messaging.domain.message.aggregate;

import org.jilt.Builder;
import rstefanyshyn.messaging.domain.message.vo.ConversationPublicId;
import rstefanyshyn.messaging.domain.message.vo.MessageContent;

@Builder
public record MessageSendNew(MessageContent messageContent,
                             ConversationPublicId conversationPublicId) {
}