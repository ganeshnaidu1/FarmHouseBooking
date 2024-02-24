<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${message}
  <form action="create" method="post">
    <label for="location">Location:</label>
    <input type="text" id="location" name="location">

    <label for="mobileNo">Mobile No:</label>
    <input type="text" id="mobileNo" name="mobileNo">

    <label for="noOfBeds">No. of Beds:</label>
    <input type="number" id="noOfBeds" name="noOfBeds">

    <label for="price">Price:</label>
    <input type="number" id="price" name="price">

    <input type="submit" value="Register Property">
  </form>
</body>
</html>