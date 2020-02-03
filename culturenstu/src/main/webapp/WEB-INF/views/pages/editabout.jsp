<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: 20px 30px 20px 30px; ">
<c:if test="${not empty message}">	
<div class="ui container">
	<div class="content message">
		<p>Note:&nbsp;${message}</p>
	</div>
</div>
</c:if>

<sf:form class="ui form" modelAttribute="about" action="${contextRoot}/${registeredModel.fullname}/edit/${registeredModel.id}/about" method="POST">
	<div class="field">
		<label>Slogan</label>
		<sf:textarea rows="2" placeholder="Enter your slogan" path="slogan" id="slogan" name="slogan"></sf:textarea>
		<sf:errors path="slogan" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Aim</label>
		<sf:textarea rows="3" placeholder="Enter your aim" path="aim" id="aim" name="aim"></sf:textarea>
		<sf:errors path="aim" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Address</label>
		<sf:textarea rows="3" placeholder="Enter your address" path="address" id="address" name="address"></sf:textarea>
		<sf:errors path="address" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Hall And Room</label>
		<sf:textarea rows="1" placeholder="Enter your hall-room" path="hall_room" id="hall_room" name="hall_room"></sf:textarea>
		<sf:errors path="hall_room" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Session</label>
		<sf:textarea rows="1" placeholder="Enter your session(2014-15)" path="session" id="session" name="session"></sf:textarea>
		<sf:errors path="session" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Department</label>
		<sf:textarea rows="1" placeholder="Enter your department" path="department" id="department" name="department"></sf:textarea>
		<sf:errors path="department" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Roll Id</label>
		<sf:textarea rows="1" placeholder="Enter your roll-id" path="roll" id="roll" name="roll"></sf:textarea>
		<sf:errors path="roll" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>Graduation Program</label>
		<sf:textarea rows="1" placeholder="Enter your running graduation program" path="graduation_program" id="graduation_program" name="graduation_program"></sf:textarea>
		<sf:errors path="graduation_program" cssClass="error" element="em"/>
	</div>
	<div class="field">
		<label>About</label>
		<sf:textarea placeholder="Enter about you" path="about" id="about" name="about"></sf:textarea>
		<sf:errors path="about" cssClass="error" element="em"/>
	</div>
	<sf:hidden path="reg_id" value="${registeredModel.id}"/>
	<sf:hidden path="id"/>
	<button class="ui fluid secondary inverted button" type="submit">Submit</button>
</sf:form><br>
</div>