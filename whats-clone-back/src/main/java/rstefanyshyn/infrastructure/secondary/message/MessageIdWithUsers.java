package rstefanyshyn.infrastructure.secondary.message;


import rstefanyshyn.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public record MessageIdWithUsers(ConversationViewedForNotification conversationViewedForNotification,
                                 List<UserPublicId> usersToNotify) {
}