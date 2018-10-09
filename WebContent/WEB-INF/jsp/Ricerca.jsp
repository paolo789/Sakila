<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	ricerca attori
	<form action="cercaattori">
		<input type="text" name="actor" placeholder="ricerca attore">
		<input type=submit>
	</form>
	<br> ricerca film
	<form action="cercafilm">
		<input type="text" name="film" placeholder="ricerca film"> <input
			type=submit>
	</form>
	<form name="form1" action="cercagenere">
	<br> ricerca film per genere<br>
	<form name="form2" action="listagenere">
		<select name="filmgenere">
			<c:forEach items="${category}" var="cat">
				<option value="${cat.categoryId}">${cat.name}</option>
			</c:forEach>
			</form>
		</select>
	<input type="submit" name="genere">
	</form>
	<br>
	<c:if test="${attori != null}">
		<c:forEach items="${attori}" var="attore">
			<table>
				<tr>
					<td>
						<p>
							<a href="listafilmattore?Attore=${attore.actorId}">${attore.firstName}
								${attore.lastName}</a>
						</p>
				</tr>
			</table>
		</c:forEach>
	</c:if>

	<c:if test="${films != null}">
		<table border=1>
			<tr>
				<th>titolo</th>
				<th>descrizione</th>
			</tr>
			<c:forEach items="${films}" var="film">

				<tr>
					<td><a href="listaattorifilm?Film=${film.film_id}">${film.title}</a></td>
					<td>${film.description }</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>
	<c:if test="${filmsattore != null}">
		<table border=1>
			<tr>
				<th>titolo</th>
				<th>descrizione</th>
			</tr>
			<c:forEach items="${filmsattore}" var="filmattore">

				<tr>
					<td><a href="listaattorifilm?Film=${filmattore.film_id}">${filmattore.title}</a></td>
					<td>${filmattore.description }</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>

	<c:if test="${actorsfilm != null}">
		
			<c:forEach items="${actorsfilm}" var="actorfilm">

				
					<a href="listafilmattore?Attore=${actorfilm.actorId}">${actorfilm.firstName}
								${actorfilm.lastName}</a><br><br>
			</c:forEach>
	</c:if>
	<c:if test="${categoryFilm != null}">
		<table border=1>
			<tr>
				<th>Titolo</th>
				<th>Descrizione</th>
			</tr>
			<c:forEach items="${categoryFilm}" var="catfilm">

				<tr>
					<td><a href="listaattorifilm?Film=${catfilm.film_id}">${catfilm.title}</a></td>
					<td>${catfilm.description }</td>

				</tr>

			</c:forEach>
		</table>
	</c:if>
</body>
</html>