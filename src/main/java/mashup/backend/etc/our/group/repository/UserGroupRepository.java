package mashup.backend.etc.our.group.repository;

import mashup.backend.etc.our.group.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserGroupRepository  extends JpaRepository<UserGroup, Long> {
    List<UserGroup> findAllByUserId(Long userId);

    Optional<UserGroup> findUserGroupByGroupIdAndUserId(Long groupId, Long userId);
}
