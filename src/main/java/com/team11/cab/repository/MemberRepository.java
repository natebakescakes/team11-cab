package com.team11.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.team11.cab.model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	Member findByUsername(String username);
	
}
