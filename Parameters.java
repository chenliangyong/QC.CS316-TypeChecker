import java.util.HashMap;

class Parameters
{
	Parameter parameter;
	Parameters parameters; // parameters is null at the end of the list.
	
	Parameters(Parameter p, Parameters ps)
	{
		parameter = p;
		parameters = ps;
	}
	
	void printParseTree(String indent)
	{
		parameter.printParseTree(indent);
		if ( parameters != null )
			parameters.printParseTree(indent);
	}
	   
    void buildTypeMaps(HashMap<String,TypeVal> funTypeMap, HashMap<String,HashMap<String,TypeVal>> paramTypeMap, HashMap<String,HashMap<Integer,TypeVal>> paramNumTypeMap, String anceFun , int pos){
       if(parameter != null) { 
         parameter.buildTypeMaps(funTypeMap, paramTypeMap, paramNumTypeMap, anceFun , ++pos);
       }
       if(parameters != null) {
         parameters.buildTypeMaps(funTypeMap, paramTypeMap, paramNumTypeMap, anceFun , pos);
       }
    }
}