$("#queryTypeCode").change(function(){
   var queryTypeCode=$("#queryTypeCode").val();
   // alert(queryTypeCode);
   if(queryTypeCode!=''&&queryTypeCode!=null){
       $.ajax({
          type:"GET",
          url:"/data/disolvetype",
          data:{"typeCode":queryTypeCode},
          dataType:"json",
          success:function(data){
              $("#queryValueId").html("");
              var options="<option value=\"\">--请选择--</option>"
              for(var i=0;i<data.length;i++){
                  options+="<option value=\""+data[i].valueId+"\">"+data[i].valueName+"</option>";
              }
              $("#queryValueId").html(options);
          },
           error:function(data){
              alert("加载数据分类失败！");
           }
       });
   }else{
       $("#queryValueId").html("");
       var options = "<option value=\"\">--请选择--</option>";
       $("#queryValueId").html(options);
   }
});
$("#adddata").click(function () {
    window.location.href("/add");
});