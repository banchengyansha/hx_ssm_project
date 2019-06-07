package cn.itcast.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {

    private Integer id;
    private String operateclass;
    private String operatemethod;
    private String paramvalue;
    private Date operatetime;
    private Long operatecost;
    private Integer operateuser;
    private String returnclass;
    private String returnvalue;

}
