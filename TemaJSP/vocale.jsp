<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vocale</title>
</head>
<body>
<h1>Cate Vocale apar in Text</h1>
<%
    // Preia string-ul din parametru
    String text = request.getParameter("text");
    
    if (text != null) {
        int vocale = 0;
        String vocaleSet = "aeiouAEIOU";
        
        // Parcurge fiecare caracter și verifică dacă este vocală
        for (int i = 0; i < text.length(); i++) {
            if (vocaleSet.indexOf(text.charAt(i)) != -1) {
                vocale++;
            }
        }
%>
        <h2>Textul "<%= text %>" contine <%= vocale %> vocale.</h2>
<%
    } else {
%>
        <h2>Te rog introdu parametrul "text" in URL (ex: ?text=Salutare).</h2>
<%
    }
%>
</body>
</html>