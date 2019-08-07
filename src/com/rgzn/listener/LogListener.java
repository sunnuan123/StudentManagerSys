package com.rgzn.listener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class LogListener implements ServletRequestListener,ServletRequestAttributeListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// ��������ִ�еķ���
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// ����ʼִ�еķ���
		
		HttpServletRequest request =(HttpServletRequest) arg0.getServletRequest();
		//���ʵ������� ip 
		String ipAddr = request.getRemoteAddr();
		
		//���ʵ�ʱ��
		String time = new Date().toLocaleString();
		//���ʵ�·��
		StringBuffer url = request.getRequestURL();
		//���ʵķ���
		String method = request.getQueryString();
		
		PrintWriter  out=null;
		try {
			//ָ��true���Ǽ�¼����Ϣ����ʵ���ۼƵ�Ч��
			  out=new PrintWriter(new  FileWriter("d://log.txt",true));
			  
			  out.println("�����ţ�"+ipAddr+"ʱ�䣺"+time+"·����"+url+"����ķ�����"+method);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			out.close();
		}
	}
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
     //req.removed("admin");
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
     //req.setatt("admin" "3"); �ڶ���ִ��   request.setAttribute("admin", 2);
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
