
class ExpList
{
	Exp exp;
	ExpList expList; // expList is null at the end of the list.
	
	ExpList(Exp e, ExpList el)
	{
		exp = e;
		expList = el;
	}
		
	void printParseTree(String indent)
	{
		exp.printParseTree(indent);
		if ( expList != null )
			expList.printParseTree(indent);	
	}
	   
	TypeVal typeEval() {
	   if (exp==null && expList==null){
	      return TypeVal.Error;
	   }
	   TypeVal ex=exp.typeEval(); // run only once
	   if (expList==null){
	      return ex;
	   } 
	   TypeVal elist=expList.typeEval(); // run only once
	   
	   if (ex==elist || (ex.isNumberType() && elist.isNumberType())){
	      //System.out.println("~~~ExpList : exp - " + exp.typeEval() + ", expList - " + expList.typeEval());
	      return ex;
	   }else{
	      return TypeVal.Error;
	   }
	}

/*   TypeVal typeEvalForComp(int counter) {
      if (exp == null && expList == null) {
         return null;
      }
      if (expList == null && (exp.typeEval() == TypeVal.Int || exp.typeEval() == TypeVal.Float)) {
         return exp.typeEval();
      }
      if (exp!=null && expList!=null){
         counter++;
         if ((exp.typeEval()== TypeVal.Int || exp.typeEval() == TypeVal.Float) && (expList.typeEvalForComp(counter) == TypeVal.Int || expList.typeEvalForComp(counter) == TypeVal.Float)){
            return TypeVal.Float;
         } 
      }else{
         return TypeVal.Error;
      }
      return TypeVal.Error;     
   }*/
   
/*   TypeVal typeEvalForEqE(){
      if (exp == null && expList == null) {
         System.out.println("Type Error: Eqe '=' Operand missing.");
         return TypeVal.Error;
      }   
      if (expList == null && (exp.typeEval() == TypeVal.Int || exp.typeEval() == TypeVal.Float || exp.typeEval() == TypeVal.Boolean)){
         //System.out.println("~~~Eqe operand type: " + exp.typeEval());
         return TypeVal.Correct;
      }
      if ((exp.typeEval() == TypeVal.Int || exp.typeEval() == TypeVal.Float) && (expList.typeEvalForEqE() == TypeVal.Int || expList.typeEvalForEqE() == TypeVal.Float)){
         return TypeVal.Correct;
      }else if(exp.typeEval() == TypeVal.Boolean && expList.typeEvalForEqE() == TypeVal.Boolean){
         return TypeVal.Boolean;
      }else{
         System.out.println("Type Error: Eqe '=' Operand type error.");
         return TypeVal.Error;
      }  
   }*/
}