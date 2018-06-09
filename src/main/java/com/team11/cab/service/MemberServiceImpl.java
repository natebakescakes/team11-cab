package com.team11.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Member;
import com.team11.cab.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Resource
	private MemberRepository memberrepository;

	@Override
	@Transactional
	public ArrayList<Member> findAllMember() {
		
		ArrayList<Member> members=(ArrayList<Member>) memberrepository.findAll();
		return members;
	}

}
