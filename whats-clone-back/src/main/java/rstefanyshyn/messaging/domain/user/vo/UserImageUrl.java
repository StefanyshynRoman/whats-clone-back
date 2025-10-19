package rstefanyshyn.messaging.domain.user.vo;

import rstefanyshyn.shared.error.domain.Assert;

public record UserImageUrl(String value) {

    public UserImageUrl {
        Assert.field(value, value).maxLength(255);
    }
}