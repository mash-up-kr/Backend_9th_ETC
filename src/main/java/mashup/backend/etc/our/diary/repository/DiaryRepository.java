package mashup.backend.etc.our.diary.repository;

import mashup.backend.etc.our.diary.dto.ResDiaryDto;
import mashup.backend.etc.our.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query("SELECT new mashup.backend.etc.our.diary.dto.ResDiaryDto(d.diaryId, d.title, d.writerId, d.createTime,d.createTime) " +
            "FROM Diary d INNER JOIN UserGroup ug " +
            "ON ug.groupId=d.groupId WHERE ug.groupId=:groupId AND ug.userId=:userId")
    List<ResDiaryDto> findDiariesByGroupId(@Param("groupId") Long groupId, @Param("userId") Long userId);
}
