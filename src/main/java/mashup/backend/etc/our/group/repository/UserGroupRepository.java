package mashup.backend.etc.our.group.repository;

import mashup.backend.etc.our.group.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository  extends JpaRepository<UserGroup, Long> {
    List<UserGroup> findAllByUserId(Long userId);
}
