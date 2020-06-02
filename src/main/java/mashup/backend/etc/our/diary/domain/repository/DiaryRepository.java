package mashup.backend.etc.our.diary.domain.repository;

import mashup.backend.etc.our.diary.domain.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    Optional<Diary> findByDiaryId(Long diaryId);

    @Query("SELECT d FROM Diary d WHERE groupId=:groupId")
    List<Diary> findDiariesByGroupId(@Param("groupId") Long groupId);
}
