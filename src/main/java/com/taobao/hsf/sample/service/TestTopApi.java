/*
 * Copyright 2014 Aliyun.com All right reserved. This software is the
 * confidential and proprietary information of Aliyun.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Aliyun.com .
 */
package com.taobao.hsf.sample.service;

import java.util.List;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.QxbProductLink;
import com.taobao.api.request.AlibabaQixinbaoProductlinksGetRequest;
import com.taobao.api.response.AlibabaQixinbaoProductlinksGetResponse;

/**
 * 类TestTopAPi.java的实现描述：TODO 类实现描述
 * 
 * @author heng.xiong 2014-2-22 下午5:50:29
 */
public class TestTopApi {

    public static void main(String[] args) {
        String url = " http://10.232.37.47:8080/top/router/rest";
        String appkey = "4272";
        String secret = "0ebbcccfee18d7ad1aebc5b135ffa906";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaQixinbaoProductlinksGetRequest req = new AlibabaQixinbaoProductlinksGetRequest();
        req.setQxbId(138L);
        AlibabaQixinbaoProductlinksGetResponse response;
        try {
            response = client.execute(req);
            System.out.println(response.getBody());
            List<QxbProductLink> list = response.getProductLinks();
            for (QxbProductLink qxbProductLink : list) {
                System.out.println(qxbProductLink.getUrl());
            }
        } catch (ApiException e) {
            e.getStackTrace();
        }

    }

}
