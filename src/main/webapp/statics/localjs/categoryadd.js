$("#back").on("click",function(){
    window.location.href = "list";
});
$("#level").change(function(){
    var level=$("#level").val();
    $.ajax({
        type:"get",
        url:"/appcategory/disolvelevel",
        data:{"level":level},
        dataType:"json",
        success:function(data){
            $("#parentId").html("");
            if(data.length==0){
                var options="<option value=''>根类型</option>";
            }else{
                var options="<option value='0'>--请选择--</option>";
                for(var i=0;i<data.length;i++){
                    options+="<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
            }
            $("#parentId").html(options);
        }
    });
});