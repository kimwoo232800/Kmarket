package kr.co.Kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.Kmarket.service.member.MemberService;
import kr.co.Kmarket.vo.MemberVo;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = req.getParameter("km_uid");
		String pass = req.getParameter("km_pass1");
		String name = req.getParameter("km_name");
		String gender = req.getParameter("km_gender");
		String hp = req.getParameter("km_hp");
		String email = req.getParameter("km_email");
		String zip = req.getParameter("km_zip");
		String addr1 = req.getParameter("km_addr1");
		String addr2 = req.getParameter("km_addr2");
		String regip = req.getRemoteAddr();
		
		MemberVo member = new MemberVo();
		
		member.setUid(uid);
		member.setPass(pass);
		member.setName(name);
		member.setGender(Integer.parseInt(gender));
		member.setHp(hp);
		member.setEmail(email);
		member.setZip(zip);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setRegip(regip);
		
		service.insertMember(member);
		
		// 리다이렉트
		resp.sendRedirect("/Kmarket/member/login.do");
	
	}
	
}
