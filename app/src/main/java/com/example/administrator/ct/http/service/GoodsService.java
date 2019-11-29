package com.example.administrator.ct.http.service;

import com.example.administrator.ct.http.entity.GoodsEntity;
import com.example.administrator.ct.http.entity.HttpResult;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface GoodsService {

    /**
     *
     * @param keywords
     * @return
     */
    @FormUrlEncoded
    @POST("goods/find")
    Observable<HttpResult<List<GoodsEntity>>> listByKeywords(
            @Field("input") String keywords
    );

    /**
     * 根据二级分类id获取商品
     * @param catId
     * @return
     */
    @GET("goods/cat/{catId}")
    Observable<HttpResult<List<GoodsEntity>>> list(
        @Path("catId") int catId
    );

}
