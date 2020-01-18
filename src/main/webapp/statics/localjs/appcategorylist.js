$("#queryCategoryLevel1").change(function () {
    var cid=$("#queryCategoryLevel1").val();
    if(cid!=''&&cid!=null){
        $.ajax({
            type:"get",
            url:"/appcategory/disolvelevel1",
            data:{"cid":cid},
            dataType:"json",
            success:function(data){
                $("#queryCategoryLevel2").html("");
                var options="<option value=\"\">--请选择--</option>";
                var length=data.length;
                for(var i=0;i<data.length;i++){
                    options+="<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#queryCategoryLevel2").html(options);
            }
        })
    }else{
        alert("二级分类加载失败");
    }
});
$("#queryCategoryLevel2").change(function () {
    var cid=$("#queryCategoryLevel2").val();
    if(cid!=''&&cid!=null){
        $.ajax({
            type:"get",
            url:"/appcategory/disolvelevel1",
            data:{"cid":cid},
            dataType:"json",
            success:function(data){
                $("#queryCategoryLevel3").html("");
                var options="<option value=\"\">--请选择--</option>";
                var length=data.length;
                for(var i=0;i<data.length;i++){
                    options+="<option value=\""+data[i].id+"\">"+data[i].categoryName+"</option>";
                }
                $("#queryCategoryLevel3").html(options);
            }
        })
    }else{
        alert("三级分类加载失败");
    }
});