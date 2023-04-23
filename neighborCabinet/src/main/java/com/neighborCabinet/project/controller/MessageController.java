package com.neighborCabinet.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neighborCabinet.project.model.MesChkVO;
import com.neighborCabinet.project.model.ReserveVO_y;
import com.neighborCabinet.project.model.messageAllVO_y;
import com.neighborCabinet.project.service.MessageService_y;

@Controller
public class MessageController {
	@Autowired
	private MessageService_y service;
	
//	@ResponseBody
//	@RequestMapping("/message/check")
//	public MesChkVO mesCheck(@RequestParam("mesNo") int mesNo, HttpSession session, Model model) {
//		
//		String userId = (String) session.getAttribute("sid");
//		System.out.println("여기1");
//		service.meschange(mesNo);
//		System.out.println("여기2");
//		MesChkVO chk = new MesChkVO();
//		System.out.println("여기3");
//		chk.setMesR(service.mesRequestCheck(userId));
//		chk.setMesAll(service.mesAllCheck(userId));
//		
//		System.out.println(chk.getMesAll());
//		System.out.println(chk.getMesR());
//		
//		return chk;
//		
//	}
	
	@RequestMapping("/message")
	public String message(HttpSession session, Model model) {
		
		return "/message/header";
		
	}
	
	@RequestMapping("/message/message")
	public String mesMessage(HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute("sid");
		
		ArrayList<messageAllVO_y> message = service.messageAll(userId);
		
		for(int i = 0;i<message.size();i++) {
			message.get(i).setMesDate(message.get(i).getMesDate().substring(0, 16));
		}
		model.addAttribute("message", message);
		
		return "/message/message";
		
	}
	@RequestMapping("/message/delete")
	public String mesMessageDelete(@RequestParam("chmes[]") ArrayList<Integer> chkArr, HttpSession session, Model model) {
		
		if(chkArr != null) {
			for(int mesNo : chkArr) {
				service.mesDelete(mesNo);
			}
		}
		
		String userId = (String) session.getAttribute("sid");
		
		ArrayList<messageAllVO_y> message = service.messageAll(userId);
		
		for(int i = 0;i<message.size();i++) {
			message.get(i).setMesDate(message.get(i).getMesDate().substring(0, 16));
		}
		model.addAttribute("message", message);
		
		
		return "redirect:/message/message";
		
	}
	@RequestMapping("/message/deleteAll")
	public String mesMessageDeleteAll(HttpSession session, Model model) {
		
		
		
		String userId = (String) session.getAttribute("sid");
		service.mesDeleteAll(userId);
		
		ArrayList<messageAllVO_y> message = service.messageAll(userId);
		
		for(int i = 0;i<message.size();i++) {
			message.get(i).setMesDate(message.get(i).getMesDate().substring(0, 16));
		}
		model.addAttribute("message", message);
		
		
		return "redirect:/message/message";
		
	}
	
	@RequestMapping("/message/request")
	public String mesrequest(HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute("sid");
		
		ArrayList<ReserveVO_y> resInfo = service.resInfo(userId);
		model.addAttribute("resInfo", resInfo);

		return "/message/mesRequest";
		
	}
	
	@ResponseBody
	@RequestMapping("/message/requestO/{reserveNo}/{messageId}")
	public ArrayList<ReserveVO_y> requestO(@PathVariable int reserveNo, @PathVariable String messageId, HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute("sid");
		if(service.resCheck(reserveNo, userId) == 0) {
			ArrayList<ReserveVO_y> resInfo = null;
			return resInfo;
		}
		service.requestO(reserveNo, messageId);
		
		ArrayList<ReserveVO_y> resInfo = service.resInfo(userId);
		
		return resInfo;
	}
	@ResponseBody
	@RequestMapping("/message/requestX/{reserveNo}/{messageId}")
	public ArrayList<ReserveVO_y> requestX(@PathVariable int reserveNo, @PathVariable String messageId, HttpSession session, Model model) {
		String userId = (String) session.getAttribute("sid");
		if(service.resCheck(reserveNo, userId) == 0) {
			ArrayList<ReserveVO_y> resInfo = null;
			return resInfo;
		}
		service.requestX(reserveNo, messageId);
		
		ArrayList<ReserveVO_y> resInfo = service.resInfo(userId);
		
		return resInfo;
	}
	
	@RequestMapping("/message/requestInfo/{reserveNo}")
	public String requestInfo(@PathVariable int reserveNo, HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute("sid");
		
		ReserveVO_y requestInfo = service.requestInfo(reserveNo, userId);
		String HP = requestInfo.getSenderPhone().substring(0, 3)+ "-" + requestInfo.getSenderPhone().substring(3, 7) + "-"
				+ requestInfo.getSenderPhone().substring(7);
		model.addAttribute("requestInfo", requestInfo);
		model.addAttribute("HP", HP);
		
		return "/message/requestInfo";
	}
	@RequestMapping("/message/requestInfo2/{reserveNo}")
	public String requestInfo2(@PathVariable int reserveNo, HttpSession session, Model model) {
		
		String userId = (String) session.getAttribute("sid");
		
		ReserveVO_y requestInfo = service.requestInfo(reserveNo, userId);
		
		model.addAttribute("requestInfo", requestInfo);
		
		return "/message/requestInfo2";
	}
}
