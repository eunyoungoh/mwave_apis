package com.cjenm.mwave.apis.app.notice.service;

import com.cjenm.mwave.apis.app.notice.mapper.NoticeMapper;
import com.cjenm.mwave.apis.app.notice.model.Admin;
import com.cjenm.mwave.apis.app.notice.model.Notice;
import com.cjenm.mwave.apis.common.validation.Put;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@Service("noticeService")
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final RestTemplate restTemplate;

    public NoticeService(NoticeMapper noticeMapper, RestTemplate restTemplate) {
        this.noticeMapper = noticeMapper;
        this.restTemplate = restTemplate;
    }

    /**
     * 게시판 단건 조회.
     * @return
     */
    public Notice selectNotice() {
        return noticeMapper.selectNotice();
    }

    public List<Admin> selectAdmionList(){
        return restTemplate.getForObject("http://localhost:8086/apis/get", List.class);
    }

    /**
     * 게시판 다건 조회.
     * @param ttl
     * @return
     */
    public List<Notice> selectNoticeList(String ttl) {
        //        if (true) {
        //            throw new BizException(HttpStatus.INTERNAL_SERVER_ERROR, "404");
        //        }
        return noticeMapper.selectNoticeList(ttl);
    }

    /**
     * 게시판 등록.
     * @param notice
     * @return
     */
    public int insertNotice(Notice notice) {
        return noticeMapper.insertNotice(notice);
    }

    /**
     * 게시판 수정.
     * @param seq
     * @return
     */
    @Validated(Put.class)
    public int updateNotice(@Valid Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 게시판 삭제.
     * @param seq
     * @return
     */
    public int deleteNotice(int seq) {
        return noticeMapper.deleteNotice(seq);
    }
}
