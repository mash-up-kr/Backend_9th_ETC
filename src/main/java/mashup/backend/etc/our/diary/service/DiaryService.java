package mashup.backend.etc.our.diary.service;

import mashup.backend.etc.our.diary.dto.*;
import mashup.backend.etc.our.diary.entity.Diary;
import mashup.backend.etc.our.diary.repository.DiaryRepository;
import mashup.backend.etc.our.user.entity.User;
import mashup.backend.etc.our.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    public DiaryService(DiaryRepository diaryRepository, UserRepository userRepository) {
        this.diaryRepository = diaryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ResDiaryDto create(ReqPostDiaryDto requestDto){
        String writerName = getWriterName(requestDto.getUserId());
        Long diaryId = diaryRepository.save(requestDto.toEntity()).getDiaryId();
        Diary diary = diaryRepository.findByDiaryId(diaryId)
                .orElseThrow(()-> new IllegalArgumentException("저장되지 않았습니다."));
        return new ResDiaryDto(diary, writerName);
    }

    @Transactional
    public ResDiaryDto update(Long diaryId, ReqPostDiaryDto requestDto){
        Diary diary = diaryRepository.findByDiaryId(diaryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        String writerName = getWriterName(requestDto.getUserId());
        Long id = diaryRepository.save(requestDto.toEntity()).getDiaryId();
        Diary updatedDiary = diaryRepository.findByDiaryId(diaryId)
                .orElseThrow(()-> new IllegalArgumentException("저장되지 않았습니다."));

        return new ResDiaryDto(diary, writerName);
    }

    @Transactional
    public ResDiaryListDto delete(Long diaryId, ReqDeleteDiaryDto requestDto){
        Diary diary = diaryRepository.findByDiaryId(diaryId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        diaryRepository.delete(diary);
//        다이어리 리스트 가져오는 메소드 필요
        //TODO Diary와 DiaryList의 controller 및 service 합치기
        return new ResDiaryListDto("groupCode", new ArrayList<ResReadDiaryDto>());
    }

    private String getWriterName(Long userId){
        User user = userRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("잘못된 사용자"));
        return user.getName();
    }

}
