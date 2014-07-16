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
<title>Listar Honorários</title>
</head>
<body>

	<jsp:include page="../../menu.html" />

	<fieldset>
		<legend>Listando Honorários</legend>
			<p>
				Processo: nº ${requestScope.id.processo.nroProcesso}
			</p>
			<p>
				Cliente: ${requestScope.id.processo.cliente.razaoSocial}
			</p>
	</fieldset>

	<table style="width: 900px"	class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>Data</th>
				<th>Nome</th>
				<th>Quantidade de Horas</th>
				<th>Ação</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.honorarios}" var="hn">
				<tr>
					<td>${hn.dataHonorarioReturn}</td>
					<td>${hn.tipoTarefa.tipoTarefa}</td>
					<td>${hn.qntHora}</td>
					<td colspan="2"><a
						href="editarHonorarioSetup?codigoLancamento=${hn.codigoLancamento}">Editar Honorário</a> - <a href="excluirHonorario?codigoLancamento=${hn.codigoLancamento}&nroProcesso=${id.processo.nroProcesso}">Excluir Honorário</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script type="text/javascript" src="../../../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../../js/bootstrap.js"></script>
</body>
</html>