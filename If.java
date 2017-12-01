

class If extends Exp
{
	Exp exp1;
	Exp exp2;
	Exp exp3;
	
	If(Exp e1, Exp e2, Exp e3)
	{
		exp1 = e1;
		exp2 = e2;
		exp3 = e3;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " if");		
		exp1.printParseTree(indent2);
		IO.displayln(indent1 + indent1.length() + " then");
		exp2.printParseTree(indent2);
		IO.displayln(indent1 + indent1.length() + " else");
		exp3.printParseTree(indent2);
	}

   @Override
   TypeVal typeEval() {
      if (exp1!=null && exp2!=null){
         TypeVal ex1=exp1.typeEval();
         TypeVal ex2=exp2.typeEval();
         if (ex1 == TypeVal.Boolean || ex1 == TypeVal.Correct){
            //System.out.println("~~~IF EXP1 Fname: " + Exp.superFunName + "; Type: " + exp1.typeEval());
            if (exp3 == null){
               return ex2;
            }// return exp2's type, if don't have exp3;
            else{
               TypeVal ex3=exp3.typeEval();
               if (ex2 == TypeVal.Int && ex3 == TypeVal.Int){
                  //System.out.println("~~~IF EXP2 type: " + exp2.typeEval() + " ~~~IF EXP3 type: " + exp3.typeEval());
                  return TypeVal.Int;
               }
               else if (exp2.typeEval() == TypeVal.Float && exp3.typeEval() == TypeVal.Float){
                  //System.out.println("~~~IF EXP2 type: " + exp2.typeEval() + " ~~~IF EXP3 type: " + exp3.typeEval());
                  return TypeVal.Float;
               }
               else if (exp2.typeEval() == TypeVal.Boolean && exp3.typeEval() == TypeVal.Boolean){
                  //System.out.println("~~~IF EXP2 type: " + exp2.typeEval() + " ~~~IF EXP3 type: " + exp3.typeEval());
                  return TypeVal.Boolean;
               }
               else{
                  TypeChecker.displayln("Type Error: incompatible type found in conditional expression exp2[" + ex2 + "]/exp3["+ ex3+"]");
                  return TypeVal.Error;
               }
            }
         }
      }
      return TypeVal.Error;
   }
}