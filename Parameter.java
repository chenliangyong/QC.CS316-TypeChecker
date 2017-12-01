import java.util.HashMap;

class Parameter
{
	String type;
	String ident;
	
	Parameter(String t, String id)
	{
		type = t;
		ident = id;
	}
	
	void printParseTree(String indent)
	{
		IO.display(indent + indent.length() + " <parameter> " + type + " ");
		IO.displayln(ident);
	}
	   
    void buildTypeMaps(HashMap<String,TypeVal> funTypeMap, HashMap<String,HashMap<String,TypeVal>> paramTypeMap, HashMap<String,HashMap<Integer,TypeVal>> paramNumTypeMap, String anceFun , int pos){ 
       if (type!=null && ident!=null){
          if(!paramTypeMap.containsKey(anceFun)) {
             paramTypeMap.put(anceFun, new HashMap<>());
             paramNumTypeMap.put(anceFun, new HashMap<>());
          }
          paramTypeMap.get(anceFun).put(ident, TypeVal.toTypeVal(type));
          paramNumTypeMap.get(anceFun).put(pos, TypeVal.toTypeVal(type));
       }
    }
}