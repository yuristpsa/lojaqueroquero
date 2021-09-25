package br.com.yuristpsa.domain.salesman;

import br.com.yuristpsa.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salesman implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "salesman")
    @TableGenerator(name="salesman", table="sequence", schema="public")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "registration")
    private String registration;

}
