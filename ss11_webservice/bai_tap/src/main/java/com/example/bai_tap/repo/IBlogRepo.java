package com.example.bai_tap.repo;


import com.example.bai_tap.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from Blogs AS b where upper(b.name) like concat(upper(:name),'%' )", nativeQuery = true)
    Page<Blog> searchByName(@Param(value = "name") String name, Pageable pageable);

    //   @Query(value ="update  Blogs set name= :name,content= :content,times=:times where id= :id",nativeQuery = true )
//    void updateBlogsByIdIs(Blog blog);
    Page<Blog> findAllByFlagDeleteIsFalse(Pageable pageable);

    Blog getBlogByIdAndFlagDeleteIsFalse(int id);
}

