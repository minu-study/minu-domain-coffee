package minu.coffee.memberInfo.repository;

import minu.coffee.memberInfo.model.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberInfoRepo extends JpaRepository<MemberInfo, Long> {

    Optional<MemberInfo> findByMemberId(String memberId);

}
