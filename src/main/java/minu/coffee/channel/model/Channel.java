package minu.coffee.channel.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.common.CommonField;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "channel", schema = "minu_shop", catalog="minu_shop")
public class Channel extends CommonField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String codeName;

}