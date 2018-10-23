$(document).ready(function(){
	$("#secretForm").submit(
		function(){
			var question_01 = $("#question_01").val();
			var question_02 = $("#question_02").val();
			var question_03 = $("#question_03").val();
			var answer_01 = $("#answer_01").val();
			var answer_02 = $("#answer_02").val();
			var answer_03 = $("#answer_03").val();
			if(question_01==""&&question_02==""&&question_03==""){
				$("#secretTips").html("请选择密保问题...");
				$("#secretTips").css("color","red");
				return false;
			}
			if(question_01!=""&&answer_01==""){
				$("#secretTips").html("请给第一密保输入答案");
				$("#secretTips").css("color","red");
				return false;
			}
			if(question_02!=""&&answer_02==""){
				$("#secretTips").html("请给第二密保输入答案");
				$("#secretTips").css("color","red");
				return false;
			}
			if(question_03!=""&&answer_03==""){
				$("#secretTips").html("请给第三密保输入答案");
				$("#secretTips").css("color","red");
				return false;
			}
			return true;
		}	
	)
	
	//选定密保
	for(var i=1;i<=3;i++){
		var questionValue = $("#question_1"+i).val();
		var questions = $("#question_0"+i).children();
		for(var j=0;j<questions.length;j++){
			if(questionValue==questions.eq(j).val()){
				questions.eq(j).attr("selected","true");
			}
		}
	}
	
})