
class FunCall extends FunExp
{
	String funName;
	ExpList expList; // expList is null if <exp list> is empty.
	
	FunCall(String s, ExpList e)
	{
		funName = s;
		expList = e;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent + indent.length() + " <exp>");
		IO.displayln(indent1 + indent1.length() + " <fun exp>");
		IO.displayln(indent2 + indent2.length() + " " + funName);
		if ( expList != null )
			expList.printParseTree(indent2);
	}
	   


   @Override
   TypeVal typeEval() {
      
      if(funName!=null){
         if (TypeChecker.funTypeMap.containsKey(funName)){
            //System.out.println("~~~FunCall Function Name : " + funName);
            // return function type with parameters.
            if (expList!=null){
               TypeVal elist = expList.typeEval();//run one time only
               if(TypeChecker.paramTypeMap.get(funName).containsValue(elist)){
                  //System.out.println("~~~FunCall type: " + TypeChecker.paramNumTypeMap.get(funName).values() + expList.typeEval());
                  return elist;
               }
               else{
                  TypeChecker.displayln("Type Error: incompatible type for parameter " + TypeChecker.paramTypeMap.get(funName));
                  return TypeVal.Error;
               }
            }else{
               // return function type which function don't need the parameters.
               return TypeChecker.funTypeMap.get(funName);
            }    
         }
         else{
            //System.out.println("Type Error: FunCall Operand type error.");
            return TypeVal.Error;
         }
      }
      return TypeVal.Error;
   }
}