package com.angele.auth_api.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.*;
import jakarta.servlet.*;

import jakarta.servlet.http.*;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
@Override
	public void commence(HttpServletRequest req,HttpServletResponse res,AuthenticationException authException ) throws IOException,ServletException{
		res.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
	}
}
