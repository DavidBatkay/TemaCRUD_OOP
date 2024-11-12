<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Laptop Brand</title>
</head>
<body>
    <h2>Brand: <c:out value="${brand}" /></h2>
    <p>Numele brandului are <c:out value="${length}" /> caractere si este <c:out value="${parity}" />.</p>
</body>
</html>
