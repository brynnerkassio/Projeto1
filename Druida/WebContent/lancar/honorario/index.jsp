<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="br.com.fiap.am.druida.bean.Processo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="/Druida/css/bootstrap.css" rel="stylesheet" media="screen" />
<link href="/Druida/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="/Druida/css/druida.css" rel="stylesheet" />
<title>Lançar Honorário no Processo nº ${requestScope.honorario.processo.nroProcesso}</title>
</head>
<body>

	<jsp:include page="../../menu.html" />

	<form action="LancarHonorario" method="post">
		<fieldset>
			<legend>Lançar Honorário</legend>
			<p>
				Processo: nº ${requestScope.id.processo.nroProcesso}
			</p>
			<p>
				Cliente: ${requestScope.id.processo.cliente.razaoSocial}
			</p>
			<p>
				Advogado: ${requestScope.id.processo.advogado.nome}
			</p>
			<p>
				<label for="idTarefas">Honorário<br />
					<select name="codigoTarefa">
						<option value="" id="idTarefas">Selecione</option>
					<c:forEach items="${requestScope.tarefas}" var="ta">
						<option value="${ta.codigoTarefa}">${ta.tipoTarefa}</option>
					</c:forEach>
					</select>
				</label>
			</p>
			<p>
				<label for="idData">Data 
					<br /><input type="text" name="data" id="idData" value="" />
				</label>
			</p>
			<p>
				<label for="idQntHoras">Quantidade de Horas 
					<br /><input type="text" name="qntHoras" id="idQntHoras" value="" />
				</label>
			</p>
			<p>
				<label for="idObs">Observações 
					<br /><textarea name="obs" id="idObs" cols="10" rows="10"></textarea>
				</label>
			</p>
			<p>
				<input type="hidden" name="nroProcesso" value="${requestScope.id.processo.nroProcesso}" />
				<input type="submit" value="Gravar" class="btn btn-primary" />
			</p>
		</fieldset>
	</form>

	<script type="text/javascript" src="../../../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../../js/bootstrap.js"></script>
</body>
</html>