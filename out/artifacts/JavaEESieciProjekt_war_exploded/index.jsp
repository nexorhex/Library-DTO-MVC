<%--
  Created by IntelliJ IDEA.
  User: Student229665
  Date: 6/6/2018
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        label {
            display: inline-block;
            width: 120px;
            text-align: center
        }

        input {
            width: 120px;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Projekt sieci</title>
</head>
<body>
<div class="text-center">
    <h1>Witaj w bibliotece!</h1>
    <h2>Wpisz dane ksiazki, ktora chcesz dodac do biblioteki</h2>
    <form method="post" action="library">
        <br>
        <label>Tytul</label>
        <label>Autor</label>
        <label>Rok wydania</label>
        <label>ISBN</label><br>
        <input type="text" name="name1">
        <input type="text" name="author1">
        <input type="number" step="1" name="year1">
        <input type="text" name="isbn1"><br><br>
        <input type="submit" value="Dodaj ksiazki">
    </form>
    <a href="view.jsp" class="btn btn-primary" role="button">Zobacz ksiazki</a>
</div>
</body>
</html>
