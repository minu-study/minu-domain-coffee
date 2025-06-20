package minu.coffee.pointHistory.model;

import jakarta.persistence.*;
import lombok.*;
import minu.coffee.common.CommonField;
import minu.coffee.memberInfo.model.MemberInfo;
import minu.coffee.paymentHistory.model.PaymentHistory;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@Table(name = "point_history", schema = "minu_shop", catalog="minu_shop")
public class PointHistory extends CommonField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_info_id")
    private MemberInfo memberInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_history_id")
    private PaymentHistory paymentHistory;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "point_amount")
    private Integer pointAmount;

    @Column(name = "point_balance_after")
    private Integer pointBalanceAfter;

}