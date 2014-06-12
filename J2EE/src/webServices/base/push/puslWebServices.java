package webServices.base.push;

import javax.xml.ws.Endpoint;

import webServices.base.serviceImpl.HelloWSImpl;

/**
 * 
 * @author admins
 * @summary 发布webservices
 */
public class puslWebServices {
	public static void main(String[] args){
		//发布webservices
		String address = "http://localhost:8080/J2EE/services/hellows";
		Endpoint.publish(address, new HelloWSImpl());
	}
}
