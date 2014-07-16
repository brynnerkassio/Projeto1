<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="br.com.fiap.am.druida.bean.Despesa"%>
<%@ page import="br.com.fiap.am.druida.bean.TipoDespesa"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
<title>Editar Despesa</title>
</head>
<body>

	<jsp:include page="../../menu.html" />

	<%
		Despesa desp = (Despesa)request.getAttribute("id");
		TipoDespesa td = new TipoDespesa();
		td = desp.getTipoDespesa();
		td.getCodigoDespesa();
		short nro = 1;
	%>

	<form action="editarDespesa" method="post">
		<fieldset>
			<legend>Editar Despesa</legend>
			<p>
				Processo: nº ${requestScope.id.processo.nroProcesso}
			</p>
			<p>
				Cliente: ${requestScope.id.processo.cliente.razaoSocial}
			</p>
			<p>
				<label for="idDespesas">Despesa<br />
					<select name="codigoDespesa">
						<option value="" id="idDespesas">Selecione</option>
					<c:forEach items="${requestScope.despesas}" var="desp">
						<option value="${desp.codigoDespesa}"<% if(td.getCodigoDespesa() == nro) { %> selected="selected"<% } ++nro; %>>${desp.tipoDespesa}</option>
					</c:forEach>
					</select>
				</label>
			</p>
			<p>
				<label for="idData">Data 
					<br /><input type="text" name="data" id="idData" value="${requestScope.id.dataDespesaReturn}" />
				</label>
			</p>
			<p>
				<label for="idValor">Valor da Despesa 
					<br /><input type="text" name="valor" id="idValor" value="${requestScope.id.valorDespesa}" />
				</label>
			</p>
			<p>
				<label for="idObs">Observações 
					<br /><textarea name="obs" id="idObs" cols="10" rows="10">${requestScope.id.observacao}</textarea>
				</label>
			</p>
			<p>
				<input type="hidden" name="nroProcesso" value="${requestScope.id.processo.nroProcesso}" />
				<input type="hidden" name="codigoLancamento" value="${requestScope.id.codigoLancamento}" />
				<input type="submit" value="Editar" class="btn btn-primary" />
			</p>
		</fieldset>
	</form>

	<script type="text/javascript" src="../../../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../../js/bootstrap.js"></script>
</body>
</html>