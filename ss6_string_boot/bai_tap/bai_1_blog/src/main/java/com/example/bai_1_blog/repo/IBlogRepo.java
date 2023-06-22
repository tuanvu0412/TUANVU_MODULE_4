package com.example.bai_1_blog.repo;

import com.example.bai_1_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
public interface IBlogRepo extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from Blogs AS b where upper(b.name) like concat(upper(:name),'%' )",nativeQuery = true)
    List<Blog> searchByName(@Param(value = "name")String name);
   @Query(value ="update  Blogs set name= :name,content= :content,times=:times where id= :id",nativeQuery = true )
    void updateBlogsByIdIs(Blog blog);
}

