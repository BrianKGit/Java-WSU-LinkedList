public class MyLinkedListClient {

	public static void main(String [] args) {
	
		MyLinkedList<String> airportList = new MyLinkedList<String>();
		
      //add a few elements
      airportList.addFirst( "MSP" );
      airportList.addFirst( "RST" );
      airportList.addFirst( "ORD" );
      airportList.addFirst( "BOS" );
      airportList.addFirst( "ATL" );
      
      //traverse the list
      System.out.println( airportList.traverse() );
      
      try{
      //remove the first node
      System.out.println( airportList.removeFirst() + " is removed from the list" );
      }
      catch(EmptyListException e) {
         System.out.println( e );
      }
      
      //traverse the list
      System.out.println( airportList.traverse() );
		
      //sort the list
      airportList.selectionSort();
      
      //traverse the list
      System.out.println( airportList.traverse() );
      
		
	} //end main

}//end of class







