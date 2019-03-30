package stGroup.newsportal.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import stGroup.newsportal.entity.Article;
import stGroup.newsportal.entity.Author;
import stGroup.newsportal.entity.Theme;
import java.util.List;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    @Query("select a from Article a where a.author = :author order by a.dateTime")
    List<Article> getByAuthor(@Param("author") Author author, Pageable pageable);

    @Query("select a from Article a where a.theme = :theme order by a.dateTime")
    List<Article> getByTheme(@Param("theme") Theme theme, Pageable pageable);

    @Query("select a from Article a order by a.upVotes DESC")
    List<Article> getMostUpvoted(Pageable pageable);

    @Query("select a from Article a order by a.views DESC")
    List<Article> getMostViewed(Pageable pageable);

}