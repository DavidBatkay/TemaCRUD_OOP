<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalii Laptop</title>
</head>
<body>
    <h2>Brand: <c:out value="${lap.brand}" /></h2>
    <p>Pret: <c:out value="${lap.pret}" /> RON</p>
    <p>RAM: <c:out value="${lap.ram}" /> GB</p>
</body>
</html>
