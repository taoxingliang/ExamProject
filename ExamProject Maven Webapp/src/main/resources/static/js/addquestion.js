function $(elementId){
    return document.getElementById(elementId);
}

function isQuestiontypeNull(){
	var questiontype = $("question_type");
	if (questiontype.value="0") {
		$("question_typeid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isQuestionlevelNull(){
	var questionlevel = $("question_level");
	if (questionlevel.value="0") {
		$("question_levelid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isQuestionNull(){
	var question = $("question");
	if (question.value="") {
		$("questionid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isQuestionAnswerNull(){
	var question_answer = $("question_answer");
	if (question_answer.value="0") {
		$("question_answerid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isselectANull(){
	var select_A = $("select_A");
	if (select_A.value="") {
		$("select_Aid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isselectBNull(){
	var select_B = $("select_B");
	if (select_B.value="") {
		$("select_Bid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isselectCNull(){
	var select_C = $("select_C");
	if (select_C.value="") {
		$("select_Cid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isselectDNull(){
	var select_D = $("select_D");
	if (select_D.value="") {
		$("select_Did").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isanalysisNull(){
	var analysis = $("analysis");
	if (analysis.value="") {
		$("analysisid").innerHTML="不能为空";
		return false;
	}
	return true;
}
function isNull(){
	isQuestiontypeNull=isQuestiontypeNull();
	isQuestionlevelNull=isQuestionlevelNull();
	isQuestionNull=isQuestionNull();
	isQuestionAnswerNull=isQuestionAnswerNull();
	isselectANull=isselectANull();
	isselectBNull=isselectBNull();
	isselectCNull=isselectCNull();
	isselectDNull=isselectDNull();
	isanalysisNull=isanalysisNull();
	if (isQuestiontypeNull==true && isQuestionlevelNull==true && isQuestionNull==true
			&& isQuestionAnswerNull==true && isselectANull==true
			&& isselectBNull==true && isselectCNull==true
			&& isselectDNull==true && isanalysisNull==true) {
		return true;
	}
	return false;
}