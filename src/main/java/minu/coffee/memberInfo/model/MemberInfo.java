package minu.coffee.memberInfo.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.common.CommonField;
import minu.coffee.filter.EntityColumnEncryptor;
import minu.coffee.shopInfo.model.ShopInfo;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "member_info", schema = "minu_shop", catalog="minu_shop")
public class MemberInfo extends CommonField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_info_id")
    private ShopInfo shopInfo;

    @Convert(converter = EntityColumnEncryptor.class)
    @Column(name = "first_name")
    private String firstName;

    @Convert(converter = EntityColumnEncryptor.class)
    @Column(name = "last_name")
    private String lastName;

    @Convert(converter = EntityColumnEncryptor.class)
    @Column(name = "email")
    private String email;

    @Convert(converter = EntityColumnEncryptor.class)
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "point")
    private Integer point;

}