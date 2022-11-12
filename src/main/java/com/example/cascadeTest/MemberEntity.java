package com.example.cascadeTest;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberEntity_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "memberEntity", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private List<BoardEntity> boardEntities = new ArrayList<>();

}
