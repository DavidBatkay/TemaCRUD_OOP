<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Suma a 2 numere</title>
</head>
<body>
<h2>Introduceti 2 numere in url ca parametrii (num1 si num2)</h2>
    <%
        // Preluăm parametrii num1 și num2
        String num1Param = request.getParameter("num1");
        String num2Param = request.getParameter("num2");

        // Validăm și calculăm suma dacă parametrii sunt prezentați
        if (num1Param != null && num2Param != null) {
            try {
                int num1 = Integer.parseInt(num1Param);
                int num2 = Integer.parseInt(num2Param);
                int sum = num1 + num2;

                out.println("<p>"+ num1 + " + " + num2 + " = " + sum + "</p>");
            } catch (NumberFormatException e) {
                out.println("<p>Introduceti 2 numere valide.</p>");
            }
        } else {
            out.println("<p>Introduceti 2 numere.</p>");
        }
    %>
</body>
</html>