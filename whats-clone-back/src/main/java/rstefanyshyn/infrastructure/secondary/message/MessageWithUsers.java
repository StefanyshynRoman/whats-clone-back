package rstefanyshyn.infrastructure.secondary.message;

import rstefanyshyn.messaging.domain.message.aggregate.Message;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;

import java.util.List;

public record MessageWithUsers(Message message, List<UserPublicId> userToNotify) {
}