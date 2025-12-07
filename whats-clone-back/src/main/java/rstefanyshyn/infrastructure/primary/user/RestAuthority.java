package rstefanyshyn.infrastructure.primary.user;
import org.jilt.Builder;
import rstefanyshyn.messaging.domain.user.aggregate.Authority;

import java.util.Set;
import java.util.stream.Collectors;

@Builder
public record RestAuthority(String name) {

    public static Set<RestAuthority> fromSet(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority ->
                        rstefanyshyn.infrastructure.primary.user.RestAuthorityBuilder.restAuthority()
                                .name(authority.getName().name()).build())
                .collect(Collectors.toSet());
    }

}