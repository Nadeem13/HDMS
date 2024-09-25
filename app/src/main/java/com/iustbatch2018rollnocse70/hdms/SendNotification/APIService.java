package com.iustbatch2018rollnocse70.hdms.SendNotification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAJI-_YNk:APA91bFS3EXi0gJL6iy_hhAUC7kOGskZU6WHH7vzajqfDSMEBorajs51e-5eq6Lb_D9erRkzBSzrKDLKiP0tjvrz8QWl7T3KsuLA8X91SJw_HSRcp8NsepxS7jkLpvT9Fa4zVEjz7YWf"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body NotificationSender body);
}
