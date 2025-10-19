package rstefanyshyn.messaging.domain.user.vo;


import rstefanyshyn.shared.error.domain.Assert;

public record UserFirstname(String value) {

    public UserFirstname {
        Assert.field(value, value).maxLength(255);
    }
}