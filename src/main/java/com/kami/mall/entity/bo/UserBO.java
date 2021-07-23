package com.kami.mall.entity.bo;

import lombok.Data;

import java.util.List;

/**
 * @author yangzi
 * @date 2021-07-13 3:16 PM
 */
@Data
public class UserBO {

    private String name;

    private String mobile;

    private List<String> permissionKeyList;

}
