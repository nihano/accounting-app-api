package com.accounting.accountingapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    public LocalDateTime insertDateTime=LocalDateTime.now();

    @Column(nullable = false, updatable = false)
    public Long insertUserId=1L;

    @Column(nullable = false)
    public LocalDateTime lastUpdateDateTime=LocalDateTime.now();

    @Column(nullable = false)
    public Long lastUpdateUserId=1l;

    private boolean isDeleted=false;



}
