package mashup.backend.etc.our.diary.service;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.diary.dto.*;
import mashup.backend.etc.our.diary.domain.entity.Diary;
import mashup.backend.etc.our.diary.domain.repository.DiaryRepository;
import mashup.backend.etc.our.group.entity.Group;
import mashup.backend.etc.our.group.entity.UserGroup;
import mashup.backend.etc.our.group.repository.GroupRepository;
import mashup.backend.etc.our.group.repository.UserGroupRepository;
import mashup.backend.etc.our.user.entity.User;
import mashup.backend.etc.our.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final UserGroupRepository userGroupRepository;

    @Transactional(readOnly=true)
    public ResDiaryListDto readDiaryList(ReqDiaryListDto reqDiaryListDto){

        UserGroup userGroup = userGroupRepository.findUserGroupByGroupIdAndUserId(reqDiaryListDto.getGroupId(),reqDiaryListDto.getUserId())
                .orElseThrow(NoResultException::new); // user가 groupId를 가지고 있지 않는 경우

        Long groupId = userGroup.getGroupId();

        List<ResReadDiaryDto> diaryList = diaryRepository.findDiariesByGroupId(groupId).stream()
                .map(ResReadDiaryDto::new)
                .collect(Collectors.toList());

        Group foundGroup = groupRepository.findById(groupId)
                .orElseThrow(()->new IllegalArgumentException("해당 그룹이 없습니다"));

        return ResDiaryListDto.builder()
                .groupCode(foundGroup.getCode())
                .diaries(diaryList)
                .build();
    }

    public ResSingleDiaryDto getSingleDiaryById(Long diaryId, ReqSingleDiaryDto reqSingleDiaryDto){
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(()->new IllegalArgumentException("해당 글이 없습니다"));

        //TODO user domain
        /*
        User writer = userRepository.findById(reqSingleDiaryDto.getUserId())
                .orElseThrow(()->new IllegalArgumentException("해당 글이 없습니다"));
         */

        return new ResSingleDiaryDto(diary,"test"); //TODO "test"-> writer.name
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

        ReqDiaryListDto reqDiaryListDto = ReqDiaryListDto.builder()
                .groupId(diary.getGroupId())
                .userId(diary.getWriterId())
                .build();

        // 다이어리 리스트 가져오기
        ResDiaryListDto resDiaryListDto = readDiaryList(reqDiaryListDto);

        return resDiaryListDto;
    }

    private String getWriterName(Long userId){
        User user = userRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("잘못된 사용자"));
        return user.getName();
    }

}
