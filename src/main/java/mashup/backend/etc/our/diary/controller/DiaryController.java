package mashup.backend.etc.our.diary.controller;

import mashup.backend.etc.our.diary.dto.ReqPostDiaryDto;
import mashup.backend.etc.our.diary.dto.ResDiaryDto;
import mashup.backend.etc.our.diary.service.DiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    private DiaryService diaryService;

    public DiaryController(DiaryService diaryService){
        this.diaryService = diaryService;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ReqPostDiaryDto reqBody){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.create());
    }

    @PutMapping
    public ResponseEntity update(){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.update());
    }

    @DeleteMapping
    public ResponseEntity delete(){
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.delete());
    }
}
