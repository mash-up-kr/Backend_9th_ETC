package mashup.backend.etc.our.diary.repository;

import mashup.backend.etc.our.diary.domain.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findByDiaryId(Long diaryId);
//    List<Diary> findByUserIdAndGroupId(Long userId, Long groupId);
}
