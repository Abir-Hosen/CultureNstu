<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="cover-container">
	<img src="${images}/upimg/${coverimg.imgCoverUrl }.jpg" alt="Snow"
		style="width: 100%; height: 400px;">
	<div class="bottom-left"></div>
	<div class="top-left"></div>
	<div class="top-right">
		<h1 style="font-size: 35px;">${registeredModel.fullname}</h1>
	</div>
	<div class="bottom-right">
		<img src="${images}/upimg/${profileimg.imgProfUrl }.jpg" alt="Snow"
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
					<div class="description">${registeredModel.catName}.</div>
				</div>
			</div> --%>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Gender</a>
					<div class="description">${registeredModel.gender}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Blood Group</a>
					<div class="description">${registeredModel.blood_group}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Date of Birth</a>
					<div class="description">${registeredModel.dob}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Department</a>
					<div class="description">${registeredModel.department}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Address</a>
					<div class="description">${registeredModel.adress}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Hall</a>
					<div class="description">${regDet.hall_room}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Sessiom</a>
					<div class="description">${regDet.session}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Slogan</a>
					<div class="description">${regDet.slogan}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Aim</a>
					<div class="description">${regDet.aim}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">About</a>
					<div class="description">${regDet.about}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Id</a>
					<div class="description">${regDet.roll}.</div>
				</div>
			</div>
			<div class="item">
				<i class="map marker icon"></i>
				<div class="content">
					<a class="header">Graduate/UnderGraduate</a>
					<div class="description">${regDet.graduation_program}.</div>
				</div>
			</div>
		</div>
		<a class="ui secondary inverted fluid button"
			href="${contextRoot}/${registeredModel.fullname}/edit/${registeredModel.id}/about">Edit</a>
		<br>

		<div class="custom-head" style="margin: 15px 0px 10px 0px;">
			<h2 class="ui header">
				<i class="braille icon"></i>
				<div class="content">Change Images</div>
			</h2>
		</div>

		<sf:form class="ui inverted form" modelAttribute="coverimg"
			action="${contextRoot}/change/cover/profile/id/${registeredModel.id}"
			method="POST" enctype="multipart/form-data">

			<sf:hidden path="id" />
			<sf:hidden path="reg_id" value="${registeredModel.id}" />
			<sf:hidden path="active" value="true" />
			<sf:hidden path="description" />
			<sf:hidden path="imgCoverUrl" />


			<div class="field">
				<sf:input type="file" placeholder="upload image" path="file"
					name="file"></sf:input>
			</div>

			<button class="ui secondary inverted fluid button" type="submit">Change
				Cover Image</button>

		</sf:form>

		<sf:form class="ui inverted form" modelAttribute="profileimg"
			action="${contextRoot}/change/profpic/profile/id/${registeredModel.id}"
			method="POST" enctype="multipart/form-data">

			<sf:hidden path="id" />
			<sf:hidden path="reg_id" value="${registeredModel.id}" />
			<sf:hidden path="active" value="true" />
			<sf:hidden path="description" />
			<sf:hidden path="imgProfUrl" />

			<div class="field">
				<sf:input type="file" placeholder="upload image" path="file"
					name="file"></sf:input>
			</div>

			<button class="ui secondary inverted fluid button" type="submit">Change
				Profile Image</button>

		</sf:form>

	</div>
	<div class="eight wide column">

		<div class="profile-page-content">

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

					<div class="field">
						<label>Write your post</label>
						<div class="content message">
							<p>${message}</p>
						</div>

						<sf:textarea type="text" placeholder="Write Title"
							name="statusTitle" path="statusTitle" id="statusTitle" rows="2" />
						<sf:errors path="statusTitle" cssClass="error" element="em" />
					</div>

					<div class="field">
						<sf:textarea type="text" placeholder="Write Description"
							name="status" path="status" id="status" />
						<sf:errors path="status" cssClass="error" element="em" />
					</div>

					<div class="field">
						<sf:input type="file" placeholder="upload image" path="file"
							name="file"></sf:input>
					</div>

					<button class="ui green fluid button" type="submit">Post</button>

				</sf:form>
			</div>
		</div>

		<c:forEach items="${regPosts}" var="regPosts">
			<div class="profile-page-content">

				<div class="content-title">
					<a class="title-text" href="${contextRoot}/viewpost/${regPosts.id }/${regPosts.statusTitle }">${regPosts.statusTitle }</a>
				</div>
				<div class="ui right floated small basic icon buttons">
					<a class="ui button" href="${contextRoot}/edit/${regPosts.id }/regId/${regPosts.regId}">
						<i class="edit icon"></i>
					</a>
					<a class="ui button" href="${contextRoot}/delete/${regPosts.id}/regId/${regPosts.regId}">
						<i class="delete icon"></i>
					</a>
				</div>
				<div>
					<p>${regPosts.status }</p>
					<span class="date">${regPosts.date.toString().substring(0, 10) }</span>
				</div>
				<div>
					<img src="${images}/upimg/${regPosts.imgUrl }.jpg"
						style="width: 100%; height: 300px;">

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
							<a class="header"
								href="${contextRoot}/viewpost/${allpost.id }/${allpost.statusTitle }">${allpost.statusTitle}</a>
							About the recent event news.
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