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
    
    public void pushList(int value,MyLinkedList mylist){
    	Node push=tail;
    	Node push1=null;
    	while(push.value!=value){
    		push=push.next;
    	}
    	push1=push.next;
    	push.next=mylist.tail;
        mylist.tail.prev=push;
        mylist.tail=tail;
        while(push.next!=null)
        	push=push.next;
        push.next=push1;
        if(push1!=null){
        	push1.prev=push;
        	head=push1;
        	mylist.head=head;
        }
        else{
        	head=push;
        	mylist.head=head;
        }
        
    }
    
    
    public void popList(int value){
    	Node push=head;
    	Node push1=null;
    	if(head.value==value){}
    	else{	
    		while(push.prev.value!=value){
    			push1=push;
    			push=push.prev;
    		}
    		if(push1!=null){
    			push1.prev=push.prev;
    			push.prev.next=push1;
    			push.prev=null;
    			push.next=null;
    		}
    		else{
    			head=push.prev;
    			head.next=null;
    		}
    	}
    }
    
    
    /*public void sortList(MyLinkedList myList){
    	Node sort=myList.tail;
    	Node swtch=null; 
    	int min=myList.tail.value;
    	Node beg=myList.tail;
    	while(beg!=null){
    		while(sort!=null){
    			if(sort.value<min){
    				min=sort.value;
    				swtch=sort;
    			}		
    			sort=sort.next;
    		}
    		if(sort!=null)
    			swtch.value=sort.value;
    		beg.value=min;
    		if(beg.next!=null){
    			beg=beg.next;
    			sort=beg;
    			min=beg.value;
    		
    		}
    	}
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
    		System.out.println("7.Udalit' podspisok");
    		System.out.println("8.Otsortirovat' spisok");
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
    		    	break;
    		    }
    		    case 7:{
    		    	System.out.print("Vvedite kolichestvo elementov,kotoroe hotite udalit':");
    		    	numElem=scan.nextInt();
    		    	System.out.print("Vvedite cifru,posle kotoroy hotite udalit' podstoku:");
    		    	elem2=scan.nextInt();
    		    	for(int i=0;i<numElem;i++)
    		    		list.popList(elem2);
    		    	list.show();
    		    	System.out.println();
    		    	break;
    		    }
    		    case 8:{
    				list.sortList(list);
    				list.show();
    				System.out.println();
    		    	break;
    		    }
    		    case 9:{
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
