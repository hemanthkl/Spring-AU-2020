const usernames = ["apple09","ball&&","cat04","hemanth321","manish00","mahantesh12","kirthi01","rahul21","sandeep@"];
function li(){

	var searchinput = document.getElementById('search-input').value;
	var suggestionpanel = document.querySelector('.suggestions')
	suggestionpanel.innerHTML = " ";
	var reg = new RegExp(searchinput);
	const suggestions = usernames.filter(function(username)
	{
		if(reg.test(username))
			return username;
	});
	var suggestionpanel1 = document.querySelector('.suggestions1')
	suggestionpanel1.innerHTML = " ";
	suggestions.forEach(function(suggested){
		const div = document.createElement('div');
		div.innerHTML = suggested;
		suggestionpanel.appendChild(div);
	})
	if(searchinput === ""){
		suggestionpanel.innerHTML = " ";		
}

}

function l2(){
	//var suggestionpanel1 = document.querySelector('.suggestions1')
	//var searchinput = document.getElementById('qq').value;
	
	var sorted = usernames.sort();
	var suggestionpanel1 = document.querySelector('.suggestions1')
	suggestionpanel1.innerHTML = " ";
	sorted.forEach(function(suggested){
	const div = document.createElement('div');
	div.innerHTML = suggested;
	suggestionpanel1.appendChild(div);
	})
	
}
