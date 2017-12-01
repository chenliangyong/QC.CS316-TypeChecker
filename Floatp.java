

class Floatp extends Exp
{
	float floatElem;
	
	Floatp(float f)
	{
		floatElem = f;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + floatElem);
	}

   @Override
   TypeVal typeEval() {      
      return TypeVal.Float;
   }
   TypeVal typeEvalComp() {
      return TypeVal.Correct;
   }   

}