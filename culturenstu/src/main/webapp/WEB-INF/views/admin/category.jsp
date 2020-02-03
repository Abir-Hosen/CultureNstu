<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty message}">	
<div class="ui container">
	<div class="content message">
		<p>Note:&nbsp;${message}</p>
	</div>
</div>
</c:if>

<sf:form class="ui form" modelAttribute="category" action="${contextRoot}/admin/panel/category" method="POST">
	<sf:hidden path="id"/>
	<div class="field">
		<label>Category Name</label> 
		<sf:input type="text" placeholder="Category Name" name="name" path="name" id="name"/>
		<sf:errors path="name" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Category Description</label>
		<sf:textarea placeholder="Enter your category description within thousends letter..." 
		name="description" path="description" id="description"></sf:textarea>
		<sf:errors path="description" cssClass="error" element="em"/>
	</div>
	<button class="ui fluid secondary inverted button" type="submit">Submit</button>
</sf:form>

<div class="data-table">
	<table class="ui inverted grey table">
		<thead>
			<tr>
				<th class="three wide">Name</th>
				<th class="ten wide">Description</th>
				<th class="two wide"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="cat">
				<tr>
					<td><h3>${cat.name}</h3></td>
					<td>${cat.description}</td>
					<td class="selectable">
					<a href="${contextRoot}/admin/panel/${cat.id}/${cat.name}/category" class="ui custom fluid inverted secondary button">
					Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th class="three wide">Name</th>
				<th class="ten wide">Description</th>
				<th class="two wide"></th>
			</tr>
		</tfoot>
	</table>
</div>