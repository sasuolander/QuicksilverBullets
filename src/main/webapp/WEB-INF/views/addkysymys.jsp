<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kysymyksen lisäys</title>
</head>
<body>
<h1>Kysymyksen lisäys</h1>
		<form:form modelAttribute="kysymys" method="post">
		  	<fieldset>		
				<legend>Kysymys</legend>
				<p>
				<!-- Viltsu: ja täällä tuon kyselyId arvon tähän kohtaan formia näkyviin. Näytän sen sen takia että tiedämme
				että se on siellä. -->
					<form:label path="kyselyId">KyselyId</form:label><br>
					<form:input path ="kyselyId"/>
				</p>
				<p>
					<form:label	path="kysymys">Kysymys: </form:label><br/>
					<form:input path="kysymys"/>		
				</p>
				<p>	
					<form:label path="kysymysType">Tyyppi:</form:label><br/>
					<form:input path="kysymysType" />
				</p>
				<p>	
					<button type="submit">Lisää</button>
				</p>
			</fieldset>
		</form:form>
	<p><a href="/Kysely/">Palaa alkuun</a></p>

</body>
</html>