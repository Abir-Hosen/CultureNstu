<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<div class="slideshow-container">

	<div class="mySlides fade">
		<div class="numbertext">1 / 3</div>
		<img src="${images}/slide/1.png" style="width: 100%; height: 400px; border-radius: 2%;font-style: italic;">
		<h2 class="text" style="font-size: 40px; font-style: bold; padding-bottom: 1%; font-family: sans-serif;font-style: italic;">NSTU Culture Club</h2>
	</div>

	<div class="mySlides fade">
		<div class="numbertext">2 / 3</div>
		<img src="${images}/slide/2.jpg" style="width: 100%; height: 400px; border-radius: 2%;">
		<h2 class="text" style="font-size: 40px; font-style: bold; padding-bottom: 1%; font-family: sans-serif;font-style: italic;">NSTU Culture Club</h2>
	</div>

	<div class="mySlides fade">
		<div class="numbertext">3 / 3</div>
		<img src="${images}/slide/3.jpg" style="width: 100%; height: 400px; border-radius: 2%;">
		<h2 class="text" style="font-size: 40px; font-style: bold; padding-bottom: 1%; font-family: sans-serif;font-style: italic;">NSTU Culture Club</h2>
	</div>

</div>
<br>

<div style="text-align: center">
	<span class="dot"></span> <span class="dot"></span> <span class="dot"></span>
</div>




<div class="ui grid">

	<div class="ten wide column">
		<security:authorize access="hasAnyAuthority('Registered','Admin')">
			<div class="home-page-content">
				<div class="ui inverted segment">

					<sf:form class="ui inverted form" modelAttribute="statusPost"
						action="${contextRoot}/profile/id/${registeredModel.id}"
						method="POST" enctype="multipart/form-data">

						<sf:hidden path="id" />
						<sf:hidden path="regId" value="${registeredModel.id}" />
						<sf:hidden path="react" value="0" />
						<sf:hidden path="seen" value="0" />
						<sf:hidden path="imgUrl" />
						<sf:hidden path="visible" value="true" />
						<sf:hidden path="date" />
						<sf:hidden path="statusTitle" />

						<div class="field">
							<label>Write your post</label>
							<div class="content message">
								<p>${message}</p>
							</div>

							<sf:textarea type="text" placeholder="Write status"
								name="statusTitle" path="statusTitle" id="statusTitle" rows="2"></sf:textarea>
							<sf:errors path="statusTitle" cssClass="error" element="em" />
						</div>

						<div class="field">
							<sf:textarea type="text" placeholder="Write status" name="status"
								path="status" id="status"></sf:textarea>
							<sf:errors path="status" cssClass="error" element="em" />
						</div>

						<div class="field">
							<sf:input type="file" placeholder="upload image" path="file"
								name="file"></sf:input>
							<sf:errors path="status" cssClass="error" element="em" />
						</div>

						<button class="ui green fluid button" type="submit">Post</button>

					</sf:form>
				</div>
			</div>
		</security:authorize>

		<c:forEach items="${allpost}" var="allpost">
			<div class="home-page-content">
				<div class="content-title">
					<a class="title-text"
						href="${contextRoot}/viewpost/${allpost.id }/${allpost.statusTitle }">${allpost.statusTitle}</a>
				</div>
				<div>
					<p>${allpost.status}</p>
					<span class="date">${allpost.date.toString().substring(0, 10) }</span>
				</div>
				<div>
					<img src="${images}/upimg/${allpost.imgUrl}.jpg"
						style="width: 100%; height: 300px;">

				</div>
			</div>
		</c:forEach>
	</div>

	<div class="six wide column">
		<div class="home-page-content">
			<div class="content-title">
				<span class="title-text">Cultural Club Members</span>
			</div>
			<div class="ui relaxed divided list">
				<c:forEach items="${registeredlist}" var="reg">
				<c:if test="${reg.enabled==true }">
					<div class="item">
						<i class="large object group outline middle aligned icon"></i>
						<div class="content">
							<a class="header" href="${contextRoot}/profile/${reg.id}/visit">${reg.name}</a>
							<div class="description">${reg.email}</div>
							<div class="description">${reg.role}</div>
						</div>
					</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>

</div>