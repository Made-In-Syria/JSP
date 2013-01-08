import java.util.HashMap;


public class ExpressionNode extends TreeNode {

    public char type;	// 0:== 1:< 2:> 3:<= 4:>= 5:!=

    @Override
    public CallBack execute(HashMap<String, Value> vars) {
        Value v1 = childs.get(0).execute(vars).result;
        Value v2 = childs.get(1).execute(vars).result;


        switch (type) {
            case '=':
            	if (((Double) v1.Value).compareTo((Double) v2.Value) == 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));
            case '<':
            {
            	if(((Double) v1.Value).compareTo((Double) v2.Value) < 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));
            }
            case '>':
            	if(((Double) v1.Value).compareTo((Double) v2.Value) > 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));

            case 'g':
            	if(((Double) v1.Value).compareTo((Double) v2.Value) >= 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));
            case 'l':
            	if(((Double) v1.Value).compareTo((Double) v2.Value) <= 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));
            case '!':
            	if(((Double) v1.Value).compareTo((Double) v2.Value) != 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));
            case '+':
            {
            	if(v1.Type == 1 || v2.Type == 1 )
            		return new CallBack(Stop.normal,new Value(1, v1.Value.toString() + v2.Value.toString()));
                return new CallBack(Stop.normal,new Value(0, (Double) v1.Value + (Double) v2.Value));
            }
//          not
            case 'n':
            {
            	if (Math.round(((Double) v1.Value) * ((Double) v2.Value) )> 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(0)));
        		return new CallBack(Stop.normal,new Value(0, new Double(1)));
            }
            case '-':
                return new CallBack(Stop.normal,new Value(0, (Double) v1.Value - (Double) v2.Value));

            case '*':
                return new CallBack(Stop.normal,new Value(0, (Double) v1.Value * (Double) v2.Value));

            case '/':
                return new CallBack(Stop.normal,new Value(0, (Double) v1.Value / (Double) v2.Value));

            case '%':
                return new CallBack(Stop.normal,new Value(0, (Double) v1.Value % (Double) v2.Value));

            case '^':
                return new CallBack(Stop.normal,new Value(0, Math.pow((Double) v1.Value, (Double) v2.Value)));
            case 'a':
            	if(Math.round(((Double) v1.Value) * ((Double) v2.Value) )> 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));
            case 'o':
            	if(Math.round(((Double) v1.Value) + ((Double) v2.Value) )> 0)
            		return new CallBack(Stop.normal,new Value(0, new Double(1)));
        		return new CallBack(Stop.normal,new Value(0, new Double(0)));


        }
        return new CallBack(Stop.normal, null);
    }
}
