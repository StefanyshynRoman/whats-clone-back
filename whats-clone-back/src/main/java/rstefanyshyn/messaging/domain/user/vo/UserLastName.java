package rstefanyshyn.messaging.domain.user.vo;

import rstefanyshyn.shared.error.domain.Assert;

public record UserLastName(String value) {

    public UserLastName {
        Assert.field(value, value).maxLength(255);
    }
}