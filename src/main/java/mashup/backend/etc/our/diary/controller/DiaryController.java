package mashup.backend.etc.our.diary.controller;

import mashup.backend.etc.our.diary.dto.ReqDeleteDiaryDto;
import mashup.backend.etc.our.diary.dto.ReqPostDiaryDto;
import mashup.backend.etc.our.diary.dto.ResDiaryDto;
import mashup.backend.etc.our.diary.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService){
        this.diaryService = diaryService;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ReqPostDiaryDto reqBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.create(reqBody));
    }

    @PutMapping
    public ResponseEntity update(@PathVariable Long diaryId, @RequestBody ReqPostDiaryDto reqBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.update(diaryId, reqBody));
    }

    @DeleteMapping("/{diaryId}")
    public ResponseEntity delete(@PathVariable Long diaryId, @RequestBody ReqDeleteDiaryDto requestBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.delete(diaryId, requestBody));
    }
}
