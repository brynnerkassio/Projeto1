<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="../../../css/bootstrap.css" rel="stylesheet" media="screen" />
<link href="../../../css/bootstrap-responsive.css" rel="stylesheet" />
<link href="../../../css/advocacia.css" rel="stylesheet" />
<title>LCA Druida Advocacia - AM 2013</title>
</head>
<body>
	<jsp:include page="../../../menu.html" />

	<form action="/Druida/processoHonorario" method="get">
		<fieldset>
			<legend>Listar Processos por Honorários</legend>
			<p>
				<label>Número do Processo 
					<input type="text" name="nroProcesso" id="idNroProcesso" value="" />
				</label>
			</p>
			<p>
				<label>Nome do Cliente 
					<input type="text" name="nomeCliente" id="idNomeCliente" value="" />
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

	<script type="text/javascript" src="../../../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../../js/bootstrap.js"></script>
</body>
</html>