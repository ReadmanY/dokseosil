

const loginForm=document.forms.loginForm;
const user_id_input = loginForm["user_id"]
const user_pw_input = loginForm["user_pw"]

const idPopOver = new bootstrap.Popover(user_id_input,{ trigger: 'manual', content:'4자리 이상의 ID를 입력해 주세요!'});
const pwPopOver = new bootstrap.Popover(user_pw_input,{ trigger: 'manual', content:'비밀번호를 입력해주세요!'});


loginForm.addEventListener("submit",(e)=>{
	e.preventDefault();
	let validation=true;
	
		
	if(user_id_input.value=="" || user_id_input.value.length<4){
		user_id_input.classList.add('input-error');
		idPopOver.show();
		validation=false;
	}
	
	if(user_pw_input.value==""){
		user_pw_input.classList.add('input-error');
		pwPopOver.show();
		validation=false;
	}
	
	if(validation==true){
		e.target.submit();
	}

});

user_id_input.addEventListener("input",e=>{
	if(e.target.value.length>3){
		e.target.classList.remove('input-error');
		idPopOver.hide();
	}
});
	
user_pw_input.addEventListener("input",e=>{
	e.target.classList.remove('input-error');
	pwPopOver.hide();
});
