$.extend({
		/**
		 * ����ȼ�
		 * ���������score
		 * ����<=6 +1
		 * 6<����<=10  +1
		 * 10<����<=16 +1
		 * ��Сд +1
		 * ������ +1
		 * �д�д +1
		 * 
		 * score<=3 ��
		 * socre 4 5 ��
		 * score 6 ��
		 * 
		 */
	passwordStrength:function(){
		var password = $("#newPassword").val();
		var password_prompt = $("#newPW_prompt");
		$("#newPW_prompt").html("");
		//���ж����������Ƿ���ȷ��ֻ�ܰ������֡���Сд��ĸ
		var reg = /^[0-9a-zA-Z]{1,}$/;
		if(reg.test(password)==false){
			password_prompt.html("�����ʽ���ԣ���6-15λ��������ĸ��ϣ����ִ�Сд");
			password_prompt.attr("class","error_prompt");
			return false;
		}
		else{
			$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_01.jpg");
			$(".strenght_M").children().attr("src","../images/proscenium/safeLevelzhong_01.jpg");
			$(".strenght_H").children().attr("src","../images/proscenium/safeLevelqiang_01.jpg");
			
			var score = 0;
			if(password.length<=6){                          //����<=6
				score += 1;
			}
			if(password.length>6&&password.length<=10){      //6<����<=10
				score += 2;
			}
			if(password.length>10&&password.length<=16){    //<10����<=16
				score += 3;
			}
			if(password.match(/([0-9])/)){           //��������
				score += 1;
			}
			if(password.match(/([a-z])/)){           //����Сд
				score += 1;
			}
			if(password.match(/([A-Z])/)){          //������д
				score += 1;
			}
			if(score<=3){                //�ͼ�����
				$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_02.jpg");
			}
			if(score>=4&&score<=5){     //�м�����
				$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_02.jpg");
				$(".strenght_M").children().attr("src","../images/proscenium/safeLevelzhong_02.jpg");
			}
			if(score==6){              //�߼�����
				$(".strenght_L").children().attr("src","../images/proscenium/safeLevelruo_02.jpg");
				$(".strenght_M").children().attr("src","../images/proscenium/safeLevelzhong_02.jpg");
				$(".strenght_H").children().attr("src","../images/proscenium/safeLevelqiang_02.jpg");;
			}
		}
	},
});

