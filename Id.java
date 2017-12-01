
class Id extends Exp
{
	String id;
	
	Id(String s)
	{
		id = s;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + id);
	}

   TypeVal typeEval() {    
      if (id != null){
          if(TypeChecker.paramTypeMap.get(Exp.superFunName)!= null){
            if (TypeChecker.paramTypeMap.get(Exp.superFunName).get(id)!=null){
               //System.out.println("~~~ Variable: "+ id + " type is [" + TypeChecker.paramTypeMap.get(Exp.superFunName).get(id) + "].");
               return TypeChecker.paramTypeMap.get(Exp.superFunName).get(id);
            }
            else
               System.out.println("Type Error: Can not get type of variable [" + id + "] .");
               return TypeVal.Error;
         }
      }
      return TypeVal.Error;
   }
	   

}