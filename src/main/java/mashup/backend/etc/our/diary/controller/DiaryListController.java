package mashup.backend.etc.our.diary.controller;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.diary.dto.ReqDiaryListDto;
import mashup.backend.etc.our.diary.dto.ResDiaryListDto;
import mashup.backend.etc.our.diary.service.DiaryListService;
import mashup.backend.etc.our.diary.service.DiaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DiaryListController {

    private final DiaryListService diaryListService;

    @GetMapping("/diaries")
    public ResDiaryListDto readDiaryList(@RequestBody ReqDiaryListDto reqDiaryListDto){
        return diaryListService.readDiaryList(reqDiaryListDto);
    }
}
