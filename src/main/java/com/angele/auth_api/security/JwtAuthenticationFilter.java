package com.angele.auth_api.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
 private JwtTokenProvider jwtTokenProvider;
 private UserDetailsService userDetailsService;
 public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider,UserDetailsService userDetailsService) {
	 this.jwtTokenProvider=jwtTokenProvider;
	 this.userDetailsService=userDetailsService;
 }
 @Override
 protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain filterChain)throws ServletException,IOException{
	 String token=getTokenFromRequest(req);
	 if(StringUtils.hasText(token)&&jwtTokenProvider.validateToken(token)) {
		 String username=jwtTokenProvider.getUsername(token);
		 UserDetails userDetails=userDetailsService.loadUserByUsername(username);
		 UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	
		 authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
		 
		 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	 }
	 filterChain.doFilter(req, res);
 }
 private String getTokenFromRequest(HttpServletRequest req) {
	 String bearerToken=req.getHeader("Authorization");
	 if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith("Bearer ")) {
		 return bearerToken.substring(7,bearerToken.length());
	 }
	 return null;
 }
}
