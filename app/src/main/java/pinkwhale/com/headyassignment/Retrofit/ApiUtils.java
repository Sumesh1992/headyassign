package pinkwhale.com.headyassignment.Retrofit;

import retrofit2.Retrofit;


public class ApiUtils {

    public static final String BASE_URL = "https://stark-spire-93433.herokuapp.com/";
    //public static final String BASE_URL = "https://pinkwhalehealthcare.com/";
    private static Retrofit retrofit = null;

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
