package com.githrd.jennie.controller;
/*인터페이스 (추상함수)
앞으로 요청을 실행할 클래스들은 이것을 구현해서 만들어짐
타입을 하나로 만들기 위해, 
함수도 추상함수를 구현해서 만들어 지므로 하나의 원하는 형태로 사용 가능
b 
타입 함수이름(매개변수리스트)throws ServletException, IOException;
*/
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface BlpInter {
	String exec(HttpServletRequest req, HttpServletResponse resp) 
									throws ServletException, IOException;
}