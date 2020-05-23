package mashup.backend.etc.our.group.repository;

import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupRepository  extends JpaRepository<UserGroup, Long> {
}
