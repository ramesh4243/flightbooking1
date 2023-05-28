<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Reservation Details</title>
</head>
<body>
     <h2>Flight Details</h2>
     <hr>
     Flight Number :${flight.flightNumber}<br>
     Operating Airlines :${flight.operatingAirlines}<br>
     Departure City :${flight.departureCity}<br>
     Arrival City :${flight.arrivalCity}<br>
     Date Of Departure :${flight.dateOfDeparture}<br>
     
     <h2>Enter Passenger Details</h2>
     <form action="completeReservation" method="post">
     <hr>
     <pre>
     First Name<input type="text" name="firstName"/>
     Middle Name<input type="text" name="middleName"/>
     Last Name<input type="text" name="lastName"/>
     Email<input type="text" name="email"/>
     Phone<input type="text" name="phone"/>
     <input type="hidden" name="flightId" value="${flight.id}"/>
     </pre>
     
    
     <h2>Enter Payment Details</h2>
     <hr>
     Card Holder Name:<input type="text" name="cardHolderName"/>
     Card Number<input type="text" name="cardNumber"/>
     CVV<input type="text" name="cvv"/>
     Expire Date<input type="text" name="expiryDate"/><br>
     <input type="Submit" value="complete reservation"/>
     
    </form>
     
    
     
</body>
</html>