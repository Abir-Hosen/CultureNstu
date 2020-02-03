<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="ui black inverted  menu">
	<a class="item" id="home" href="${contextRoot}/home"> Home </a>

	<security:authorize access="hasAuthority('Admin')">
		<a class="item" id="admin" href="${contextRoot}/admin/panel">
			Admin Panel </a>
	</security:authorize>

	<div class="right menu">
		<%-- 		<div class="item">
			<div class="ui icon input">
				<input type="text" placeholder="Search..."> 
				<i class="search link icon"></i>
			</div>
		</div>
		
		<security:authorize access="hasAnyAuthority('Registered', 'Admin')">
			<a class="item"> Messages </a> 
		</security:authorize>
		 --%>
<%-- 
		<security:authorize access="hasAuthority('Admin')"> --%>
			<a class="ui item" id="registration"
				href="${contextRoot}/registration"> New Registration Here </a>
<%-- 		</security:authorize> --%>

		<security:authorize access="isAnonymous()">
			<a class="ui item" id="registration" href="${contextRoot}/login">
				Login Here </a>
		</security:authorize>

		<security:authorize access="hasAnyAuthority('Registered','Admin')">
			<div class="ui item">
				<div class="ui dropdown">
					<a class="ui inverted button dropbtn " href="#">${registeredModel.fullname}</a>
					<div class="dropdown-content">
						<a class="ui item" id="profile"
							href="${contextRoot}/profile/id/${registeredModel.id}"
							style="color: black;"> View Profile </a> <a class="ui item"
							id="registration" href="${contextRoot}/perform-logout"
							style="color: black;"> Logout Here </a>
					</div>
				</div>
			</div>
		</security:authorize>

	</div>
</div>