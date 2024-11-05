<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Numararea vocalelor</title>
</head>
<body>
    <h1>Numararea vocalelor</h1>
    
    <%
        String text = request.getParameter("text");
        
        if (text != null) {
            int count = 0;
            for (char c : text.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    count++;
                }
            }
            out.println("<p>Numarul de vocale în textul dat este: " + count + "</p>");
        } else {
            out.println("<p>Introdu un text.</p>");
        }
    %>
</body>
</html>