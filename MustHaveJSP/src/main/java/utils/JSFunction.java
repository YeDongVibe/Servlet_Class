package utils;

import javax.servlet.jsp.JspWriter;

public class JSFunction {

	public static void alertLocation(String msg, String url, JspWriter out) { //jspFunction.~~라고 선언해서 사용. // class명.~~~
		try {
			String script = ""
					+"<script>"
					+"alert('" + msg + "');"
					+"location.href='" + url + "';"
					+"</script>";
			out.println(script);
		} catch (Exception e) {
		}
	}

	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = "" + "<script>" + "alert('" + msg + "');" + "history.back();" + "</script>";
			out.println(script);
		} catch (Exception e) {
		}

	}
}
