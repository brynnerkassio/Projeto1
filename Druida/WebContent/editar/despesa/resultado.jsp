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
<title>Editar Despesa</title>
</head>
<body>

	<jsp:include page="../../menu.html" />
	
	<p>
		${requestScope.mensagem}
	</p>
	<script type="text/javascript" src="../../../js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="../../../js/bootstrap.js"></script>
</body>
</html>