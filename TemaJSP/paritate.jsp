<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Verificare Paritate</title>
</head>
<body>
 <h1>Verifica daca un numar este par sau impar (parametru "num")</h1>
<%
    // Preia valoarea parametrului din URL
    String param = request.getParameter("num");
    
    if (param != null) {
        try {
            int num = Integer.parseInt(param);
            String rezultat = (num % 2 == 0) ? "par" : "impar";
%>
            <h2>Numarul <%= num %> este <%= rezultat %>.</h2>
<%
        } catch (NumberFormatException e) {
%>
            <h2>Parametrul nu este un numar valid!</h2>
<%
        }
    } else {
%>
        <h2>Introdu parametrul "num" in URL (ex: ?num=15).</h2>
<%
    }
%>
</body>
</html>