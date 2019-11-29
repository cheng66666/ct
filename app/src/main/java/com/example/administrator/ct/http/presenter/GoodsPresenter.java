package com.example.administrator.ct.http.presenter;

import com.example.administrator.ct.http.HttpMethods;
import com.example.administrator.ct.http.entity.GoodsEntity;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class GoodsPresenter extends HttpMethods{
    /**
     *
     * @param subscriber
     * @param keywords
     */
    public static void listByKeywords(Subscriber<List<GoodsEntity>> subscriber, String keywords){
        Observable<List<GoodsEntity>> observable = goodsService.listByKeywords(keywords)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 根据二级分类id获取商品
     * @param subscriber
     * @param catId
     */
    public static void list(Subscriber<List<GoodsEntity>> subscriber,int catId){
        Observable<List<GoodsEntity>> observable = goodsService.list(catId)
                .map(new HttpResultFunc<List<GoodsEntity>>());
        toSubscribe(observable,subscriber);
    }

}
