function $(elementId){
    return document.getElementById(elementId);
}

function isNull(){
	var flag;
	isQuestiontypeNull1=isQuestiontypeNull();
	if (isQuestiontypeNull1==false) {
		return false;
	}
	isQuestionlevelNull1=isQuestionlevelNull();
	if (isQuestionlevelNull1==false) {
		return false;
	}
	isQuestionNull1=isQuestionNull();
	if (isQuestionNull1==false) {
		return false;
	}
	isQuestionAnswerNull1=isQuestionAnswerNull();
	if (isQuestionAnswerNull1==false) {
		return false;
	}
	isselectANull1=isselectANull();
	if (isselectANull1==false) {
		return false;
	}
	isselectBNull1=isselectBNull();
	if (isselectBNull1==false) {
		return false;
	}
	isselectCNull1=isselectCNull();
	if (isselectCNull1==false) {
		return false;
	}
	isselectDNull1=isselectDNull();
	if (isselectDNull1==false) {
		return false;
	}
	isanalysisNull1=isanalysisNull();
	if (isanalysisNull1==false) {
		return false;
	}
	
	return true;
}
function isQuestiontypeNull(){
	var questiontype = $("question_type");
	if (questiontype.value=="0") {
		$("question_typeid").innerHTML="不能为空";
		$("question_typeid").className="error_msg";
		return false;
	} else {
		$("question_typeid").innerHTML="";
		return true;
	}
}
function isQuestionlevelNull(){
	var questionlevel = $("question_level");
	if (questionlevel.value=="0") {
		$("question_levelid").innerHTML="不能为空";
		$("question_levelid").className="error_msg";
		return false;
	} else {
		$("question_levelid").innerHTML="";
		return true;
	}
}
function isQuestionNull(){
	var question = $("question");
	if (question.value=="") {
		$("questionid").innerHTML="不能为空";
		$("questionid").className="error_msg";
		return false;
	} else {
		$("questionid").innerHTML="";
		return true;
	}
}
function isQuestionAnswerNull(){
	var question_answer = $("question_answer");
	if (question_answer.value=="0") {
		$("question_answerid").innerHTML="不能为空";
		$("question_answerid").className="error_msg";
		return false;
	} else {
		$("question_answerid").innerHTML="";
		return true;
	}
}
function isselectANull(){
	var select_A = $("select_A");
	if (select_A.value=="") {
		$("select_Aid").className="error_msg";
		$("select_Aid").innerHTML="不能为空";
		return false;
	} else {
		$("select_Aid").innerHTML="";
		return true;
	}
}
function isselectBNull(){
	var select_B = $("select_B");
	if (select_B.value=="") {
		$("select_Bid").className="error_msg";
		$("select_Bid").innerHTML="不能为空";
		return false;
	} else {
		$("select_Bid").innerHTML="";
		return true;
	}
}
function isselectCNull(){
	var select_C = $("select_C");
	if (select_C.value=="") {
		$("select_Cid").className="error_msg";
		$("select_Cid").innerHTML="不能为空";
		return false;
	} else {
		$("select_Cid").innerHTML="";
		return true;
	}
}
function isselectDNull(){
	var select_D = $("select_D");
	if (select_D.value=="") {
		$("select_Did").className="error_msg";
		$("select_Did").innerHTML="不能为空";
		return false;
	} else {
		$("select_Did").innerHTML="";
		return true;
	}
}
function isanalysisNull(){
	var analysis = $("analysis");
	if (analysis.value=="") {
		$("analysisid").className="error_msg";
		$("analysisid").innerHTML="不能为空";
		return false;
	} else {
		$("analysisid").innerHTML="";
		return true;
	}
}