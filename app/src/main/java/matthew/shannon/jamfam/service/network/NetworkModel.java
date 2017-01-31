package matthew.shannon.jamfam.service.network;

import java.util.List;

import matthew.shannon.jamfam.model.data.Chat;
import matthew.shannon.jamfam.model.data.Post;
import matthew.shannon.jamfam.model.data.Track;
import matthew.shannon.jamfam.model.data.User;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Header;
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
        return null;
    }

    @Override
    public Observable<User> putUser(@Header("Authorization") String Authorization, @Path("userId") String userId, @Body User user) {
        return retrofit.create(NetworkService.class).putUser(Authorization, userId, user);
    }

    @Override
    public Observable<List<User>> getAllUsers(@Header("Authorization") String Authorization) {
        return retrofit.create(NetworkService.class).getAllUsers(Authorization);
    }

    @Override
    public Observable<List<User>> getUser(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUser(Authorization, userId);
    }

    @Override
    public Observable<List<User>> deleteUser(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).deleteUser(Authorization, userId);
    }

    /*
    * Chats Route
    */

    @Override
    public Observable<Chat> postChat(@Header("Authorization") String Authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId, @Body String text) {
        return retrofit.create(NetworkService.class).postChat(Authorization, userId, userTwoId, text);
    }

    @Override
    public Observable<Chat> putChat(@Header("Authorization") String Authorization, @Path("chatId") String chatId, @Body String text) {
        return retrofit.create(NetworkService.class).putChat(Authorization, chatId, text);
    }

    @Override
    public Observable<List<Chat>> getAllChats(@Header("Authorization") String Authorization) {
        return retrofit.create(NetworkService.class).getAllChats(Authorization);
    }

    @Override
    public Observable<List<Chat>> getUserChats(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserChats(Authorization, userId);
    }

    @Override
    public Observable<Chat> deleteChat(@Header("Authorization") String Authorization, @Path("chatId") String chatId) {
        return retrofit.create(NetworkService.class).deleteChat(Authorization, chatId);
    }

    /*
    * Posts Route
    */

    @Override
    public Observable<Post> postPost(@Header("Authorization") String Authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId, @Body String text) {
        return retrofit.create(NetworkService.class).postPost(Authorization, userId, userTwoId, text);
    }

    @Override
    public Observable<Post> putPost(@Header("Authorization") String Authorization, @Path("postId") String postId, @Body String text) {
        return retrofit.create(NetworkService.class).putPost(Authorization, postId, text);
    }

    @Override
    public Observable<List<Post>> getAllPosts(@Header("Authorization") String Authorization) {
        return retrofit.create(NetworkService.class).getAllPosts(Authorization);
    }

    @Override
    public Observable<List<Post>> getUserPosts(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserPosts(Authorization, userId);
    }

    @Override
    public Observable<Post> deletePost(@Header("Authorization") String Authorization, @Path("postId") String postId) {
        return retrofit.create(NetworkService.class).deletePost(Authorization, postId);
    }

    /*
    * Friends Route
    */

    @Override
    public Observable<User> postFriend(@Header("Authorization") String Authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId) {
        return retrofit.create(NetworkService.class).postFriend(Authorization, userId, userTwoId);
    }

    @Override
    public Observable<List<User>> getAllFriends(@Header("Authorization") String Authorization) {
        return retrofit.create(NetworkService.class).getAllFriends(Authorization);
    }

    @Override
    public Observable<List<User>> getUserFriends(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserFriends(Authorization, userId);
    }

    @Override
    public Observable<User> deleteFriend(@Header("Authorization") String Authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId) {
        return retrofit.create(NetworkService.class).deleteFriend(Authorization, userId, userTwoId);
    }

    /*
    * Matches Route
    */

    @Override
    public Observable<User> postMatch(@Header("Authorization") String Authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId) {
        return retrofit.create(NetworkService.class).postMatch(Authorization, userId, userTwoId);
    }

    @Override
    public Observable<List<User>> getAllMatches(@Header("Authorization") String Authorization) {
        return retrofit.create(NetworkService.class).getAllMatches(Authorization);
    }

    @Override
    public Observable<List<User>> getUserMatches(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserMatches(Authorization, userId);
    }

    @Override
    public Observable<User> deleteMatch(@Header("Authorization") String Authorization, @Path("userId") String userId, @Path("userTwoId") String userTwoId) {
        return retrofit.create(NetworkService.class).deleteMatch(Authorization, userId, userTwoId);
    }

    /*
     * Tracks Route
     */

    @Override
    public Observable<Track> postTrack(@Header("Authorization") String Authorization, @Path("userId") String userId, @Body Track track) {
        return retrofit.create(NetworkService.class).postTrack(Authorization, userId, track);
    }

    @Override
    public Observable<List<Track>> getAllTracks(@Header("Authorization") String Authorization) {
        return retrofit.create(NetworkService.class).getAllTracks(Authorization);
    }

    @Override
    public Observable<List<Track>> getUserTracks(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getUserTracks(Authorization, userId);
    }

    @Override
    public Observable<List<Track>> searchOnline(@Header("Authorization") String Authorization, @Query("title") String title, @Query("artist") String artist, @Query("limit") String limit) {
        return retrofit.create(NetworkService.class).searchOnline(Authorization, title, artist, limit);
    }

    @Override
    public Observable<List<Track>> getNearbyTracks(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getNearbyTracks(Authorization, userId);
    }

    @Override
    public Observable<List<Track>> getFriendsTracks(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getFriendsTracks(Authorization, userId);
    }

    @Override
    public Observable<List<Track>> getMatchesTracks(@Header("Authorization") String Authorization, @Path("userId") String userId) {
        return retrofit.create(NetworkService.class).getMatchesTracks(Authorization, userId);
    }

    @Override
    public Observable<Track> deleteTrack(@Header("Authorization") String Authorization, @Path("trackId") String trackId) {
        return retrofit.create(NetworkService.class).deleteTrack(Authorization, trackId);
    }
}
