package minu.coffee.shopInfo.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.channel.model.Channel;
import minu.coffee.common.CommonField;
import minu.coffee.subCategory.model.SubCategory;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "shop_info", schema = "minu_shop", catalog="minu_shop")
public class ShopInfo extends CommonField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String codeName;

}