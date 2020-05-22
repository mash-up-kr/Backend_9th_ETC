package mashup.backend.etc.our.group.repository;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
import mashup.backend.etc.our.group.dto.ReqGroupListDto;
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
import mashup.backend.etc.our.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
<<<<<<< HEAD
    @Query("SELECT g.groupId, g.name FROM Group g ORDER BY g.groupId DESC")
    List<Group> readGroupList();
>>>>>>> df4cf72... [#9] Feat : Group 리스트 조회 기능 추가
=======
    @Query("SELECT g.groupId, g.name FROM Group g INNER JOIN UserGroup ug ON ug.userId=?1 AND ug.groupId=g.groupId")
    List<Group> readGroupList(Long userId);
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
}
