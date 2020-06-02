package mashup.backend.etc.our.diary.controller;

import lombok.RequiredArgsConstructor;
import mashup.backend.etc.our.diary.dto.*;
import mashup.backend.etc.our.diary.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @GetMapping("/")
    public ResDiaryListDto readDiaryList(@RequestBody ReqDiaryListDto reqDiaryListDto){
        return diaryService.readDiaryList(reqDiaryListDto);
    }

    @GetMapping("/{diaryId}")
    public ResSingleDiaryDto getSingleDiaryById(@PathVariable Long diaryId, @RequestBody ReqSingleDiaryDto reqSingleDiaryDto){
        return diaryService.getSingleDiaryById(diaryId,reqSingleDiaryDto);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ReqPostDiaryDto reqBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.create(reqBody));
    }

    @PutMapping
    public ResponseEntity update(@PathVariable long diaryId, @RequestBody ReqPostDiaryDto reqBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.update(diaryId, reqBody));
    }

    @DeleteMapping("/{diaryId}")
    public ResponseEntity delete(@PathVariable long diaryId, @RequestBody ReqDeleteDiaryDto requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.delete(diaryId, requestBody));
    }
}
