package com.example.cascadeTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired BoardRepository boardRepository;

    @Test
    @Rollback(false)
    void test() {

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName("asd");

        MemberEntity memberEntity1 = memberRepository.save(memberEntity);

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle("asd");
        boardEntity.setMemberEntity(memberEntity1);
        boardRepository.save(boardEntity);

        System.out.println(memberEntity.getBoardEntities().size());
        System.out.println(memberEntity1.getBoardEntities().size());

    }

}