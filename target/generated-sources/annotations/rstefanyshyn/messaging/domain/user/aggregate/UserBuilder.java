package rstefanyshyn.messaging.domain.user.aggregate;

import java.lang.Long;
import java.time.Instant;
import java.util.Set;
import javax.annotation.processing.Generated;
import rstefanyshyn.messaging.domain.user.vo.UserEmail;
import rstefanyshyn.messaging.domain.user.vo.UserFirstname;
import rstefanyshyn.messaging.domain.user.vo.UserImageUrl;
import rstefanyshyn.messaging.domain.user.vo.UserLastName;
import rstefanyshyn.messaging.domain.user.vo.UserPublicId;

@Generated("Jilt-1.5")
public class UserBuilder {
  private UserLastName lastName;

  private UserFirstname firstname;

  private UserEmail email;

  private UserPublicId userPublicId;

  private UserImageUrl imageUrl;

  private Instant lastModifiedDate;

  private Instant createdDate;

  private Instant lastSeen;

  private Set<Authority> authorities;

  private Long dbId;

  public static UserBuilder user() {
    return new UserBuilder();
  }

  public UserBuilder lastName(UserLastName lastName) {
    this.lastName = lastName;
    return this;
  }

  public UserBuilder firstname(UserFirstname firstname) {
    this.firstname = firstname;
    return this;
  }

  public UserBuilder email(UserEmail email) {
    this.email = email;
    return this;
  }

  public UserBuilder userPublicId(UserPublicId userPublicId) {
    this.userPublicId = userPublicId;
    return this;
  }

  public UserBuilder imageUrl(UserImageUrl imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public UserBuilder lastModifiedDate(Instant lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
    return this;
  }

  public UserBuilder createdDate(Instant createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public UserBuilder lastSeen(Instant lastSeen) {
    this.lastSeen = lastSeen;
    return this;
  }

  public UserBuilder authorities(Set<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }

  public UserBuilder dbId(Long dbId) {
    this.dbId = dbId;
    return this;
  }

  public User build() {
    return new User(lastName, firstname, email, userPublicId, imageUrl, lastModifiedDate, createdDate, lastSeen, authorities, dbId);
  }
}
