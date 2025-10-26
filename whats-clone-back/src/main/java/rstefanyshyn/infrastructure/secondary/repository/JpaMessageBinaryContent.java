package rstefanyshyn.infrastructure.secondary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rstefanyshyn.infrastructure.secondary.entity.MessageContentBinaryEntity;

public interface JpaMessageBinaryContent extends JpaRepository<MessageContentBinaryEntity, Long> {
}