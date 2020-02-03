<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="ui grid">
	
	<div class="ten wide column">

			<div class="profile-page-content">
				<div class="content-title">
					<a class="title-text" href="${contextRoot}/#">${post.statusTitle }</a>
				</div>
				<span class="date">${post.date.toString().substring(0, 10) }</span>
				<div>
					<img src="${images}/upimg/${post.imgUrl}.jpg" style="width: 100%; height: 300px;">
				</div>
				<div>
					<p>
						${post.status }
					</p>
				</div>
			</div>


	</div>
	<div class="six wide column">

		<div class="ui inverted segment">
			<div class="ui inverted relaxed divided list">
			
				<c:forEach items="${allpost}" var="allpost">
					<div class="item">
						<div class="content">
							<a class="header" href="${contextRoot}/viewpost/${allpost.id }/${allpost.statusTitle }">${allpost.statusTitle}</a> About the
							recent event news.
						</div>
					</div>
				</c:forEach>
				
				<div class="item">
					<div class="content">
						<a class="header" href="#">Recent Event News</a> About the recent
						event news.
					</div>
				</div>
			</div>
		</div>

	</div>
</div>