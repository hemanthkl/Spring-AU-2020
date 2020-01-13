function valid() {
	var password = document.getElementById('p').value;
	var cpassword = document.getElementById('cp').value;
	var basepassword = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[$@*])[A-Za-z$@*0-9]{8,}$/;
	var basepassword1 = /abc/;

	//alert("password is : "+password+"\nconfirm password is : "+cpassword);
	if(basepassword.test(password) && basepassword1.test(password)){

	//
	  document.getElementById('sp').innerHTML = "password valid";
	  if(password===cpassword)
	  {
	  	document.getElementById('scp').innerHTML = "password matched";

	  	alert("password is : "+password+"\nconfirm password is : "+cpassword);
	  	
	  }
	  else
	  {
	  	if(cpassword)
	  		document.getElementById('scp').innerHTML = "password notmatching";
	  }
	}
	else{
		document.getElementById('sp').innerHTML = "password invalid";
		document.getElementById('scp').innerHTML = null;	
	}

	
}
