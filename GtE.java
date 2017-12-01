
class GtE extends FunExp
{
	ExpList expList;
	
	GtE(ExpList e)
	{
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " >");
		expList.printParseTree(indent2);		
	}
	   
	@Override
   TypeVal typeEval() {
	  //System.out.println("debug.."+ expList.typeEval());
	  //System.out.println("debug.."+ TypeChecker.paramTypeMap.get(Exp.superFunName));
	   
      if (expList.typeEval().isNumberType() || TypeChecker.paramTypeMap.get(Exp.superFunName).get(expList).isNumberType()) {
         return TypeVal.Boolean;
      } else {
         TypeChecker.displayln("Type Error: some arguments of GtE'>' operatior have incompatible types");
         return TypeVal.Error;
      }
   }
}
