<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<div class="col-sm-3">
		<div class="left-sidebar">
			<h2>Разделы</h2>
			<div class="panel-group category-products" id="accordian">
				<!--type Products-->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a href="/index">Все товары</a>
						</h4>
					</div>
				</div>
				<c:forEach items="${types}" var="type">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a href="<c:url value="/type/${type.idOfType}"/>">${type.nameOfType}</a>
							</h4>
						</div>
					</div>
				</c:forEach>
			</div>
			<!--/type Products-->

			<div class="brands_products">
				<!--country Products-->
				<h2>Производители</h2>
				<div class="brands-name">
					<ul class="nav nav-pills nav-stacked">
						<c:forEach items="${countries}" var="country">
							<li>
								<a href="<c:url value="/country/${country.idOfCountry}"/>">${country.nameOfCountry}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--/country Products-->
		</div>
	</div>