/**
 * 
 */
 
 
signUpForm.addEventListener("change",async ()=>{ await totalValidation();});

signUpForm.addEventListener("submit",async e=>{
	e.preventDefault();
 
	result= await totalValidation();
	
	if (result){
		e.target.submit();
	}
});


async function totalValidation(){
	let requireInputs = document.querySelectorAll(".required .form-control");
	console.log(requireInputs);
	let pwInput = document.getElementById("userPw");
	let PW_REGEX=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,}$/;
	let EMAIL_REGEX=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
	
	let id_val;
	let pw_val;
	let pw_confirm_val;
	let email_val;
	
	for(input of requireInputs){
		if(input.value==""){
			input.classList.add("input-validation-error");
			popOver(input, "필수항목은 비워둘 수 없습니다");
			total=false;
		}else {
			if(input.name=="user_id"){
				id_val=process(input,"최소한 4자리 이상이어야 합니다.", ()=>{return input.value.length>3});
				if(id_val){
					id_val=process(input,"중복되는 아이디가 있습니다", async ()=>{return await ajax("/user/idAjax/"+input.value)});
				}
			}
			else if(input.name=="user_pw"){
				pw_val=process(input,"6자리 이상, 숫자와 문자와 특수문자를 각각 한개 이상 포함해야 합니다", ()=>{return PW_REGEX.test(input.value)});
			}else if(input.id=="userPw_confirm" && PW_REGEX.test(pwInput.value)){
				pw_confirm_val=process(input,"비밀번호와 확인이 서로 다릅니다.", ()=>{return input.value==pwInput.value});
			}else if(input.name=="user_email"){
				email_val=process(input, "정확한 이메일 형식이 아닙니다.", ()=>{return EMAIL_REGEX.test(input.value)});
			}	
		}
	}
	console.log("id_val="+id_val+" pw_val="+pw_val+" pw_confirm_val="+pw_confirm_val+" email_val="+email_val);
	
	total=id_val&&pw_val&&pw_confirm_val&&email_val;
	
	return total;
}


function popOver(input,msg){
			popover=bootstrap.Popover.getInstance(input);
			if(popover){
				popover.dispose();
			}
			popover=new bootstrap.Popover(input,{content:msg,trigger: 'manual'});
			popover.show();
}

function process(input, msg, condition){
	
	if(condition()){
		valResult=true;
		input.classList.remove("input-validation-error");
		input.classList.add("passValidation");
		popover=bootstrap.Popover.getInstance(input)
		if(popover&&popover._isShown){
			popover.hide();
		}
	}else{
		valResult=false
		popOver(input,msg);
		input.classList.remove("passValidation");
		input.classList.add("input-validation-error");
	}
	
	return valResult;
				
}

async function ajax(controllerPath){
		console.log(controllerPath);
		let res=await fetch(controllerPath);
		let resJson=await res.json();
		return resJson.canIUse;
}


