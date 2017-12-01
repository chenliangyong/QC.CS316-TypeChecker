import java.util.HashMap;

class FunDef extends FunDefList
{
	Header header;
	Exp exp;
	
	FunDef(Header h, Exp e)
	{
		header = h;
		exp = e;
	}
	
	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		
		IO.displayln(indent + indent.length() + " <fun def>");		
		header.printParseTree(indent1);
		exp.printParseTree(indent1);
	}
	   
    void buildTypeMaps(HashMap<String,TypeVal> funTypeMap, HashMap<String,HashMap<String,TypeVal>> paramTypeMap, HashMap<String,HashMap<Integer,TypeVal>> paramNumTypeMap){
        header.buildTypeMaps(funTypeMap, paramTypeMap, paramNumTypeMap);  
    }

   TypeVal typeEval() {
      Exp.superFunName = header.funName;
      if (header!=null && exp!=null){
         //System.out.println("~~~~~ FunName: " + header.funName + "; Header type:[" + header.typeEval() + "]; Exp type:["+ exp.typeEval() + "] ~~~~~");
         if (header.typeEval() == exp.typeEval()){
            return TypeVal.Correct;
         }else{
            TypeChecker.displayln("Type Error: Incompatible return type and body expression type in function " + header.funName);
            return TypeVal.Error;
         }
      }
      return TypeVal.Error;
   }

}