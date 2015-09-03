<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Biblioteca - Incluir Livro</title>
</head>
<body>
	<form action="TrataRequisicao">
		<table>
			<tr>
				<td>ISBN:</td>
				<td><input type="text" name="nmisbn" />
			</tr>
			<tr>
				<td>Título:</td>
				<td><input type="text" name="nmtitulo" />
			</tr>			
			<tr>
				<td>Autor:</td>
				<td><input type="text" name="nmautor" />
			</tr>			
			<tr>
				<td>Editora:</td>
				<td><input type="text" name="nmeditora" />
			</tr>			
			<tr>
				<td></td>
				<td><input type="submit" name="nmsubmit" value="Incluir" />
			</tr>			
							
		</table>
	</form>
</body>
</html>











