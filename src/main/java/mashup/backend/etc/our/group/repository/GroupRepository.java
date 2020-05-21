package mashup.backend.etc.our.group.repository;

import mashup.backend.etc.our.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g.groupId, g.name FROM Group g ORDER BY g.groupId DESC")
    List<Group> readGroupList();
}
