<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Lisää uusi kysely</title>
</head>	
<body>
	<h1>
		Lisää uusi kysely
	</h1>
		<form:form modelAttribute="kysely">
		  	<fieldset>		
				<legend>Kyselyn tiedot</legend>
				<p>
					<form:label	path="kyselyName">Kyselyn nimi: </form:label><br/>
					<form:input path="kyselyName"/>		
				</p>
				<p>	
					<form:label path="kyselyDesc">Kyselyn kuvaus:</form:label><br/>
					<form:input path="kyselyDesc" />
				</p>
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
	<p><a href="/Kysely/">Palaa alkuun</a></p>
</body>
</html>