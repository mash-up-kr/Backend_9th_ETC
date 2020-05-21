package mashup.backend.etc.our.group.repository;

<<<<<<< HEAD
<<<<<<< HEAD
import mashup.backend.etc.our.group.dto.ResGroupDto;
import mashup.backend.etc.our.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Query("SELECT new mashup.backend.etc.our.group.dto.ResGroupDto(g.groupId, g.name) " +
            "FROM Group g INNER JOIN UserGroup ug " +
            "ON ug.groupId=g.groupId WHERE ug.userId=:userId")
    List<ResGroupDto> findGroupsByUserId(@Param("userId") Long userId);
=======
public interface GroupRepository {
>>>>>>> 02a07f3... [#6] Chore : 패키지 구조 설계
=======
public interface GroupRepository {
>>>>>>> 01d2806... [#6] Chore : 패키지 구조 설계 (#13)
}
