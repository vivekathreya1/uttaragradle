package com.indian.uttara.commonapi;

import com.indian.uttara.apimodel.CartQntValidateRepo;
import com.indian.uttara.apimodel.OtpVerifyRepo;
import com.indian.uttara.apimodel.PayuHashRepo;
import com.indian.uttara.apimodel.ServicesRepo;
import com.indian.uttara.apimodel.SmsRequestRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public interface ApiServiceInterface {

    @GET("SpringMVC/rest/GetServiceDetails?product_Item=oooo")
    Call<List<ServicesRepo>> getAllServices();

    @FormUrlEncoded
    @POST("SpringMVC/rest/RegisterOTP")
    Call<SmsRequestRepo> requestSMS(@Field("number") String mobile);


    @FormUrlEncoded
    @POST("SpringMVC/rest/ValidateOTP")
    Call<OtpVerifyRepo> checkOTP(@Field("number") String number, @Field("otp") String otp);

    @POST("SpringMVC/rest/ValidateOrder")
    Call<List<CartQntValidateRepo>> sendOrderDetails(@Body String object);

    @FormUrlEncoded
    @POST("SpringMVC/rest/genPayuHash")
    Call<PayuHashRepo> requestHash(@Field("key") String key, @Field("amount") String amount, @Field("productInfo") String productInfo, @Field("firstname") String firstname, @Field("email") String email,
                                   @Field("udf1") String udf1, @Field("udf2") String udf2, @Field("udf3") String udf3, @Field("udf4") String udf4, @Field("udf5") String udf5);

}
