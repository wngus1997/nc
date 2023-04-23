package com.neighborCabinet.project.controller;

import com.neighborCabinet.project.model.MemberVO;
import com.neighborCabinet.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class MemberController {
    @Autowired
    MemberService service;

    @RequestMapping("/member/joinform")
    public String joinForm() {
        return "member/joinform";
    }
    @RequestMapping("member/term")
    public String term() {
        return "member/term";
    }
    @RequestMapping("member/loginform")
    public String login(){
        return "member/loginform";
    }


    @ResponseBody
    @RequestMapping("/member/login")
    public String loginCheck(@RequestParam HashMap<String, Object> param,
                             HttpSession session) {
        // 로그인 체크 결과
        String result = service.loginCheck(param); // result : "success" 또는 "fail"


        // 아이디와 비밀번호 일치하면 (로그인 성공하면)
        // 서비스에서 "success" 반환받았으면
        if(result.equals("success")) {
            //로그인 성공하면 세션 변수 지정
            String id = (String)param.get("id");
            session.setAttribute("sid",id);
            String nicknmae = service.getNickName(id);
            session.setAttribute("nickname",nicknmae);
        }

        return result;
    }
    @RequestMapping("/member/logout")
    public String logout(HttpSession session) {
        //세션 무효화
        session.invalidate();
        return "redirect:/"; // index로 포워딩 -> ProductController에 있는 @RequestMapping("/")
    }

    @RequestMapping("/member/insert")
    public String insert(MemberVO vo) {
        service.insertMember(vo);
        return "member/loginform"; // 회원 가입 후 로그인 폼으로 이동
    }

    @ResponseBody
    @RequestMapping("/member/memIdCheck")
    public String memIdCheck(@RequestParam("userId") String userId){
        String userId_result = service.userIdCheck(userId);

        String result = "use";
        if(userId_result != null) //존재 한다면
            result ="no_use";

        return  result;
    }

    @RequestMapping("/findidform")
    public String findidform(){

        return "member/findid";
    }

    @ResponseBody
    @RequestMapping("/findid")
    public String findid(@RequestParam String name, @RequestParam String email, Model model){
        String id = service.findid(name,email);
        String result = "fail";
        if( id != null){
            result = "success";
        }
        System.out.println(id);
        return id;
    }


}


