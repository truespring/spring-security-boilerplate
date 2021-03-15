package com.rsupprot.board.entity.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;
import java.util.List;

/**테스트 에러 발생 시 setting -> build,Execution, Deployment -> Build Tools -> Gradle -> Run Tests using -> IntelliJ IDEA**/

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        postsRepository.deleteAll();
    }
    @Test
    public void 게시글저장_불러오기(){
        // given
        //테스트 기반 환경을 구축하는 단계
        //@builder의 사용법도 같이 확인
        postsRepository.save(Posts.builder()
                        .title("테스트 게시글")
                        .content("테스트 본문")
                        .author("zkffhtm6523@gmail.com")
                        .build());
        // when
        //테스트 하고자 하는 행위 선언
        //여기선 Posts가 DB에 insert 되는것을 확인하기 위함
        List<Posts> postsList = postsRepository.findAll();

        // then
        //테스트 결과 검증
        //실제로 DB에 insert 되었는지 확인하기 위해 조회후, 입력된 값 확인
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));

        //given, when, then은 BDD(Behaviour-Driven Development)에서 사용하는 용어입니다.
    }
    @Test
    public void BaseTimeEntity_등록(){
        // given
        LocalDateTime now = LocalDateTime.now(); // 현재 시간 가져오기
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("zkffhtm6523@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));

    }
}
