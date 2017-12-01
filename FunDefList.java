import java.util.HashMap;

abstract class FunDefList
{
	abstract void printParseTree(String indent);
	abstract void buildTypeMaps(HashMap<String,TypeVal> funTypeMap, HashMap<String,HashMap<String,TypeVal>> paramTypeMap, HashMap<String,HashMap<Integer,TypeVal>> paramNumTypeMap);
	abstract TypeVal typeEval();
}