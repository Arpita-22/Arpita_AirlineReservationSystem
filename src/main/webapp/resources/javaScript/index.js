const signUpForm = document.querySelector('.signUpForm');
const login = document.querySelector('.loginForm');
const searchForm = document.querySelector('.searchForm');

let userName = ["apple", "orange", "banana", "grapes", "cherry", "strawberry"];




if (signUpForm !== null) {
	signUpForm.addEventListener("submit",
		function(e) {
			e.preventDefault();

			document.querySelector('#signUp-h1').innerHTML = "Thank you for signing up " + username.value + "!";
		});
}
else if (login !== null) {
	login.addEventListener("submit",
		function(e) {
			e.preventDefault();

			for (let i = 0; i < userName.length; i++) {
				if (userName[i] === user.value.toLowerCase()) {
					document.querySelector('#loginForm-h1').innerHTML = `Welcome ${userName[i]}!`;
					break;
				} else {
					document.querySelector('#loginForm-h1').innerHTML = "Invalid username or password";
				}

			}
		});

}
else if (searchForm !== null) {
	searchForm.addEventListener("submit",
		function(e) {
			e.preventDefault();
			console.log(e.target[0].value);
			console.log(e.target[1].value);
			document.querySelector('p').innerHTML = "Leaving From " + e.target[0].value + " Going To " + e.target[1].value;

		});

}


