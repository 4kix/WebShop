<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header-bottom"><!--header-bottom-->
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<form class="input-group" action="<c:url value="/search"/>" class="search_box pull-right" method="post">
					<input name="searchValue" class="form-control" type="text" placeholder="Поиск"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<span class="input-group-btn">
					<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
					</span>
				</form>
			</div>
		</div>
	</div>
</div>