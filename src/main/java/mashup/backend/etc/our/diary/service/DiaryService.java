package mashup.backend.etc.our.diary.service;

import mashup.backend.etc.our.diary.dto.ResDiaryDto;
import mashup.backend.etc.our.diary.dto.ResDiaryListDto;
import mashup.backend.etc.our.diary.repository.DiaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public ResDiaryDto create(){
        return new ResDiaryDto();
    }

    public ResDiaryDto update(){
        return new ResDiaryDto();
    }

    public ResDiaryListDto delete(){
        return new ResDiaryListDto();
    }

}
