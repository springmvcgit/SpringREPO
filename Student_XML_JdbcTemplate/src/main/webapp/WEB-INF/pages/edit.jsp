<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div >
      <a href="home.htm">Home</a> &nbsp;&nbsp;&nbsp;&nbsp;
      <a href="contact.htm">Contact_us</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="about.htm">About_us</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="help.htm">Help</a>&nbsp;&nbsp;&nbsp;&nbsp;
   </div> 
    
 <div>
   <h1 style="color:red;text-align:center">Update Here</h1>
</div>
<div>
<form:form commandName="stuCmd">
<table align="center">

<tr><td>ID:</td><td><form:input path="id" disabled="true"/></td></tr><br>
<tr><td>Name:</td><td><form:input path="SNAME"/></td></tr><br>
<tr><td>ADDRESS:</td><td><form:input path="SADDRESS"/></td></tr><br>
<tr><td>COURSE:</td><td><form:input path="COURSE"/></td></tr><br>
<tr><td>MOBILE:</td><td><form:input path="MOBILE"/></td></tr><br>
<tr><td>FEES:</td><td><form:input path="FEES"/></td></tr><br>
<tr><td><input type="submit" value="update"></td></tr><br>


</table> 
</form:form> 

</div>


