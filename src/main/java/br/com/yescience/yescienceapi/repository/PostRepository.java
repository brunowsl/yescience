package br.com.yescience.yescienceapi.repository;

import br.com.yescience.yescienceapi.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {
}
