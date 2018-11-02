$.extend({
		/**
		 * 密码等级
		 * 定义计数器score
		 * 长度<=6 +1
		 * 6<长度<=10  +1
		 * 10<长度<=16 +1
		 * 有小写 +1
		 * 有数字 +1
		 * 有大写 +1
		 * 
		 * score<=3 低
		 * socre 4 5 中
		 * score 6 高
		 * 
		 */
	passwordStrength:function(){
		var password = $("#newPassword").val();
		var password_prompt = $("#newPW_prompt");
		$("#newPW_prompt").html("");
		//先判断密码输入是否正确：只能包含数字、大小写字母
		var reg = /^[0-9a-zA-Z]{1,}$/;
		if(reg.test(password)==false){
			password_prompt.html("密码格式不对，由6-15位数字与字母组合，区分大小写");
			password_prompt.attr("class","error_prompt");
			return false;
		}
		else{
			$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_01.jpg");
			$(".strenght_M").children().attr("src","../images/proscenium/safeLevelzhong_01.jpg");
			$(".strenght_H").children().attr("src","../images/proscenium/safeLevelqiang_01.jpg");
			
			var score = 0;
			if(password.length<=6){                          //长度<=6
				score += 1;
			}
			if(password.length>6&&password.length<=10){      //6<长度<=10
				score += 2;
			}
			if(password.length>10&&password.length<=16){    //<10长度<=16
				score += 3;
			}
			if(password.match(/([0-9])/)){           //包含数字
				score += 1;
			}
			if(password.match(/([a-z])/)){           //包含小写
				score += 1;
			}
			if(password.match(/([A-Z])/)){          //包含大写
				score += 1;
			}
			if(score<=3){                //低级密码
				$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_02.jpg");
			}
			if(score>=4&&score<=5){     //中级密码
				$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_02.jpg");
				$(".strenght_M").children().attr("src","../images/proscenium/safeLevelzhong_02.jpg");
			}
			if(score==6){              //高级密码
				$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_02.jpg");
				$(".strenght_M").children().attr("src","../images/proscenium/safeLevelzhong_02.jpg");
				$(".strenght_H").children().attr("src","../images/proscenium/safeLevelqiang_02.jpg");;
			}
		}
	},
});

