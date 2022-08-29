/**
 * 
 */
 
 let signUpForm = document.forms.signUpForm;
 
 let requireInputs = document.querySelectorAll(".required .form-control");
 let pwInput = document.getElementById("userPw");
 let PW_REGEX=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{6,}$/;
 let EMAIL_REGEX=/^[a-zA-Z0-9.! #$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\. [a-zA-Z0-9-]+)*$/
 
 

 signUpForm.addEventListener("submit",async e=>{
	e.preventDefault();
	
	let validation=true;
	let id_val=false;
	let pw_val=false;
	let pw_confirm_val=false
	let email_val=false;
	for(input of requireInputs){
		if(input.value==""){
			noAjaxValidation(input,(input)=>{return input.value!=""}, "필수항목은 비워둘 수 없습니다.")
			validation=false;
		}else {
			
			if(input.name=="user_id"){
				preValidation=noAjaxValidation(input,(input)=>{return input.value.length>3},"최소한 4자리 이상이어야 합니다.");
				
				if(preValidation){
					nextValidation = await ajaxValidation(input,"/user/idAjax/"+input.value,"중복된 아이디가 존재합니다")
					if(nextValidation){
						id_val=true;
					}else{
						id_val=false;
					}
				}
			}
//			else if(input.name=="user_pw"){
//				preValidation=noAjaxValidation(input,()=>{return PW_REGEX.test(input.value)},"6자리 이상, 숫자와 문자와 특수문자를 각각 한개 이상 포함해야 합니다");
//				pw_val=false;
//			}else if(input.id=="userPw_confirm" && PW_REGEX.test(pwInput.value)){
//				preValidation=noAjaxValidation(input,()=>{return input.value==pwInput.value},"비밀번호와 확인이 서로 다릅니다.");
//				pw_confirm_val=false;
//			}else if(input.name=="user_email"){
//				preValidation=noAjaxValidation(input,()=>{return EMAIL_REGEX.test(input.value)}, "정확한 이메일 형식이 아닙니다.");
//				email_val=false;
//			}	
		}
	}
	
//	if (validation==true){
//		e.target.submit();
//	}
});

function noAjaxValidation(inputElement, valRequire ,invalidMsg){
	//if invalidated
	if (!valRequire(inputElement)){
		inputElement.classList.add("input-validation-error");
		
		
		let popover=bootstrap.Popover.getInstance(inputElement);
		if(popover==null){
			popover=new bootstrap.Popover(inputElement,{content:invalidMsg,trigger: 'manual'});
		}
		
		if(!popover._isShown()){
			popover.show();
		}
		
		inputElement.addEventListener("change", e=>{
			console.log("test empty -> change"+valRequire(inputElement))
			if(valRequire(inputElement)){
				e.target.classList.remove("input-validation-error");
				popover.hide();
			}
		});
		
		return false;
	}else{
		return true;
	}
}

async function ajaxValidation(inputElement, controllerPath, invalidMsg){
	
	console.log(await ajax(controllerPath));
	return noAjaxValidation(inputElement, async ()=>{return await ajax(controllerPath)}, invalidMsg);
}

async function ajax(controllerPath){
		let res=await fetch(controllerPath);
		let resJson=await res.json();
		console.log(resJson);
		return resJson.canIUse
}