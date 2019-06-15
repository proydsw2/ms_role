package com.cibertec.ms_role.Model;

import lombok.*;
import javax.persistence.*;

@SequenceGenerator(name="seq_role_id", allocationSize=1)
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role_id")
    @Column(name = "num_role_id")
    private Integer num_role_id;

    @Column(name = "str_role_name")
    private String str_role_name ;
}
