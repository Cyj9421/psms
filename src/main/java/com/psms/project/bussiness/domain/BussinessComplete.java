package com.psms.project.bussiness.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BussinessComplete {
    /**  销差id  */
    private int destroyId;
    /**  出差id  */
    private int tripId;
    /**  销差状态  */
    private int destroyStatus;
    /**  申请人  */
    private String createDestroyBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /**  申请时间  */
    private Date createDestroyTime;
    /**  审核人  */
    private String updateDestroyBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /**  审核时间  */
    private Date updateDestroyTime;
    /**  出差对象*/
    private List<BussinessTrip> trips;
}
