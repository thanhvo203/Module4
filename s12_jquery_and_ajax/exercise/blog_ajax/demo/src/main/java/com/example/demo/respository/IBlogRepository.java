package com.example.demo.respository;

import com.example.demo.model.BLog;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BLog,Integer> {
    List<BLog> findAllByCheckStatusIsFalse();

    List<BLog> findAllByTitleContains(String name);
    @Query(value = "select * from blogs limit :more ", nativeQuery = true)
    List<BLog> moreList(@Param("more") int more);
}
