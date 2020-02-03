<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="cover-container">
	<img src="${images}/upimg/${cover.imgCoverUrl}.jpg" alt="Snow"
		style="width: 100%; height: 400px;">
	<div class="bottom-left"></div>
	<div class="top-left"></div>
	<div class="top-right">
		<h1 style="font-size: 35px;">${registered.name}</h1>
	</div>
	<div class="bottom-right">
		<img src="${images}/upimg/${profileimg.imgProfUrl}.jpg" alt="Snow"
			style="width: 180px; height: 200px; border-radius: 2%;">
	</div>
	<div class="centered"></div>
	<div class="bottom-centered"></div>
</div>

<div class="ui grid">
	<div class="four wide column">

		<div class="custom-head">
			<h2 class="ui header">
				<i class="user icon"></i>
				<div class="content">About</div>
			</h2>
		</div>


		<div class="ui list custom-head">
<%-- 			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Category</a>
					<div class="description">${category}.</div>
				</div>
			</div> --%>
			
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Gender</a>
					<div class="description">${registered.gender}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Blood Group</a>
					<div class="description">${registered.blood_group}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Date of Birth</a>
					<div class="description">${registered.dob}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Department</a>
					<div class="description">${registered.department}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Address</a>
					<div class="description">${regDetails.address}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Hall</a>
					<div class="description">${regDetails.hall_room}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Sessiom</a>
					<div class="description">${regDetails.session}.</div>
				</div>
			</div> 
<%-- 			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Department</a>
					<div class="description">${regDetails.department}.</div>
				</div>
			</div>  --%>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Id</a>
					<div class="description">${regDetails.roll}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Graduate/UnderGraduate</a>
					<div class="description">${regDetails.graduation_program}.</div>
				</div>
			</div>
			
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Slogan</a>
					<div class="description">${regDetails.slogan}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Aim</a>
					<div class="description">${regDetails.aim}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">About</a>
					<div class="description">${regDetails.about}.</div>
				</div>
			</div>
		</div>
	</div>
	<div class="eight wide column">

<!-- 		<div class="profile-page-content">

			<div class="ui inverted segment">
				<div class="ui inverted form">
					<div class="field">
						<label>Write your post</label>
						<textarea></textarea>
					</div>
					<div class="inline field">
						<div class="ui two top attached buttons">
							<div class="ui teal button">Upload Image</div>
							<div class="ui green button">Post</div>
						</div>
					</div>

				</div>
			</div>

		</div> -->

		<c:forEach items="${postreg}" var="regPosts">
			<div class="profile-page-content">
				<div class="content-title">
					<a class="title-text" href="${contextRoot}/viewpost/${regPosts.id }/${regPosts.statusTitle }">${regPosts.statusTitle }</a>
				</div>
				<div>
					<p>
						${regPosts.status }
					</p>
					<span class="date">${regPosts.date.toString().substring(0, 10) }</span>
				</div>
				<div>
					<img src="${images}/upimg/${regPosts.imgUrl}.jpg" style="width: 100%; height: 300px;">

				</div>
			</div>
		</c:forEach>


	</div>
	<div class="four wide column">

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