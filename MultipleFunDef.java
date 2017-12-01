import java.util.HashMap;

class MultipleFunDef extends FunDefList
{
	FunDef funDef;
	FunDefList funDefList;
	
	MultipleFunDef(FunDef fdef, FunDefList fdeflist)
	{
		funDef = fdef;
		funDefList = fdeflist;
	}
	
	void printParseTree(String indent)
	{
		funDef.printParseTree(indent);
		IO.displayln("\n--------------------\n");
		funDefList.printParseTree(indent);
	}
	
	void buildTypeMaps(HashMap<String,TypeVal> funTypeMap, HashMap<String,HashMap<String,TypeVal>> paramTypeMap, HashMap<String,HashMap<Integer,TypeVal>> paramNumTypeMap){
	   if (funDef!=null){
	      funDef.buildTypeMaps(funTypeMap, paramTypeMap, paramNumTypeMap);
	   }
	   if (funDefList!=null){
	      funDefList.buildTypeMaps(funTypeMap, paramTypeMap, paramNumTypeMap);
	   }
	}

   TypeVal typeEval() {
      if (funDef!=null && funDefList!=null){
         if (funDef.typeEval()==funDefList.typeEval()) return funDef.typeEval();
         else return TypeVal.Error;
      }
      else if (funDef!=null && funDefList==null) return funDef.typeEval();
      return TypeVal.Error;
   }
}