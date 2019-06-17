package service;

import json_placeholder_model.response.PhotoResponse;
import json_placeholder_model.response.PostResponse;
import json_placeholder_model.response.PostsResponse;
import json_placeholder_spring_service.JSONPlaceholderService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;

public class JSONPlaceholderSpringServiceTests {

    JSONPlaceholderService service = new JSONPlaceholderService();

    private static final String postBody = "est rerum tempore vitae\n" +
            "sequi sint nihil reprehenderit dolor beatae ea dolores neque\n" +
            "fugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\n" +
            "qui aperiam non debitis possimus qui neque nisi nulla";
    private static final Integer postId = 2;
    private static final String postTitle =  "qui est esse";
    private static final Integer postUserId = 1;

    @Test
    public void checkIfServiceReturns1PostCorrectly() {
        PostResponse expectedPost = new PostResponse.Builder()
                .withBody(postBody)
                .withId(postId)
                .withTitle(postTitle)
                .withUserId(postUserId)
                .build();

        PostResponse actualPost = service.getPost("2");

        MatcherAssert.assertThat(actualPost, Matchers.equalTo(expectedPost));
    }

    @Test
    public void testIfResponseObjectFieldsContainCorrectValues() {
        PostResponse actualPost = service.getPost("2");

        MatcherAssert.assertThat(actualPost, Matchers.hasProperty("body",
                Matchers.equalTo(postBody)));
        MatcherAssert.assertThat(actualPost, Matchers.hasProperty("id",
                Matchers.equalTo(postId)));
        MatcherAssert.assertThat(actualPost, Matchers.hasProperty("title",
                Matchers.equalTo(postTitle)));
        MatcherAssert.assertThat(actualPost, Matchers.hasProperty("userId",
                Matchers.equalTo(postUserId)));
    }

    @Test
    public void mockitoPlays() {
        PhotoResponse mockPhoto = Mockito.mock(PhotoResponse.class);
        Mockito.when(mockPhoto.getAlbumId()).thenReturn(1);
        Mockito.when(mockPhoto.getUrl()).thenReturn("https://mock.com");
        Mockito.when(mockPhoto.getId()).thenReturn(2);
        Mockito.when(mockPhoto.getTitle()).thenReturn("example title");

        MatcherAssert.assertThat(1, Matchers.equalTo(mockPhoto.getAlbumId()));
        MatcherAssert.assertThat("https://mock.com", Matchers.equalTo(mockPhoto.getUrl()));
        MatcherAssert.assertThat(2, Matchers.equalTo(mockPhoto.getId()));
        MatcherAssert.assertThat("example title", Matchers.equalTo(mockPhoto.getTitle()));
    }

    @Test
    public void testIfReturnedPostsContainExpectedPost() {
        PostResponse expectedPost = new PostResponse.Builder()
                .withBody(postBody)
                .withId(postId)
                .withTitle(postTitle)
                .withUserId(postUserId)
                .build();
        
        PostsResponse actualPosts = service.getAllPosts();

        MatcherAssert.assertThat(actualPosts.getPosts(), Matchers.hasItem(expectedPost));
    }

}
