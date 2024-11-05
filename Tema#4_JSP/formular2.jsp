<!DOCTYPE html>
<html>
<head>
    <title>Formular Operatii</title>
</head>
<body>
    <h1>Alege o operatiune</h1>

    
    <form action="Suma.jsp" method="get">
        <h2>Calcul Suma</h2>
        <div>
            <label>Numarul 1:</label>
            <input type="text" name="num1" required />
        </div>
        <div>
            <label>Numarul 2:</label>
            <input type="text" name="num2" required />
        </div>
        <div>
            <input type="submit" value="Calculeaza Suma" />
        </div>
    </form>
    
    <br>

    
    <form action="ParImpar.jsp" method="get">
        <h2>Verificare Par/Impar</h2>
        <div>
            <label>Numarul:</label>
            <input type="text" name="numar" required />
        </div>
        <div>
            <input type="submit" value="Verifica Par/Impar" />
        </div>
    </form>
    
    <br>

    
    <form action="Vocala.jsp" method="get">
        <h2>Numara Vocalele</h2>
        <div>
            <label>Text:</label>
            <input type="text" name="text" required />
        </div>
        <div>
            <input type="submit" value="Numara Vocalele" />
        </div>
    </form>

</body>
</html>