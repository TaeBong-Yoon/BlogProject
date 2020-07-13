let index = {
	init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-update").on("click",()=>{
			this.update();
		});
	},
	//회원가입 수행 요청
	save:function(){
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
        console.log(data)
        $.ajax({
            type:"POST",
            url:"/auth/joinProc",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert('Sign Up Success.');
            console.log(resp);
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    //회원정보 수정
    update:function(){
		let data = {
            id: $("#id").val(),
            username: $("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
        console.log(data)
        $.ajax({
            type:"PUT",
            url:"/user",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert('Update Success.');
            console.log(resp);
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();