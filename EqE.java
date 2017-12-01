

class EqE extends FunExp
{
	ExpList expList;
	
	EqE(ExpList e)
	{
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " =");
		expList.printParseTree(indent2);	
	}
	   
    @Override
    TypeVal typeEval() {
       if (expList!=null){
          TypeVal elist=expList.typeEval();
          if (elist.isNumberType() || TypeChecker.paramTypeMap.get(Exp.superFunName).get(expList).isNumberType()){
             return TypeVal.Boolean;
          }
          else if (elist == TypeVal.Boolean || TypeChecker.paramTypeMap.get(Exp.superFunName).get(expList)==TypeVal.Boolean){
             return TypeVal.Boolean;
          }
          else{
             TypeChecker.displayln("Type Error: some arguments of Eqe'=' operatior have incompatible types");
             return TypeVal.Error;
          }
       }
       TypeChecker.displayln("Type Error: some arguments of Eqe'=' operatior have incompatible types");
       return TypeVal.Error;
    }  
}