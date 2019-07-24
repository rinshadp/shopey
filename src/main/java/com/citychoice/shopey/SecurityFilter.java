package com.citychoice.shopey;

//import com.appsdeveloperblog.ws.service.UsersService;
//import com.appsdeveloperblog.ws.service.impl.AuthenticationServiceImpl;
//import com.appsdeveloperblog.ws.shared.dto.UserProfileDto;
//import com.appsdeveloperblog.ws.shared.exceptions.AuthenticationException;
import java.io.IOException;
//import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.annotation.Priority;
//import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.StringTokenizer;

import com.citychoice.shopey.Secured;


@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {
    //private String user = "rinshad";
    //private String pass = "iloveindia";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Extract Authorization header details
        //return;
        String res = "started";
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            authorizationHeader = authorizationHeader.replaceFirst("Basic ", "");
            String authorizationString = authorizationHeader; //new String(Base64.getUrlDecoder().decode(authorizationHeader));
            StringTokenizer tokenizer = new StringTokenizer(authorizationString , ":");
            String userName = new String(tokenizer.nextToken());
            String password = new String(tokenizer.nextToken());
            res =  userName + " " + password;
            String name = "rinshad";
            String pass = "iloveindia";
            
            //return;
            if(name.equals(userName) && pass.equals(password)){//  && (password.equals(password))){// && pass.equals(password.toString())){
                res = "inside if";
                return;
            }
            //return;
        }

        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Not Authorized. Access Denied" + res).build());
    }
}