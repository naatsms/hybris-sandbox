<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/desktop/common" %>

<template:page pageTitle="${pageTitle}">

	<cms:pageSlot position="BodySection1" var="feature" element="div" class="col-sm-4">
		<cms:component component="${feature}" element="div" class="section1"/>
	</cms:pageSlot>

	<cms:pageSlot position="BodySection2" var="feature" element="div" class="col-sm-8">
		<cms:component component="${feature}" element="div" class="section2"/>
	</cms:pageSlot>

	<cms:globalSlot uid="BottomContentSlot" var="feature" limit="1" element="div" class="row">
		<cms:component component="${feature}" class="bottom"/>
	</cms:globalSlot>

</template:page>