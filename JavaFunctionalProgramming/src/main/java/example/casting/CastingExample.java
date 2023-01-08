package example.casting;

public class CastingExample {

	public static void main(String[] args) {
		//with anonymous class
		CastingExample castExample = new CastingExample();
		castExample.myMethodA(new MyInterfaceA() {
			
			@Override
			public void doSomething() {
				System.out.println("I'm doing something");
			}
		});
		
		castExample.myMethodA(new MyInterfaceB() {
			
			@Override
			public void doAnotherThing() {
				System.out.println("I'm doing another thing");
			}
		});
		
		//using lamda expresions
		
		castExample.myMethodA((MyInterfaceA)() -> System.out.println("Doing something with lamda expresion"));
		castExample.myMethodA((MyInterfaceB)() -> System.out.println("Doing another thing with lamda expresion"));
		
		//with out the casting the code above throws:The method myMethodA(MyInterfaceA) is ambiguous for the type CastingExample
	}

	void myMethodA (MyInterfaceA implA) {
		implA.doSomething();
	}
	
	void myMethodA (MyInterfaceB implB) {
		implB.doAnotherThing();
	}
}



interface MyInterfaceA {
	void doSomething();
}

interface MyInterfaceB {
	void doAnotherThing();
}