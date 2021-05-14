package com.cjenm.mwave.apis.app.notice.mapper;

import com.cjenm.mwave.apis.app.notice.model.Notice;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
@Repository
public interface NoticeMapper {
    public List<Notice> selectNoticeList(String ttl);

    public Notice selectNotice();

    public int insertNotice(Notice notice);

    public int updateNotice(Notice notice);

    public int deleteNotice(int seq);
}
