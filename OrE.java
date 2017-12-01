
class OrE extends FunExp
{
	ExpList expList;
	
	OrE(ExpList e)
	{
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " or");
		expList.printParseTree(indent2);	
	}
	   
   @Override
   TypeVal typeEval() {
      if (expList != null) {
         TypeVal elist = expList.typeEval();
         if (elist == TypeVal.Boolean)
            return TypeVal.Boolean;
         else
            TypeChecker.displayln("Type Error: some arguments of OR operatior have incompatible types");
            return TypeVal.Error;
      } else
         TypeChecker.displayln("Type Error: some arguments of OR operatior have incompatible types");
         return TypeVal.Error;
   }
}