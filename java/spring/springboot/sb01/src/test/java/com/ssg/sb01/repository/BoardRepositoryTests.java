package com.ssg.sb01.repository;

import com.ssg.sb01.domain.Board;
import java.util.stream.IntStream;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

  @Autowired
  private BoardRepository boardRepository;

  // insert 실행은 JpaRepository save() - 영속컨텍스트 내 데이터 존재유무를 따져 없으면 insert 있으면 update
  @Test
  public void testInsert() {
    IntStream.rangeClosed(1,100).forEach(i->{
      Board board = Board.builder()
          .title("title")
          .content("content")
          .writer("ssg")
          .build();

      Board saved = boardRepository.save(board);
      log.info(saved.getBno());
    });
  }
}
