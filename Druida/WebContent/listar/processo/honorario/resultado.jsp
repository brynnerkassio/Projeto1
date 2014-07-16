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
<title>Listar Processos por Honorários</title>
</head>
<body>

	<jsp:include page="../../../menu.html" />

	<form action="/Druida/processoHonorario" method="get">
		<fieldset>
			<legend>Listar Processos por Honorários</legend>
			<p>
				<label>Número do Processo <input type="text"
					name="nroProcesso" id="idNroProcesso" value="" />
				</label>
			</p>
			<p>
				<label>Nome do Cliente <input type="text" value="" name="nomeCliente" id="idNomeCliente" />
				</label>
			</p>
			<p>
				Período <input type="text" name="dataInicial" value="" /> até <input type="text" name="dataFinal" value="" />
			</p>
			<p>
				<input type="submit" value="Buscar" class="btn btn-primary" />
			</p>
		</fieldset>
	</form>

	<table style="width: 900px"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>Número</th>
				<th>Descrição</th>
				<th>Cliente</th>
				<th>Ação</th>
			</tr>
		</thead>
		<tbody>
			<!--<c:forEach items="${requestScope.lista}" var="li">-->
				<tr>
					<td>${li.nroProcesso}</td>
					<td>${li.descricao}</td>
					<td>${li.cliente.razaoSocial}</td>
					<td colspan="2"><a href="lancarHonorarioSetup?nroProcesso=${li.nroProcesso}">Lançar Honorário</a> - <a href="listarHonorario?nroProcesso=${li.nroProcesso}">Consultar Honorário</a></td>
				</tr>
			<!--</c:forEach>-->
		</tbody>
	</table>

	<script type="text/javascript" src="../../../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../../js/bootstrap.js"></script>
</body>
</html>