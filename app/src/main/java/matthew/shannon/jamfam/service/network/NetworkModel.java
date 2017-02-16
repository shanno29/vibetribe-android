package matthew.shannon.jamfam.service.network;

import java.util.List;

import matthew.shannon.jamfam.model.Chat;
import matthew.shannon.jamfam.model.Post;
import matthew.shannon.jamfam.model.Track;
import matthew.shannon.jamfam.model.User;
import okhttp3.MultipartBody;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public class NetworkModel implements NetworkService {
    private final Retrofit retrofit;

    public NetworkModel(Retrofit retrofit) {
        this.retrofit = retrofit;

    }

    /*
    * Users Route
    */
    @Override
    public Observable<User> postUser(@Body User user) {
        return retrofit.create(NetworkService.class).postUser(user);
    }

    @Override
    public Observable<User> loginUser(@Body User user) {
        return retrofit.create(NetworkService.class).loginUser(user);
    }

    @Override
    public Observable<User> logoutUser(@Body User user) {
        return retrofit.create(NetworkService.class).logoutUser(user);
    }

    @Override
    public Observable<User> putUser(@Header("Authorization") String auth, @Path("userId") String userId, @Body User user) {
        return retrofit.create(NetworkService.class).putUser(auth, userId, user);
    }

    @Override
    public Observable<User> putUserAvatar(@Header("Authorization") String auth, @Path("userId") String userId, @Part MultipartBody.Part avatar, @Body User user) {
        return retrofit.create(NetworkService.class).putUserAvatar(auth, userId, avatar, user);
    }

    @Override
    public Observable<User> putUserBanner(@Header("Authorization") String auth, @Path("userId") String userId, @Part MultipartBody.Part banner, @Body User user) {
        return retrofit.create(NetworkService.class).putUserBanner(auth, userId, banner, user);
    }

    @Override
    public Observable<List<User>> getAllUsers(@Header("Authorization") String auth) {
        return retrofit.create(NetworkService.class).getAllUsers(auth);
    }

    @Override
    public Observable<List<User>> getUser(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUser(auth, userId);
    }

    @Override
    public Observable<List<User>> deleteUser(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).deleteUser(auth, userId);
    }

    @Override
    public Observable<Chat> postChat(@Header("Authorization") String auth, @Body List<String> owners) {
        return retrofit.create(NetworkService.class).postChat(auth, owners);
    }

    /*
    * Chats Route
    */

    @Override
    public Observable<Chat> putChat(@Header("Authorization") String auth, @Path("chatId") String chatId, @Body String text) {
        return retrofit.create(NetworkService.class).putChat(auth, chatId, text);
    }

    @Override
    public Observable<List<Chat>> getAllChats(@Header("Authorization") String auth) {
        return retrofit.create(NetworkService.class).getAllChats(auth);
    }

    @Override
    public Observable<List<Chat>> getSingleChat(@Header("Authorization") String auth, @Path("chatId") String chatId) {
        return retrofit.create(NetworkService.class).getSingleChat(auth, chatId);
    }

    @Override
    public Observable<List<Chat>> getUserChats(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserChats(auth, userId);
    }

    @Override
    public Observable<Chat> deleteChat(@Header("Authorization") String auth, @Path("chatId") String chatId) {
        return retrofit.create(NetworkService.class).deleteChat(auth, chatId);
    }

    @Override
    public Observable<Post> postPost(@Header("Authorization") String auth, @Body List<String> owners) {
        return retrofit.create(NetworkService.class).postPost(auth, owners);
    }

    /*
    * Posts Route
    */


    @Override
    public Observable<Post> putPost(@Header("Authorization") String auth, @Path("postId") String postId, @Body String text) {
        return retrofit.create(NetworkService.class).putPost(auth, postId, text);
    }

    @Override
    public Observable<List<Post>> getAllPosts(@Header("Authorization") String auth) {
        return retrofit.create(NetworkService.class).getAllPosts(auth);
    }

    @Override
    public Observable<List<Post>> getUserPosts(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserPosts(auth, userId);
    }

    @Override
    public Observable<List<Post>> getSinglePost(@Header("Authorization") String auth, @Path("postId") String userId) {
        return retrofit.create(NetworkService.class).getSinglePost(auth, userId);
    }

    @Override
    public Observable<Post> deletePost(@Header("Authorization") String auth, @Path("postId") String postId) {
        return retrofit.create(NetworkService.class).deletePost(auth, postId);
    }

    @Override
    public Observable<User> postFriend(@Header("Authorization") String auth, @Body List<String> owners) {
        return retrofit.create(NetworkService.class).postFriend(auth, owners);
    }

    /*
    * Friends Route
    */



    @Override
    public Observable<List<User>> getAllFriends(@Header("Authorization") String auth) {
        return retrofit.create(NetworkService.class).getAllFriends(auth);
    }

    @Override
    public Observable<List<User>> getSingleFriend(@Header("Authorization") String auth, @Path("friendId") String friendId) {
        return retrofit.create(NetworkService.class).getSingleFriend(auth, friendId);
    }

    @Override
    public Observable<List<User>> getUserFriends(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserFriends(auth, userId);
    }

    @Override
    public Observable<User> deleteFriend(@Header("Authorization") String auth, @Path("friendId") String friendId) {
        return retrofit.create(NetworkService.class).deleteFriend(auth, friendId);
    }

    @Override
    public Observable<User> postMatch(@Header("Authorization") String auth, @Body List<String> owners) {
        return retrofit.create(NetworkService.class).postMatch(auth, owners);
    }



    /*
    * Matches Route
    */


    @Override
    public Observable<List<User>> getAllMatches(@Header("Authorization") String auth) {
        return retrofit.create(NetworkService.class).getAllMatches(auth);
    }

    @Override
    public Observable<List<User>> getUserMatches(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserMatches(auth, userId);
    }

    @Override
    public Observable<List<User>> getSingleMatch(@Header("Authorization") String auth, @Path("matchId") String matchId) {
        return retrofit.create(NetworkService.class).getSingleMatch(auth, matchId);
    }

    @Override
    public Observable<User> deleteMatch(@Header("Authorization") String auth, @Path("matchId") String matchId) {
        return retrofit.create(NetworkService.class).deleteMatch(auth, matchId);
    }



    /*
     * Tracks Route
     */

    @Override
    public Observable<Track> postTrack(@Header("Authorization") String auth, @Body Track track) {
        return retrofit.create(NetworkService.class).postTrack(auth, track);
    }

    @Override
    public Observable<List<Track>> getAllTracks(@Header("Authorization") String auth) {
        return retrofit.create(NetworkService.class).getAllTracks(auth);
    }

    @Override
    public Observable<List<Track>> getSingleTrack(@Header("Authorization") String auth, @Path("trackId") String trackId) {
        return retrofit.create(NetworkService.class).getSingleTrack(auth, trackId);
    }

    @Override
    public Observable<List<Track>> getUserTracks(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserTracks(auth, userId);
    }

    @Override
    public Observable<List<Track>> searchOnline(@Header("Authorization") String auth, @Query("query") String query, @Query("limit") String limit) {
        return retrofit.create(NetworkService.class).searchOnline(auth, query, limit);
    }

    @Override
    public Observable<List<Track>> getNearbyTracks(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getNearbyTracks(auth, userId);
    }

    @Override
    public Observable<List<Track>> getFriendsTracks(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getFriendsTracks(auth, userId);
    }

    @Override
    public Observable<List<Track>> getMatchesTracks(@Header("Authorization") String auth, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getMatchesTracks(auth, userId);
    }

    @Override
    public Observable<Track> deleteTrack(@Header("Authorization") String auth, @Path("trackId") String trackId) {
        return retrofit.create(NetworkService.class).deleteTrack(auth, trackId);
    }
}
