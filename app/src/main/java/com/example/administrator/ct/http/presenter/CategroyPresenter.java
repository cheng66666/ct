package com.example.administrator.ct.http.presenter;

import com.example.administrator.ct.http.HttpMethods;
import com.example.administrator.ct.http.entity.CategroyEntity;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class CategroyPresenter extends HttpMethods {
    /**
     * 获取一级分类列表
     *
     * @param subscriber
     */
    public static void getTopList(Subscriber<List<CategroyEntity>> subscriber) {
        Observable<List<CategroyEntity>> observable = categroyService.getTopList()
                .map(new HttpResultFunc<List<CategroyEntity>>());
        toSubscribe(observable, subscriber);
    }

    /**
     * 获取二级分类列表
     *
     * @param parentId
     */
    public static void getSecondList(Subscriber<List<CategroyEntity>> subscriber, int parentId) {
        Observable<List<CategroyEntity>> observable = categroyService.getSecondList(parentId)
                .map(new HttpResultFunc<List<CategroyEntity>>());
        toSubscribe(observable, subscriber);
    }

}
