<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css" type="text/css" />
<title>Deltagerliste</title>
</head>
<body>
  <p>Innlogget som: ${bruker.mobil} / ${bruker.fornavn} ${bruker.etternavn}</p>
  <h2>Deltagerliste</h2>
  <table>
    <tr>
      <th>Kjønn</th>
      <th align="left">Navn</th>
      <th align="left">Mobil</th>
    </tr>
    <c:forEach var="deltager" items="${deltagere}">
      <tr
        style=<c:if test="${bruker.mobil eq deltager.mobil}">"background-color:#418941"</c:if>>
        <c:choose>
          <c:when test="${deltager.kjonn eq 'mann'}">
            <td align="center">&#9794;</td>
          </c:when>
          <c:when test="${deltager.kjonn eq 'kvinne'}">
            <td align="center">&#9792;</td>
          </c:when>
          <c:otherwise>
            <td align="center">X</td>
          </c:otherwise>
        </c:choose>

        <td>${deltager.fornavn} ${deltager.etternavn}</td>
        <td>${deltager.mobil}</td>
      </tr>
    </c:forEach>

  </table>
  <br>
  <form action="utlogging" method="post">
    <button type="submit">Logg ut</button>
  </form>
</body>
</html>