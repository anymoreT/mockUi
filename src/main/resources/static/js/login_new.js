// $(function(){
     layui.use(['form' ,'layer', 'element','jquery'], function() {
         var form = layui.form;
         var layer = layui.layer;
         var $      = layui.jquery;
         form.on("submit(sub)",function () {
             login();
             return false;
         });
   })
// })

 function login(){
       data =  $("#useLogin").serialize();
       console.log("data:"+data);

     }