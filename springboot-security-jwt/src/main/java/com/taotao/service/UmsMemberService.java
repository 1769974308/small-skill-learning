package com.taotao.service;

import com.taotao.common.api.CommonResult;

/**
 * 会员管理Service
 * @auther ASUS
 * @date 2021/12/9
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
