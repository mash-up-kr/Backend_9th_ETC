package mashup.backend.etc.our.group.repository;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import mashup.backend.etc.our.group.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository  extends JpaRepository<UserGroup, Long> {
    List<UserGroup> findAllByUserId(Long userId);
=======
=======
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
import mashup.backend.etc.our.group.entity.Group;
=======
>>>>>>> 7095dd2... [#9] Fix : Group 리스트 조회 API 수정
import mashup.backend.etc.our.group.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository  extends JpaRepository<UserGroup, Long> {
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 4ca5ea6... [#9] Feat : Group 리스트 조회 기능 추가
=======
>>>>>>> a8f6066... Group 리스트 조회 API (#14)
=======
    List<UserGroup> findAllByUserId(Long userId);
>>>>>>> 7095dd2... [#9] Fix : Group 리스트 조회 API 수정
}
