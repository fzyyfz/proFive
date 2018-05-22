$(function(){
	
	var addInfo = new Object();
	
	addInfo.loadMas = function(){
		$.get("AddInformationServlet",function(data){
			if(data[0].uhead!=null){
				
				$("#infoHead")[0].src = data[0].uhead;
			}
			
		},"json");
	}
	addInfo.loadMas();
	
})