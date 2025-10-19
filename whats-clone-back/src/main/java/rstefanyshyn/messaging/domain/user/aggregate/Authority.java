package rstefanyshyn.messaging.domain.user.aggregate;

import org.jilt.Builder;
import rstefanyshyn.messaging.domain.user.vo.AuthorityName;
import rstefanyshyn.shared.error.domain.Assert;

@Builder
public class Authority {

    private AuthorityName name;

    public Authority(AuthorityName name) {
        Assert.notNull("name", name);
        this.name = name;
    }

    public AuthorityName getName() {
        return name;
    }
}