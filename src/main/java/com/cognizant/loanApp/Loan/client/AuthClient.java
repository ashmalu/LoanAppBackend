//package com.cognizant.loanApp.Loan.client;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.cognizant.loanApp.Loan.model.AuthResponse;
//
//
//@FeignClient(url="${auth.path}",name="authapp")
//public interface AuthClient {
//	//@RequestMapping(path="/validate",method=RequestMethod.GET)
//	//public AuthResponse verifyToken(@RequestHeader(name="Authorization",required=true)String token);
//	
//	@GetMapping(value = "/validate")
//	public AuthResponse getValidity(@RequestHeader("Authorization") String token);
//	
//	//public Object isValid(String token);
//}
// 