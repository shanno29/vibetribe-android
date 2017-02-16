package matthew.shannon.jamfam.service.network;

import java.util.List;

import matthew.shannon.jamfam.model.Chat;
import matthew.shannon.jamfam.model.Post;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkService {

    /*
    * Users Route
    */
    @POST("users/")
    Observable<User> postUser(@Body User user);

    @PUT("users/login")
    Observable<User> loginUser(@Body User user);

    @POST("users/logout")
    Observable<User> logoutUser(@Body User user);

    @PUT("users/{userId}/")
    Observable<User> putUser(@Header("Authorization") String authorization, @Path("userId") String userId, @Body User user);

    @Multipart
    @PUT("users/{userId}/avatars")
    Observable<User> putUserAvatar(@Header("Authorization") String authorization, @Path("userId") String userId, @Part MultipartBody.Part avatar, @Body User user);

    @Multipart
    @PUT("users/{userId}/banners")
    Observable<User> putUserBanner(@Header("Authorization") String authorization, @Path("userId") String userId, @Part MultipartBody.Part banner, @Body User user);

    @GET("users/")
    Observable<List<User>> getAllUsers(@Header("Authorization") String authorization);

    @GET("users/{userId}/")
    Observable<List<User>> getUser(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("users/{userId}/")
    Observable<List<User>> deleteUser(@Header("Authorization") String authorization, @Path("userId") String userId);

    /*
    * Chats Route
    */
    @POST("chats/")
    Observable<Chat> postChat(@Header("Authorization") String authorization, @Body List<String> owners);

    @PUT("chats/{chatId}/")
    Observable<Chat> putChat(@Header("Authorization") String authorization, @Path("chatId") String chatId, @Body String text);

    @GET("chats/")
    Observable<List<Chat>> getAllChats(@Header("Authorization") String authorization);

    @GET("chats/{chatId}/")
    Observable<List<Chat>> getSingleChat(@Header("Authorization") String authorization, @Path("chatId") String chatId);

    @GET("chats/{userId}/user")
    Observable<List<Chat>> getUserChats(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("chats/{chatId}/")
    Observable<Chat> deleteChat(@Header("Authorization") String authorization, @Path("chatId") String chatId);

    /*
    * Posts Route
    */
    @POST("posts/")
    Observable<Post> postPost(@Header("Authorization") String authorization,  @Body List<String> owners);

    @PUT("posts/{postId}/")
    Observable<Post> putPost(@Header("Authorization") String authorization, @Path("postId") String postId, @Body String text);

    @GET("posts/")
    Observable<List<Post>> getAllPosts(@Header("Authorization") String authorization);

    @GET("posts/{userId}/user")
    Observable<List<Post>> getUserPosts(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("posts/{postId}")
    Observable<List<Post>> getSinglePost(@Header("Authorization") String authorization, @Path("postId") String postId);

    @DELETE("posts/{postId}/")
    Observable<Post> deletePost(@Header("Authorization") String authorization, @Path("postId") String postId);

    /*
    * Friends Route
    */
    @POST("friends/")
    Observable<User> postFriend(@Header("Authorization") String authorization, @Body List<String> owners);

    @GET("friends/")
    Observable<List<User>> getAllFriends(@Header("Authorization") String authorization);

    @GET("friends/{friendId}/")
    Observable<List<User>> getSingleFriend(@Header("Authorization") String authorization, @Path("friendId") String friendId);

    @GET("friends/{userId}/user")
    Observable<List<User>> getUserFriends(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("friends/{friendId}/")
    Observable<User> deleteFriend(@Header("Authorization") String authorization, @Path("friendId") String friendId);

    /*
    * Matches Route
    */
    @POST("matches/")
    Observable<User> postMatch(@Header("Authorization") String authorization, @Body List<String> owners);

    @GET("matches/")
    Observable<List<User>> getAllMatches(@Header("Authorization") String authorization);

    @GET("matches/{userId}/user")
    Observable<List<User>> getUserMatches(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("matches/{matchId}/")
    Observable<List<User>> getSingleMatch(@Header("Authorization") String authorization, @Path("matchId") String matchId);

    @DELETE("matches/{matchId}/")
    Observable<User> deleteMatch(@Header("Authorization") String authorization, @Path("matchId") String matchId);

    /*
     * Tracks Route
     */
    @POST("tracks/")
    Observable<Track> postTrack(@Header("Authorization") String authorization, @Body Track track);

    @GET("tracks/")
    Observable<List<Track>> getAllTracks(@Header("Authorization") String authorization);

    @GET("tracks/{trackId}")
    Observable<List<Track>> getSingleTrack(@Header("Authorization") String authorization, @Path("trackId") String trackId);

    @GET("tracks/{userId}/user")
    Observable<List<Track>> getUserTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("tracks/search/{query}/{limit}")
    Observable<List<Track>> searchOnline(@Header("Authorization") String authorization, @Query("query") String title, @Query("limit") String limit);

    @GET("tracks/{userId}/nearby")
    Observable<List<Track>> getNearbyTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("tracks/{userId}/friends")
    Observable<List<Track>> getFriendsTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("tracks/{userId}/matches")
    Observable<List<Track>> getMatchesTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("tracks/{trackId}/")
    Observable<Track> deleteTrack(@Header("Authorization") String authorization, @Path("trackId") String trackId);

}
