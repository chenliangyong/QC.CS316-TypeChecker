
class DivE extends FunExp
{
	ExpList expList;
	
	DivE(ExpList e)
	{
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " /");
		expList.printParseTree(indent2);		
	}
	   
	   @Override
	   TypeVal typeEval() {
      if (expList != null) {
         TypeVal elist = expList.typeEval();
         
         if (elist == TypeVal.Int) {
            // System.out.println("~~~Div operand type: " + TypeVal.Int);
            return TypeVal.Int;
         } else if (elist == TypeVal.Float) {
            // System.out.println("~~~Div operand type: " + TypeVal.Float);
            return TypeVal.Float;
         } else {
            TypeChecker.displayln("Type Error: some arguments of Div'/' Operator have incompatible types.");
            return TypeVal.Error;
         }
      } else
         return TypeVal.Error;

   }
}