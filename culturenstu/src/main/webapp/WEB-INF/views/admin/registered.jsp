<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2 class="ui icon header">
	<i class="settings icon"></i>
	<div class="content">
		Registered Management
		<div class="sub header">View registered account and information.</div>
	</div>
</h2>

<c:if test="${not empty message}">
	<div class="ui container">
		<div class="content message">
			<p>Note:&nbsp;${message}</p>
		</div>
	</div>
</c:if>

<div class="data-table">
	<table class="ui inverted grey table">
		<thead>
			<tr>
				<th class="three wide">Name</th>
				<th class="seven wide">About</th>
				<th class="two wide"></th>
				<th class="one wide"></th>
				<th class="two wide"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registered}" var="registered">
				<tr>
					<td><a style="font-size: 20px; color: white;"
						href="${contextRoot}/profile/${registered.id}/visit">
							${registered.name}</a></td>
					<td>Role: ${registered.role}<br>Email:
						${registered.email}<br>Department: ${registered.department}<br>
						Date of Birth: ${registered.dob}<br> <c:if
							test="${registered.enabled == true}">
						Member Verification Status: <span style="color: #b2ed9a;">
								Verified</span><br>
						</c:if> <c:if test="${registered.enabled == false}">
						Member Verification Status: <span style="color: #ebb48d;">Not
								Verified</span>
							<br>
						</c:if>


					</td>
					<td class="selectable"><a
						href="${contextRoot}/admin/panel/${registered.id}/${registered.name}/make/admin/registered"
						class="ui  fluid inverted secondary button"> Make Admin</a>
						<br> <a
						href="${contextRoot}/admin/panel/${registered.id}/${registered.name}/make/member/registered"
						class="ui  fluid inverted secondary basic button"> Make Member</a></td>

					<td class="selectable"></td>

					<td class="selectable"><a
						href="${contextRoot}/admin/panel/${registered.id}/${registered.name}/registered"
						class="ui  fluid inverted secondary basic button"> Delete
							Account</a> 
							
							<br>
							
						<c:if test="${registered.enabled == false}">
							<a href="${contextRoot}/admin/panel/${registered.id}/${registered.name}/make/active/registered"
							class="ui fluid inverted violet  button"> Set Verified</a>
						</c:if> 
						
						<c:if test="${registered.enabled == true}">
							<a href="${contextRoot}/admin/panel/${registered.id}/${registered.name}/make/deactive/registered"
							class="ui  fluid inverted olive button"> Set Unverified</a>
						</c:if> 
							
							</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th class="three wide">Name</th>
				<th class="seven wide">About</th>
				<th class="two wide"></th>
				<th class="one wide"></th>
				<th class="two wide"></th>
			</tr>
		</tfoot>
	</table>
</div>