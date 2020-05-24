package mashup.backend.etc.our.group.repository;

import mashup.backend.etc.our.group.dto.ReqGroupListDto;
import mashup.backend.etc.our.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT g.groupId, g.name FROM Group g INNER JOIN UserGroup ug ON ug.userId=?1 AND ug.groupId=g.groupId")
    List<Group> readGroupList(Long userId);
}
