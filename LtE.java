
class LtE extends FunExp
{
	ExpList expList;
	
	LtE(ExpList e)
	{
		expList = e;
	}
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " <");
		expList.printParseTree(indent2);		
	}
	@Override
   TypeVal typeEval() {
      if (expList.typeEval().isNumberType()
            || TypeChecker.paramTypeMap.get(Exp.superFunName).get(expList).isNumberType()) {
         return TypeVal.Boolean;
      } else {
         TypeChecker.displayln("Type Error: some arguments of LtE'<' operatior have incompatible types");
         return TypeVal.Error;
      }
   }

}