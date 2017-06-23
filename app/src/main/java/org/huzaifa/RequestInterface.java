package org.huzaifa.rxjavaretrofit;

import org.huzaifa.rxjavaretrofit.Country;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Huzaifa on 22-Jun-17.
 */

public interface RequestInterface {
    @GET("tutorial/jsonparsetutorial.txt")
    //Observable<List<Country>> register();
    Call<JSONResponse> getJSON();
}
