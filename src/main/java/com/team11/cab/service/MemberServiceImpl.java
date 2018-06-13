package com.team11.cab.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Authority;
import com.team11.cab.model.Member;
import com.team11.cab.repository.AuthorityRepository;
import com.team11.cab.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Resource
	private MemberRepository memberRepository;
	
	@Resource
	private AuthorityRepository authorityRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public ArrayList<Member> findAllMember() {

		ArrayList<Member> members = (ArrayList<Member>) memberRepository.findAll();
		return members;
	}

	@Override
	public Member findMemberByUsername(String username) {
		return memberRepository.findByUsername(username);
	}

	@Override
	public void saveMember(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setEnabled(true);
		
		Authority authority = new Authority();
		authority.setMember(member);
		authority.setAuthority("ROLE_USER");
		
		member.setAuthorities(new HashSet<Authority>(Arrays.asList(authority)));
		
		memberRepository.save(member);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username);
		List<GrantedAuthority> authorities = getUserAuthority(member.getAuthorities());
		return buildUserForAuthentication(member, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Authority> userAuthorities) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Authority authority : userAuthorities) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(authorities);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(Member member, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPassword(),
				member.isEnabled(), true, true, true, authorities);
	}

}
