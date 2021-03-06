package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Building {
    private Integer id;
    private String buildingName;
    private String buildingDesc;
    private Date createTime;
}
