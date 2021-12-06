package com.odw.crud.repo.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Accessors(chain = true)
@Entity
public class Customer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @Id
    protected int customerId;

    @NonNull
    protected String firstName;

    @NonNull
    protected String lastName;

    protected boolean married;

}
