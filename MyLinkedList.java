package bag;
import java.util.*;

 class Node{
	 Node next;
	 Node prev;
	 int value;
	 Node(int value){
		 this.value=value;
		 next=null;
		 prev=null;
	 }
}
 
public class MyLinkedList {
	Node head;
	Node tail;
	MyLinkedList(){
		head=null;
		tail=null;
	}
	
	public void pushBeginning(int value){
		Node push = new Node(value);
	    if(tail==null){
	    	head=push;	
	    }
	    else{
	    	tail.prev=push;
	    	push.next=tail;
	        tail=push;
	    }
	}
	
	public void pushEnd(int value){
		Node push=new Node(value);
		if(tail==null){
			tail=push;
		}
		else{
		    head.next=push;
		    push.prev=head;
		}
		 head=push;
	}
	
	public void popBeginning(){
		if(tail.next==null){
			head=null;
		}	
		else
			tail.next.prev=null;
		tail=tail.next;	
	}
	
	public void popEnd(){
		if(tail.next==null){
			tail=null;
		}
		else
		    head.prev.next=null;
		head=head.prev;
	}
	
    public void show(){
     	Node show=tail;
     	while(show!=null){
     		System.out.print(show.value + " ");
     		show=show.next;
     	}
    }
    
    public void pushList(int value,MyLinkedList list){
    	Node push=tail;
    	Node push1=null;
    	while(push.value!=value){
    		push=push.next;
    	}
    	push1=push.next;
    	push.next=list.tail;
        list.tail.prev=push;
        while(push.next!=null)
        	push=push.next;
        push.next=push1;
        if(push1!=null)
        	push1.prev=push;
    }
    
    
    /*public void popList(int value){
    	Node push=tail;
    	Node push1;
    	
    }*/
    
    public static void main(String[] args){
    	int numElem,elem,elem2;
    	int pick=1;
    	MyLinkedList list=new MyLinkedList();
    	MyLinkedList list1=new MyLinkedList();
    	Scanner scan=new Scanner(System.in);
    	while(pick!=0){
    		System.out.println("Select an action:");
    		System.out.println("_________________");
    		System.out.println("1.Sozdat' spisok");
    		System.out.println("2.Dobavit' element v nachalo");
    		System.out.println("3.Dobavit' element v konec");
    		System.out.println("4.Udalit' element iz nachala");
    		System.out.println("5.Udalit' element iz konca");
    		System.out.println("6.Vstavit' podspisok");
    		System.out.println("0.Exit");
    		pick=scan.nextInt();
    		switch(pick){
    			case 1:{
    				System.out.print("Vvedite kolichestvo elementov spiska:");
    				numElem=scan.nextInt();
    				for(int i=0;i<numElem;i++){
    					System.out.print("Vvedite"+ " " + (i+1) + " " + "element spiska:");
    					elem=scan.nextInt();
    					list.pushEnd(elem);
    				}
    				list.show();
    				System.out.println();
    				break;
    			}
    			case 2:{
    				System.out.print("Vvedite element dlya dobavleniya v nachalo:");
    				elem=scan.nextInt();
    				list.pushBeginning(elem);
    				list.show();
    				System.out.println();
    				break;
    			}
    			case 3:{
    				System.out.print("Vvedite element dlya dobavleniya v konec:");
    				elem=scan.nextInt();
    				list.pushEnd(elem);
    				list.show();
    				System.out.println();
    				break;
    	        }
    			case 4:{
    				System.out.print("Udalyaem element:");
    				list.popBeginning();
    				list.show();
    				System.out.println();
    				break;
    		    }
    		    case 5:{
    		    	System.out.print("Udalyaem element:");
    				list.popEnd();
    				list.show();
    				System.out.println();
    				break;
    		    }
    		    case 6:{
    		    	System.out.print("Vvedite kolichestvo elementov,kotoroe hotite dobavit':");
    		    	numElem=scan.nextInt();
    		    	System.out.print("Vvedite cifru,posle kotoroy hotite vstavit' podstoku:");
    		    	elem2=scan.nextInt();
    		    	for(int i=0;i<numElem;i++){
    		    		System.out.print("Vvedite"+ " " + (i+1) + " " + "element spiska:");
    					elem=scan.nextInt();
    					list1.pushEnd(elem);
    		    	}
    		    	list1.show();
    		    	System.out.println();
    		    	list.pushList(elem2,list1);
    		    	list.show();
    		    	System.out.println();
    		    	break;
    		    }
    		    case 0:{
    		    	break;
    		    }	
    	   }       
       }
    }
}    
