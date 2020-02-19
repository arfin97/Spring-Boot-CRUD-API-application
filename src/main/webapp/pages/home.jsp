<%@ page language="java" contentType="text/html; ISO-8859-1; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>Hello</h1>
    <form action="addAlien">
        <h3>ID</h3>
        <input type="text" name="aid">
        <h3>Name</h3>
        <input type="text" name="name">
        <h3>Tech</h3>
        <input type="text" name="tech" >
        <input type="submit">
    </form>

    <h1>Find By id</h1>
    <form action="getAlien">
        <h3>ID</h3>
        <input type="text" name="aid">
        <input type="submit">
    </form>

    <h1>Find By Tech</h1>
    <form action="getAlien">
        <h3>Tech</h3>
        <input type="text" name="tech">
        <input type="submit">
    </form>
</body>
</html>