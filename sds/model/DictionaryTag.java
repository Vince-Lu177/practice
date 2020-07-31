package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DictionaryTag {
    private Integer id;
    private String  DictionaryTagKey;
    private String  DictionaryTagValue;
    private String  DictionaryTagDesc;
    private Integer DictionaryId;
    private Date createTime;
}
