package rstefanyshyn.messaging.domain.user.vo;

import rstefanyshyn.shared.error.domain.Assert;

public record AuthorityName(String name) {

    public AuthorityName {
        Assert.field("name", name).notNull();
    }
}