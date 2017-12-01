import java.util.HashMap;

class ParameterList
{
	Parameters parameters;
	
	ParameterList(Parameters ps)
	{
		parameters = ps;
	}
	
	void printParseTree(String indent)
	{
		parameters.printParseTree(indent);
	}
	   
    void buildTypeMaps(HashMap<String,TypeVal> funTypeMap, HashMap<String,HashMap<String,TypeVal>> paramTypeMap, HashMap<String,HashMap<Integer,TypeVal>> paramNumTypeMap,  String anceFun){
       if(parameters != null) { 
          parameters.buildTypeMaps(funTypeMap, paramTypeMap, paramNumTypeMap, anceFun , 0);  
       }
    }
}