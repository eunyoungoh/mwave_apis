package com.cjenm.mwave.apis.app.notice.model;

import com.cjenm.mwave.apis.common.validation.Put;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class Notice {
    @NotNull(groups = Put.class, message = "700")
    private Integer seq;
    private String ttl;
    private String cont;
    private Integer readCnt;
    private String dispYn;
    private String useYn;
    private Integer fileSeq;
    private String rgstId;
    private Date rgstYmdt;
    private String rgstIp;
    private String modId;
    private Date modYmdt;
    private String modIp;

    private List<Admin> adminList;
}
