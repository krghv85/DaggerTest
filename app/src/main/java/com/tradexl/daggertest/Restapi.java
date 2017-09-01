package com.tradexl.daggertest;

import com.tradexl.daggertest.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Raghav on 01-Sep-17.
 */

public interface Restapi {
    @GET("answers?order=desc&sort=activity&site=stackoverflow&tagged=android")
    Call<Post> getAnswerData();
}
