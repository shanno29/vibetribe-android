package matthew.shannon.jamfam.service.network;

import java.util.List;

import matthew.shannon.jamfam.model.Chat;
import matthew.shannon.jamfam.model.Post;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkService {

    /*
    * Users Route
    */
    @POST("users/postUser/")
    Observable<User> postUser(@Body User user);

    @POST("users/login/")
    Observable<User> loginUser(@Body User user);

    @POST("users/logout")
    Observable<User> logoutUser(@Body User user);

    @PUT("users/{userId}/")
    Observable<User> putUser(@Header("Authorization") String authorization, @Path("userId") String userId, @Body User user);

    @GET("users/")
    Observable<List<User>> getAllUsers(@Header("Authorization") String authorization);

    @GET("users/{userId}/")
    Observable<List<User>> getUser(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("users/{userId}/")
    Observable<List<User>> deleteUser(@Header("Authorization") String authorization, @Path("userId") String userId);

    /*
    * Chats Route
    */
    @POST("chats/{userId}/{userTwoId}/")
    Observable<Chat> postChat(@Header("Authorization") String authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId, @Body String text);

    @PUT("chats/{chatId}/")
    Observable<Chat> putChat(@Header("Authorization") String authorization, @Path("chatId") String chatId, @Body String text);

    @GET("chats/")
    Observable<List<Chat>> getAllChats(@Header("Authorization") String authorization);

    @GET("chats/{userId}/")
    Observable<List<Chat>> getUserChats(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("chats/{chatId}/")
    Observable<Chat> deleteChat(@Header("Authorization") String authorization, @Path("chatId") String chatId);

    /*
    * Posts Route
    */
    @POST("posts/{userId}/{userTwoId}/")
    Observable<Post> postPost(@Header("Authorization") String authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId, @Body String text);

    @PUT("posts/{postId}/")
    Observable<Post> putPost(@Header("Authorization") String authorization, @Path("postId") String postId, @Body String text);

    @GET("posts/")
    Observable<List<Post>> getAllPosts(@Header("Authorization") String authorization);

    @GET("posts/{userId}/")
    Observable<List<Post>> getUserPosts(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("posts/{postId}/")
    Observable<Post> deletePost(@Header("Authorization") String authorization, @Path("postId") String postId);

    /*
    * Friends Route
    */
    @POST("friends/{userId}/{userTwoId}/")
    Observable<User> postFriend(@Header("Authorization") String authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId);

    @GET("friends/")
    Observable<List<User>> getAllFriends(@Header("Authorization") String authorization);

    @GET("friends/{userId}/")
    Observable<List<User>> getUserFriends(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("friends/{userId}/{userTwoId}/")
    Observable<User> deleteFriend(@Header("Authorization") String authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId);

    /*
    * Matches Route
    */
    @POST("matches/{userId}/{userTwoId}/")
    Observable<User> postMatch(@Header("Authorization") String authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId);

    @GET("matches/")
    Observable<List<User>> getAllMatches(@Header("Authorization") String authorization);

    @GET("matches/{userId}/")
    Observable<List<User>> getUserMatches(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("matches/{userId}/{userTwoId}/")
    Observable<User> deleteMatch(@Header("Authorization") String authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId);

    /*
     * Tracks Route
     */
    @POST("tracks/{userId}/")
    Observable<Track> postTrack(@Header("Authorization") String authorization, @Path("userId") String userId, @Body Track track);

    @GET("tracks/")
    Observable<List<Track>> getAllTracks(@Header("Authorization") String authorization);

    @GET("tracks/{userId}/")
    Observable<List<Track>> getUserTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("tracks/search/")
    Observable<List<Track>> searchOnline(@Header("Authorization") String authorization, @Query("title") String title, @Query("artist") String artist, @Query("limit") String limit);

    @GET("tracks/nearby/{userId}/")
    Observable<List<Track>> getNearbyTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("tracks/friends/{userId}/")
    Observable<List<Track>> getFriendsTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @GET("tracks/matches/{userId}/")
    Observable<List<Track>> getMatchesTracks(@Header("Authorization") String authorization, @Path("userId") String userId);

    @DELETE("tracks/{trackId}/")
    Observable<Track> deleteTrack(@Header("Authorization") String authorization, @Path("trackId") String trackId);

}
