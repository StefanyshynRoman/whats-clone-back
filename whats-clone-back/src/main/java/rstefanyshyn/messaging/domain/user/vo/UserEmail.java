package rstefanyshyn.messaging.domain.user.vo;

import rstefanyshyn.shared.error.domain.Assert;

public record UserEmail(String value) {

    public UserEmail {
        Assert.field(value, value).maxLength(255);
    }
}