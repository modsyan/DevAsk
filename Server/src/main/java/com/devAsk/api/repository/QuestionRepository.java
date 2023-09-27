package com.devAsk.api.repository;

import com.devAsk.api.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//    @Modifying
//    @Query(
//            """
//                    update #{#entityName}
//                    """
//    )
//    public void deleteById(long id);

}
