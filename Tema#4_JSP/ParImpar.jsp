<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Par sau Impar</title>
</head>
<body>
    <h1>Verificare par/impar</h1>
    
    <%
        String numStr = request.getParameter("numar");
        
        if (numStr != null) {
            try {
                int numar = Integer.parseInt(numStr);
                String rezultat = (numar % 2 == 0) ? "par" : "impar";
                out.println("<p>Numarul " + numar + " este " + rezultat + ".</p>");
            } catch (NumberFormatException e) {
                out.println("<p>Introdu un numar valid.</p>");
            }
        } else {
            out.println("<p>Introdu un numar.</p>");
        }
    %>
</body>
</html>