This is a simple javascript compiler, it has built with javacc, you can enter javascript code to it and it will execute it.

To print some thing use "print" command, and to read something use "read" command.

_Notice:_ it is not complete but it works well.

#here's some examples:

#1
`a = [1,2,1+1*2];
a[2] += 37;
print a[2];`

#2
`i = 5;
function f(a,b) {
  print a+3;
	for(i=0;i<b;i++)
	{
		if(i!=1)
		{
			print("i am inside if for " + i + "times");
		}
	}
}
f(i,4);`

#3
`function fib(i) {
  if ((i==1)||(i==0))
		return 1;
	else {
		return fib(i-1) + fib(i-2);		
		}
}
print fib(10);`



#4
`function ff() {
  function ff(){
		print "ff";
	}
	function inside() {
		return "inside";
	}
}
function f(){
	j = "asdf";
	k = new ff();
	function f(){
		print "f";
	}
}
i = new f();
ii = i.k;
print ii.inside();`

