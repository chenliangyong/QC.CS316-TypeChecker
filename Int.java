

class Int extends Exp
{
	int intElem;
	
	Int(int i)
	{
		intElem = i;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp>");
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " " + intElem);
	}

   @Override
   TypeVal typeEval() {
      // TODO Auto-generated method stub
      return TypeVal.Int;
   }

   TypeVal typeEvalComp() {
      // TODO Auto-generated method stub
      return TypeVal.Correct;
   }
	
}