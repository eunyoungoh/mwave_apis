package com.cjenm.mwave.apis.app.notice;

import com.cjenm.mwave.apis.app.notice.model.Notice;
import com.cjenm.mwave.apis.app.notice.service.NoticeService;
import com.cjenm.mwave.apis.common.model.Result;
import com.cjenm.mwave.apis.common.utils.ResponseUtil;
import com.cjenm.mwave.apis.common.validation.Put;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "apis/notice/")
@Api(value = "게시판")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping(value = "get")
    @ApiOperation(value = "get 메소드 샘플", notes = "게시판을 조회 한다.")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ttl", value = "게시판 제목", dataType = "String", required = false)
        , @ApiImplicitParam(name = "lang", value = "언어", dataType = "String", required = false)
    })
    public ResponseEntity<?> getNotice(@RequestParam(name = "ttl", required = false) String ttl
        , @RequestParam(name = "lang", required = false) String lang) {

        log.info("get param : {}", ttl);
        log.info("get param : {}", lang);

        return ResponseUtil.getResult(noticeService.selectNoticeList(ttl));
    }

    @GetMapping(value = "getAdmin")
    @ApiOperation(value = "get 메소드 샘플", notes = "통신 하여 Admin 조회")
    public ResponseEntity<?> getAdminList(){
        return ResponseUtil.getResult(noticeService.selectAdmionList());
    }

    @PostMapping(value = "post")
    @ApiOperation(value = "post 메소드 샘플", notes = "게시판을 등록 한다.")
    public ResponseEntity<Result> postNotice(@RequestBody Notice notice) {
        log.info(notice.toString());

        noticeService.insertNotice(notice);

        return ResponseUtil.getResult();
    }

    @PutMapping(value = "put")
    @ApiOperation(value = "put 메소드 샘플", notes = "게시판을 수정 한다.")
    public ResponseEntity<?> putNotice( @RequestBody Notice notice) {
        log.info("put param :  {}", notice);

        noticeService.updateNotice(notice);

        return ResponseUtil.getResult();
    }

    @DeleteMapping(value = "delete/{seq}")
    @ApiOperation(value = "delete 메소드 샘플", notes = "게시판을 삭제 한다.")
    public ResponseEntity<?> deleteNotice(@PathVariable(name = "seq") Integer seq) {
        log.info("put param :  {}", seq);

        noticeService.deleteNotice(seq);

        return ResponseUtil.getResult();
    }

}
