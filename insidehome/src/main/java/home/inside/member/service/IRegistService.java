package home.inside.member.service;

import java.util.List;

import home.inside.member.util.RegistCommand;
import home.inside.member.vo.MemberAddrVo;
import home.inside.member.vo.MemberDropVo;

public interface IRegistService {
	//회원가입 처리
	public void registMember(RegistCommand regCmd) throws Exception;
	//회원가입 중복체크(이메일)
	public int emailCheck(String email) throws Exception;
	//회원가입 중복체크(닉네임)
	public int nicknameCheck(String nickname) throws Exception;
}
