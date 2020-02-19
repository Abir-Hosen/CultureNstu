<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="margin: 150px; color: green;">
	<h1>Registration Here</h1>
	<c:if test="${not empty message}">
		<div class="ui container">
			<div class="content message">
				<p>Note:&nbsp;${message}</p>
			</div>
		</div>
	</c:if>

	<sf:form class="ui form" modelAttribute="register"
		action="${contextRoot}/registration" method="POST">
		<sf:hidden path="id" />
		<sf:hidden path="enabled" value="false" />
		<sf:hidden path="role" value="Registered" />
		<sf:hidden path="category" value="1" />
		<div class="ui two fields">
			<div class="field">
				<label>Full Name</label>
				<sf:input type="text" placeholder="Enter your Name" name="name"
					path="name" id="name" />
				<sf:errors path="name" cssClass="error" element="em" />
			</div>
			<div class="field">
				<label>Email</label>
				<sf:input type="text" placeholder="Enter your email" name="email"
					path="email" id="email" />
				<sf:errors path="email" cssClass="error" element="em" />
			</div>
		</div>
		<div class="ui two fields">
			<div class="field">
				<label>Gender</label>
				<sf:select class="ui fluid search dropdown" name="gender" path="gender"
					id="gender">
					<option value="Male">Male</option>
					<option value="Female">Female</option>
				</sf:select>
				<sf:errors path="gender" cssClass="error" element="em" />
			</div>
			<div class="field">
				<label>Blood Group</label>
				<sf:select class="ui fluid search dropdown" name="blood_group" path="blood_group"
					id="blood_group">
					<option value="A+">A Positive</option>
					<option value="A-">A Negative</option>
					<option value="B+">B Positive</option>
					<option value="B-">B Negative</option>
					<option value="O+">O Positive</option>
					<option value="O-">O Negative</option>
					<option value="AB+">AB Positive</option>
					<option value="AB-">AB Negative</option>
				</sf:select>
				<sf:errors path="blood_group" cssClass="error" element="em" />
			</div>
		</div>
		<div class="ui two fields">
			<div class="field">
				<label>Department</label>
				<sf:input type="text" placeholder="Enter your Name" name="department"
					path="department" id="department" />
				<sf:errors path="department" cssClass="error" element="em" />
			</div>
			<div class="field">
				<label>Birth Date</label>
				<sf:input type="date" name="dob" path="dob" id="dob"/>
				<sf:errors path="blood_group" cssClass="error" element="em" />
			</div>
		</div>
		<div class="ui three fields">
			<div class="field">
				<label>Password</label>
				<sf:input type="password" placeholder="Enter your password"
					name="password" path="password" id="password" />
				<sf:errors path="password" cssClass="error" element="em" />
			</div>
			<div class="field">
				<label>Confirm Password</label>
				<sf:input type="password" placeholder="Reenter your password"
					name="confirmPassword" path="confirmPassword" id="confirmPassword" />
				<sf:errors path="confirmPassword" cssClass="error" element="em" />
			</div>
			<%-- 	<div class="field">
		<label id="category">Category</label>
		<sf:select class="ui dropdown" id="category" path="category"
			items="${categories }"
			itemLabel="name"
			itemValue="id"
		/>
	</div> --%>
		</div>
		<button class="ui fluid inverted green button" type="submit">Submit</button>
	</sf:form>
</div>