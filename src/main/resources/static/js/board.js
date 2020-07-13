let index = {
	init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
        });
        $("#btn-delete").on("click",()=>{
			this.deleteById();
		});
		 $("#btn-update").on("click",()=>{
			this.update();
		});
	},
	//글 등록
	save:function(){
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		};
        console.log(data)
        $.ajax({
            type:"POST",
            url:"/api/board",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert('Write Success.');
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    //글 삭제
    deleteById:function(){
        let id = $("#id").text();
        $.ajax({
            type:"DELETE",
            url:"/api/board/"+id,
            dataType:"json"
        }).done(function(resp){
            alert('Delete Success.');
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    //글 수정
	update:function(){
		let id = $("#id").val();
	
		let data = {
			title:$("#title").val(),
			content:$("#content").val()
		};
        console.log(data)
        $.ajax({
            type:"PUT",
            url:"/api/board/"+id,
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert('Update Success.');
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
}
index.init();