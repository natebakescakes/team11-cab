package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.Member;

public interface MemberService {

	ArrayList<Member> findAllMember();

	void updateMember(Member m);
	void editMember(Member m);
<<<<<<< HEAD
	void deleteMember(Member m);
=======
	//void deleteMember(Member m);
>>>>>>> refs/remotes/origin/master

	public Member findMemberById(int id);

	public Member findMemberByUsername(String username);

	public void saveMember(Member member);

}
