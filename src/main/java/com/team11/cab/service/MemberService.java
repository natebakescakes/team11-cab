package com.team11.cab.service;

import java.util.ArrayList;
import com.team11.cab.model.Member;

public interface MemberService {

	ArrayList<Member> findAllMember();
	void updateMember(Member m);
}
